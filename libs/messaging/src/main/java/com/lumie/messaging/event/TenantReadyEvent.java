package com.lumie.messaging.event;

import lombok.Getter;

@Getter
public class TenantReadyEvent extends TenantEvent {

    private final String schemaName;

    public TenantReadyEvent(Long tenantId, String slug, String schemaName) {
        super(tenantId, slug);
        this.schemaName = schemaName;
    }

    @Override
    public String getRoutingKey() {
        return String.format("tenant.ready.%s", getSlug());
    }
}
