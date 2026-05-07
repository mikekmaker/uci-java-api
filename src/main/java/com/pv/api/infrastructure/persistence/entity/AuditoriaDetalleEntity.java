package com.pv.api.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auditoria_detalle")
public class AuditoriaDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "auditoria_id", nullable = false)
    private Long auditoriaId;

    @Column(name = "severity")
    private String severity;

    @Column(name = "type")
    private String type;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "line")
    private Integer line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditoria_id", insertable = false, updatable = false)
    private AuditoriaEntity auditoria;

    public AuditoriaDetalleEntity() {}

    // getters & setters

    public Long getId() { return id; }
    public Long getAuditoriaId() { return auditoriaId; }
    public String getSeverity() { return severity; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public Integer getLine() { return line; }
    public AuditoriaEntity getAuditoria() { return auditoria; }

    public void setId(Long id) { this.id = id; }
    public void setAuditoriaId(Long auditoriaId) { this.auditoriaId = auditoriaId; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setType(String type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setLine(Integer line) { this.line = line; }
    public void setAuditoria(AuditoriaEntity auditoria) { this.auditoria = auditoria; }
}