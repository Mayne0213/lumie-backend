package com.lumie.common.domain;

import java.time.Instant;
import java.util.UUID;

public interface DomainEvent {

    UUID getEventId();

    Instant getOccurredAt();

    String getEventType();
}
