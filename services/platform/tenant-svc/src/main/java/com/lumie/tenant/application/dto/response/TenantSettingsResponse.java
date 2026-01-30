package com.lumie.tenant.application.dto.response;

import com.lumie.tenant.domain.entity.TenantSettings;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
public record TenantSettingsResponse(
        Long id,
        String slug,
        String logoUrl,
        Map<String, Object> theme,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static TenantSettingsResponse from(TenantSettings settings) {
        return TenantSettingsResponse.builder()
                .id(settings.getId())
                .slug(settings.getTenant().getSlugValue())
                .logoUrl(settings.getLogoUrl())
                .theme(settings.getTheme())
                .createdAt(settings.getCreatedAt())
                .updatedAt(settings.getUpdatedAt())
                .build();
    }
}
