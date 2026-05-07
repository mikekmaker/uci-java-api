package com.pv.api.application.dto;

public class AuditoriaDetalleResponse {

    private String severity;
    private String type;
    private String description;
    private Integer line;

    public AuditoriaDetalleResponse() {}

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }
}