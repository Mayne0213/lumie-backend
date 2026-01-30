package com.lumie.tenant.application.dto.response;

import com.lumie.tenant.domain.entity.Tenant;
import com.lumie.tenant.domain.vo.TenantPlan;
import com.lumie.tenant.domain.vo.TenantStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TenantResponse(
        Long id,
        String slug,
        String name,
        String displayName,
        TenantStatus status,
        TenantPlan plan,
        String schemaName,
        String ownerEmail,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static TenantResponse from(Tenant tenant) {
        return TenantResponse.builder()
                .id(tenant.getId())
                .slug(tenant.getSlugValue())
                .name(tenant.getName())
                .displayName(tenant.getDisplayName())
                .status(tenant.getStatus())
                .plan(tenant.getPlan())
                .schemaName(tenant.getSchemaName())
                .ownerEmail(tenant.getOwnerEmail())
                .createdAt(tenant.getCreatedAt())
                .updatedAt(tenant.getUpdatedAt())
                .build();
    }
}
