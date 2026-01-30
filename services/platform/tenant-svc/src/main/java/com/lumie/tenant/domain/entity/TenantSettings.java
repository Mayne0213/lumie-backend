package com.lumie.tenant.domain.entity;

import com.lumie.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tenant_settings")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TenantSettings extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false, unique = true)
    private Tenant tenant;

    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "theme", columnDefinition = "jsonb")
    private Map<String, Object> theme = new HashMap<>();

    @Builder
    private TenantSettings(Tenant tenant, String logoUrl, Map<String, Object> theme) {
        this.tenant = tenant;
        this.logoUrl = logoUrl;
        this.theme = theme != null ? theme : new HashMap<>();
    }

    public static TenantSettings createDefault(Tenant tenant) {
        return TenantSettings.builder()
                .tenant(tenant)
                .theme(new HashMap<>())
                .build();
    }

    public void updateLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void updateTheme(Map<String, Object> theme) {
        this.theme = theme != null ? theme : new HashMap<>();
    }

    public void update(String logoUrl, Map<String, Object> theme) {
        if (logoUrl != null) {
            this.logoUrl = logoUrl;
        }
        if (theme != null) {
            this.theme = theme;
        }
    }
}
