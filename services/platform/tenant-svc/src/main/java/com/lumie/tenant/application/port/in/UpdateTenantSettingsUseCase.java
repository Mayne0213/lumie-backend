package com.lumie.tenant.application.port.in;

import com.lumie.tenant.application.dto.request.TenantSettingsRequest;
import com.lumie.tenant.application.dto.response.TenantSettingsResponse;

public interface UpdateTenantSettingsUseCase {
    TenantSettingsResponse updateSettings(String slug, TenantSettingsRequest request);
}
