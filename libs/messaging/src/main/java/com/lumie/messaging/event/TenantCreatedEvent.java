package com.lumie.messaging.event;

import lombok.Getter;

@Getter
public class TenantCreatedEvent extends TenantEvent {

    private final String tenantName;

    public TenantCreatedEvent(Long tenantId, String slug, String tenantName) {
        super(tenantId, slug);
        this.tenantName = tenantName;
    }

    @Override
    public String getRoutingKey() {
        return String.format("tenant.created.%s", getSlug());
    }
}
