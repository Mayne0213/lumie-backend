package com.lumie.tenant.adapter.in.messaging;

import com.lumie.messaging.config.RabbitMqConstants;
import com.lumie.messaging.event.TenantCreatedEvent;
import com.lumie.tenant.application.service.SchemaProvisioningService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TenantEventListener {

    private final SchemaProvisioningService schemaProvisioningService;

    @RabbitListener(queues = RabbitMqConstants.TENANT_SCHEMA_PROVISIONING_QUEUE)
    public void handleTenantCreated(TenantCreatedEvent event) {
        log.info("Received TenantCreatedEvent: tenant={}, eventId={}",
                event.getSlug(), event.getEventId());

        try {
            schemaProvisioningService.provisionTenantSchema(event);
            log.info("Successfully processed TenantCreatedEvent for tenant: {}", event.getSlug());
        } catch (Exception e) {
            log.error("Failed to process TenantCreatedEvent for tenant: {}", event.getSlug(), e);
            throw e;
        }
    }
}
