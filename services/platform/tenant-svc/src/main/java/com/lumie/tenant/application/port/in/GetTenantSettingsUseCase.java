package com.lumie.tenant.application.port.in;

import com.lumie.tenant.application.dto.response.TenantSettingsResponse;

public interface GetTenantSettingsUseCase {
    TenantSettingsResponse getSettings(String slug);
}
