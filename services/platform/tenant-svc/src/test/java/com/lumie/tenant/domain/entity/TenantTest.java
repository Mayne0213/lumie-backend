package com.lumie.tenant.domain.entity;

import com.lumie.tenant.domain.vo.TenantStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TenantTest {

    @Test
    @DisplayName("Tenant 생성 시 PENDING 상태")
    void createTenantWithPendingStatus() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", "테스트 학원", "owner@test.com");

        assertThat(tenant.getSlugValue()).isEqualTo("test-academy");
        assertThat(tenant.getName()).isEqualTo("Test Academy");
        assertThat(tenant.getDisplayName()).isEqualTo("테스트 학원");
        assertThat(tenant.getOwnerEmail()).isEqualTo("owner@test.com");
        assertThat(tenant.getStatus()).isEqualTo(TenantStatus.PENDING);
        assertThat(tenant.getSchemaName()).isEqualTo("tenant_test_academy");
    }

    @Test
    @DisplayName("PENDING -> PROVISIONING 상태 전이")
    void startProvisioning() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);

        tenant.startProvisioning();

        assertThat(tenant.getStatus()).isEqualTo(TenantStatus.PROVISIONING);
    }

    @Test
    @DisplayName("PROVISIONING -> ACTIVE 상태 전이")
    void activate() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);
        tenant.startProvisioning();

        tenant.activate();

        assertThat(tenant.getStatus()).isEqualTo(TenantStatus.ACTIVE);
    }

    @Test
    @DisplayName("ACTIVE -> SUSPENDED 상태 전이")
    void suspend() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);
        tenant.startProvisioning();
        tenant.activate();

        tenant.suspend();

        assertThat(tenant.getStatus()).isEqualTo(TenantStatus.SUSPENDED);
    }

    @Test
    @DisplayName("SUSPENDED -> ACTIVE 상태 전이 (재활성화)")
    void reactivate() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);
        tenant.startProvisioning();
        tenant.activate();
        tenant.suspend();

        tenant.reactivate();

        assertThat(tenant.getStatus()).isEqualTo(TenantStatus.ACTIVE);
    }

    @Test
    @DisplayName("잘못된 상태 전이 시 예외 발생")
    void invalidStatusTransition() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);

        assertThatThrownBy(tenant::activate)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("PROVISIONING");
    }

    @Test
    @DisplayName("Tenant 정보 업데이트")
    void updateInfo() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);

        tenant.updateInfo("Updated Academy", "업데이트된 학원");

        assertThat(tenant.getName()).isEqualTo("Updated Academy");
        assertThat(tenant.getDisplayName()).isEqualTo("업데이트된 학원");
    }

    @Test
    @DisplayName("isActive 검증")
    void isActive() {
        Tenant tenant = Tenant.create("test-academy", "Test Academy", null, null);
        assertThat(tenant.isActive()).isFalse();

        tenant.startProvisioning();
        assertThat(tenant.isActive()).isFalse();

        tenant.activate();
        assertThat(tenant.isActive()).isTrue();

        tenant.suspend();
        assertThat(tenant.isActive()).isFalse();
    }
}
