package com.lumie.tenant.application.port.out;

import com.lumie.tenant.domain.entity.TenantSettings;

import java.util.Optional;

public interface TenantSettingsPersistencePort {
    TenantSettings save(TenantSettings settings);
    Optional<TenantSettings> findByTenantId(Long tenantId);
}
