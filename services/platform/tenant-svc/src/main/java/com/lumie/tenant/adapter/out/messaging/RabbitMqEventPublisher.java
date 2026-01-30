package com.lumie.tenant.adapter.out.messaging;

import com.lumie.common.domain.DomainEvent;
import com.lumie.messaging.config.RabbitMqConstants;
import com.lumie.messaging.event.TenantEvent;
import com.lumie.tenant.application.port.out.EventPublisherPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMqEventPublisher implements EventPublisherPort {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(DomainEvent event) {
        if (event instanceof TenantEvent tenantEvent) {
            String routingKey = tenantEvent.getRoutingKey();
            log.info("Publishing event: {} with routing key: {}", event.getEventType(), routingKey);

            rabbitTemplate.convertAndSend(
                    RabbitMqConstants.LUMIE_EVENTS_EXCHANGE,
                    routingKey,
                    event
            );

            log.info("Event published successfully: {}", event.getEventId());
        } else {
            log.warn("Unknown event type: {}", event.getClass().getName());
        }
    }
}
