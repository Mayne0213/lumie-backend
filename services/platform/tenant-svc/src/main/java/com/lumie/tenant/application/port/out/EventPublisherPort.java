package com.lumie.tenant.application.port.out;

import com.lumie.common.domain.DomainEvent;

public interface EventPublisherPort {
    void publish(DomainEvent event);
}
