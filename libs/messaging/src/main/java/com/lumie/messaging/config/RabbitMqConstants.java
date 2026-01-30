package com.lumie.messaging.config;

public final class RabbitMqConstants {

    private RabbitMqConstants() {
    }

    // Exchanges
    public static final String LUMIE_EVENTS_EXCHANGE = "lumie.events";
    public static final String LUMIE_DLX_EXCHANGE = "lumie.dlx";

    // Queues
    public static final String TENANT_SCHEMA_PROVISIONING_QUEUE = "tenant.schema-provisioning";
    public static final String TENANT_SCHEMA_PROVISIONING_DLQ = "tenant.schema-provisioning.dlq";

    // Routing Keys
    public static final String TENANT_CREATED_ROUTING_KEY = "tenant.created.*";
    public static final String TENANT_READY_ROUTING_KEY = "tenant.ready.*";
}
