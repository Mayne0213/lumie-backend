package com.lumie.tenant.application.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UpdateTenantRequest(
        @Size(max = 100, message = "Name must be at most 100 characters")
        String name,

        @Size(max = 200, message = "Display name must be at most 200 characters")
        String displayName
) {
}
