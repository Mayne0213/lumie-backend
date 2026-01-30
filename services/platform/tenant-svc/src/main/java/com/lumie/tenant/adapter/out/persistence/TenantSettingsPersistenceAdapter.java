package com.lumie.tenant.adapter.out.persistence;

import com.lumie.tenant.application.port.out.TenantSettingsPersistencePort;
import com.lumie.tenant.domain.entity.TenantSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TenantSettingsPersistenceAdapter implements TenantSettingsPersistencePort {

    private final TenantSettingsJpaRepository tenantSettingsJpaRepository;

    @Override
    public TenantSettings save(TenantSettings settings) {
        return tenantSettingsJpaRepository.save(settings);
    }

    @Override
    public Optional<TenantSettings> findByTenantId(Long tenantId) {
        return tenantSettingsJpaRepository.findByTenantId(tenantId);
    }
}
