package com.lumie.tenant.adapter.out.persistence;

import com.lumie.tenant.domain.entity.TenantSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantSettingsJpaRepository extends JpaRepository<TenantSettings, Long> {
    Optional<TenantSettings> findByTenantId(Long tenantId);
}
