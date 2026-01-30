package com.lumie.tenant.application.service;

import com.lumie.messaging.event.TenantCreatedEvent;
import com.lumie.messaging.event.TenantReadyEvent;
import com.lumie.tenant.application.port.out.EventPublisherPort;
import com.lumie.tenant.application.port.out.SchemaProvisioningPort;
import com.lumie.tenant.application.port.out.TenantPersistencePort;
import com.lumie.tenant.domain.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchemaProvisioningService {

    private final TenantPersistencePort tenantPersistencePort;
    private final SchemaProvisioningPort schemaProvisioningPort;
    private final EventPublisherPort eventPublisherPort;

    @Transactional
    public void provisionTenantSchema(TenantCreatedEvent event) {
        log.info("Starting schema provisioning for tenant: {}", event.getSlug());

        Tenant tenant = tenantPersistencePort.findBySlug(event.getSlug())
                .orElseThrow(() -> new IllegalStateException("Tenant not found: " + event.getSlug()));

        tenant.startProvisioning();
        tenantPersistencePort.save(tenant);

        String schemaName = tenant.getSchemaName();

        try {
            if (!schemaProvisioningPort.schemaExists(schemaName)) {
                schemaProvisioningPort.createSchema(schemaName);
                log.info("Schema created: {}", schemaName);
            }

            schemaProvisioningPort.migrateSchema(schemaName);
            log.info("Schema migration completed: {}", schemaName);

            tenant.activate();
            tenantPersistencePort.save(tenant);

            TenantReadyEvent readyEvent = new TenantReadyEvent(
                    tenant.getId(),
                    tenant.getSlugValue(),
                    schemaName
            );
            eventPublisherPort.publish(readyEvent);

            log.info("Tenant schema provisioning completed: {}", event.getSlug());

        } catch (Exception e) {
            log.error("Failed to provision schema for tenant: {}", event.getSlug(), e);
            throw new RuntimeException("Schema provisioning failed", e);
        }
    }
}
