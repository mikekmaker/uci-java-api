package com.pv.api.domain.model;

public class AuditoriaDetalle {

    private Long id;
    private Long auditoriaId;

    private String severity;
    private String type;
    private String description;
    private Integer line;

    public AuditoriaDetalle() {}

    public AuditoriaDetalle(Long id,
                            Long auditoriaId,
                            String severity,
                            String type,
                            String description,
                            Integer line) {
        this.id = id;
        this.auditoriaId = auditoriaId;
        this.severity = severity;
        this.type = type;
        this.description = description;
        this.line = line;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAuditoriaId() { return auditoriaId; }
    public void setAuditoriaId(Long auditoriaId) { this.auditoriaId = auditoriaId; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getLine() { return line; }
    public void setLine(Integer line) { this.line = line; }
}