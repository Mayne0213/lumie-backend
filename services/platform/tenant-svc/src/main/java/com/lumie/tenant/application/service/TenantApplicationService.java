package com.lumie.tenant.application.service;

import com.lumie.common.exception.DuplicateResourceException;
import com.lumie.common.exception.ResourceNotFoundException;
import com.lumie.common.util.SlugValidator;
import com.lumie.messaging.event.TenantCreatedEvent;
import com.lumie.messaging.event.TenantSuspendedEvent;
import com.lumie.tenant.application.dto.request.CreateTenantRequest;
import com.lumie.tenant.application.dto.request.UpdateTenantRequest;
import com.lumie.tenant.application.dto.response.TenantResponse;
import com.lumie.tenant.application.port.in.*;
import com.lumie.tenant.application.port.out.EventPublisherPort;
import com.lumie.tenant.application.port.out.TenantPersistencePort;
import com.lumie.tenant.domain.entity.Tenant;
import com.lumie.tenant.infrastructure.exception.TenantErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TenantApplicationService implements
        CreateTenantUseCase,
        GetTenantUseCase,
        UpdateTenantUseCase,
        DeleteTenantUseCase,
        ValidateTenantUseCase,
        SuspendTenantUseCase {

    private final TenantPersistencePort tenantPersistencePort;
    private final EventPublisherPort eventPublisherPort;

    @Override
    @Transactional
    public TenantResponse createTenant(CreateTenantRequest request) {
        log.info("Creating tenant with slug: {}", request.slug());

        validateSlug(request.slug());

        if (tenantPersistencePort.existsBySlug(request.slug())) {
            throw new DuplicateResourceException("Tenant", request.slug());
        }

        Tenant tenant = Tenant.create(
                request.slug(),
                request.name(),
                request.displayName(),
                request.ownerEmail()
        );

        Tenant savedTenant = tenantPersistencePort.save(tenant);
        log.info("Tenant created with ID: {}, slug: {}", savedTenant.getId(), savedTenant.getSlugValue());

        TenantCreatedEvent event = new TenantCreatedEvent(
                savedTenant.getId(),
                savedTenant.getSlugValue(),
                savedTenant.getName()
        );
        eventPublisherPort.publish(event);
        log.info("Published TenantCreatedEvent for tenant: {}", savedTenant.getSlugValue());

        return TenantResponse.from(savedTenant);
    }

    @Override
    public TenantResponse getTenantById(Long id) {
        return tenantPersistencePort.findById(id)
                .map(TenantResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", id));
    }

    @Override
    public TenantResponse getTenantBySlug(String slug) {
        return tenantPersistencePort.findBySlug(slug)
                .map(TenantResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));
    }

    @Override
    public List<TenantResponse> getAllTenants() {
        return tenantPersistencePort.findAll().stream()
                .map(TenantResponse::from)
                .toList();
    }

    @Override
    @Transactional
    public TenantResponse updateTenant(String slug, UpdateTenantRequest request) {
        log.info("Updating tenant with slug: {}", slug);

        Tenant tenant = tenantPersistencePort.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));

        tenant.updateInfo(request.name(), request.displayName());
        Tenant updatedTenant = tenantPersistencePort.save(tenant);

        log.info("Tenant updated: {}", slug);
        return TenantResponse.from(updatedTenant);
    }

    @Override
    @Transactional
    public void deleteTenant(String slug) {
        log.info("Deleting tenant with slug: {}", slug);

        Tenant tenant = tenantPersistencePort.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));

        tenant.markAsDeleted();
        tenantPersistencePort.save(tenant);

        log.info("Tenant marked as deleted: {}", slug);
    }

    @Override
    public boolean isValidAndActive(String slug) {
        return tenantPersistencePort.findBySlug(slug)
                .map(Tenant::isActive)
                .orElse(false);
    }

    @Override
    public Long getTenantIdBySlug(String slug) {
        return tenantPersistencePort.findBySlug(slug)
                .map(Tenant::getId)
                .orElse(null);
    }

    @Override
    @Transactional
    public TenantResponse suspendTenant(String slug, String reason) {
        log.info("Suspending tenant: {} with reason: {}", slug, reason);

        Tenant tenant = tenantPersistencePort.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));

        tenant.suspend();
        Tenant savedTenant = tenantPersistencePort.save(tenant);

        TenantSuspendedEvent event = new TenantSuspendedEvent(
                savedTenant.getId(),
                savedTenant.getSlugValue(),
                reason
        );
        eventPublisherPort.publish(event);
        log.info("Published TenantSuspendedEvent for tenant: {}", slug);

        return TenantResponse.from(savedTenant);
    }

    @Override
    @Transactional
    public TenantResponse reactivateTenant(String slug) {
        log.info("Reactivating tenant: {}", slug);

        Tenant tenant = tenantPersistencePort.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));

        tenant.reactivate();
        Tenant savedTenant = tenantPersistencePort.save(tenant);

        log.info("Tenant reactivated: {}", slug);
        return TenantResponse.from(savedTenant);
    }

    private void validateSlug(String slug) {
        if (!SlugValidator.isValid(slug)) {
            throw new IllegalArgumentException("Invalid slug format: " + slug);
        }
        if (SlugValidator.isReserved(slug)) {
            throw new IllegalArgumentException("Reserved slug: " + slug);
        }
    }
}
