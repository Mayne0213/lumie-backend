package com.lumie.tenant.application.dto.request;

import jakarta.validation.constraints.Size;

import java.util.Map;

public record TenantSettingsRequest(
        @Size(max = 500, message = "Logo URL must not exceed 500 characters")
        String logoUrl,
        Map<String, Object> theme
) {
}
