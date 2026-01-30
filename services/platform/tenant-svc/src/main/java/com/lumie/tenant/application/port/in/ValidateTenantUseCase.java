package com.lumie.tenant.application.port.in;

public interface ValidateTenantUseCase {
    boolean isValidAndActive(String slug);
    Long getTenantIdBySlug(String slug);
}
