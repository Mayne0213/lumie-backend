package com.lumie.tenant.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.lumie.tenant.adapter.out.persistence")
public class JpaConfig {
}
