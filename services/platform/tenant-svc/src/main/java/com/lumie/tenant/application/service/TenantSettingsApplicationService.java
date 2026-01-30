package com.lumie.tenant.application.service;

import com.lumie.common.exception.ResourceNotFoundException;
import com.lumie.tenant.application.dto.request.TenantSettingsRequest;
import com.lumie.tenant.application.dto.response.TenantSettingsResponse;
import com.lumie.tenant.application.port.in.GetTenantSettingsUseCase;
import com.lumie.tenant.application.port.in.UpdateTenantSettingsUseCase;
import com.lumie.tenant.application.port.out.TenantPersistencePort;
import com.lumie.tenant.application.port.out.TenantSettingsPersistencePort;
import com.lumie.tenant.domain.entity.Tenant;
import com.lumie.tenant.domain.entity.TenantSettings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TenantSettingsApplicationService implements GetTenantSettingsUseCase, UpdateTenantSettingsUseCase {

    private final TenantPersistencePort tenantPersistencePort;
    private final TenantSettingsPersistencePort tenantSettingsPersistencePort;

    @Override
    public TenantSettingsResponse getSettings(String slug) {
        log.debug("Getting settings for tenant: {}", slug);

        Tenant tenant = tenantPersistencePort.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));

        TenantSettings settings = tenantSettingsPersistencePort.findByTenantId(tenant.getId())
                .orElseGet(() -> createDefaultSettings(tenant));

        return TenantSettingsResponse.from(settings);
    }

    @Override
    @Transactional
    public TenantSettingsResponse updateSettings(String slug, TenantSettingsRequest request) {
        log.info("Updating settings for tenant: {}", slug);

        Tenant tenant = tenantPersistencePort.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant", slug));

        TenantSettings settings = tenantSettingsPersistencePort.findByTenantId(tenant.getId())
                .orElseGet(() -> createDefaultSettings(tenant));

        settings.update(request.logoUrl(), request.theme());
        TenantSettings savedSettings = tenantSettingsPersistencePort.save(settings);

        log.info("Settings updated for tenant: {}", slug);
        return TenantSettingsResponse.from(savedSettings);
    }

    private TenantSettings createDefaultSettings(Tenant tenant) {
        TenantSettings settings = TenantSettings.createDefault(tenant);
        return tenantSettingsPersistencePort.save(settings);
    }
}
