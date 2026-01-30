package com.lumie.tenant.domain.vo;

public enum TenantPlan {
    FREE,
    BASIC,
    PRO,
    ENTERPRISE;

    public boolean supportsCustomDomains() {
        return this == PRO || this == ENTERPRISE;
    }

    public boolean supportsAdvancedAnalytics() {
        return this == PRO || this == ENTERPRISE;
    }

    public boolean supportsPrioritySupport() {
        return this == ENTERPRISE;
    }
}
