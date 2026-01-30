package com.lumie.tenant.domain.entity;

import com.lumie.common.domain.BaseEntity;
import com.lumie.tenant.domain.vo.TenantPlan;
import com.lumie.tenant.domain.vo.TenantSlug;
import com.lumie.tenant.domain.vo.TenantStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenants")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tenant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TenantSlug slug;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "display_name", length = 200)
    private String displayName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private TenantStatus status;

    @Column(name = "schema_name", length = 63)
    private String schemaName;

    @Column(name = "owner_email", length = 255)
    private String ownerEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan_id", nullable = false, length = 20)
    private TenantPlan plan;

    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TenantSettings settings;

    @Builder
    private Tenant(TenantSlug slug, String name, String displayName, String ownerEmail, TenantPlan plan) {
        this.slug = slug;
        this.name = name;
        this.displayName = displayName;
        this.ownerEmail = ownerEmail;
        this.status = TenantStatus.PENDING;
        this.schemaName = slug.toSchemaName();
        this.plan = plan != null ? plan : TenantPlan.FREE;
    }

    public static Tenant create(String slug, String name, String displayName, String ownerEmail) {
        return create(slug, name, displayName, ownerEmail, TenantPlan.FREE);
    }

    public static Tenant create(String slug, String name, String displayName, String ownerEmail, TenantPlan plan) {
        Tenant tenant = Tenant.builder()
                .slug(TenantSlug.of(slug))
                .name(name)
                .displayName(displayName)
                .ownerEmail(ownerEmail)
                .plan(plan)
                .build();
        tenant.settings = TenantSettings.createDefault(tenant);
        return tenant;
    }

    public void startProvisioning() {
        if (this.status != TenantStatus.PENDING) {
            throw new IllegalStateException("Tenant can only be provisioned from PENDING status");
        }
        this.status = TenantStatus.PROVISIONING;
    }

    public void activate() {
        if (this.status != TenantStatus.PROVISIONING) {
            throw new IllegalStateException("Tenant can only be activated from PROVISIONING status");
        }
        this.status = TenantStatus.ACTIVE;
    }

    public void suspend() {
        if (this.status != TenantStatus.ACTIVE) {
            throw new IllegalStateException("Tenant can only be suspended from ACTIVE status");
        }
        this.status = TenantStatus.SUSPENDED;
    }

    public void reactivate() {
        if (this.status != TenantStatus.SUSPENDED) {
            throw new IllegalStateException("Tenant can only be reactivated from SUSPENDED status");
        }
        this.status = TenantStatus.ACTIVE;
    }

    public void markAsDeleted() {
        this.status = TenantStatus.DELETED;
    }

    public void updateInfo(String name, String displayName) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
        if (displayName != null) {
            this.displayName = displayName;
        }
    }

    public String getSlugValue() {
        return slug.getValue();
    }

    public boolean isActive() {
        return this.status == TenantStatus.ACTIVE;
    }

    public boolean supportsCustomDomains() {
        return this.plan != null && this.plan.supportsCustomDomains();
    }

    public void updatePlan(TenantPlan plan) {
        if (plan != null) {
            this.plan = plan;
        }
    }
}
