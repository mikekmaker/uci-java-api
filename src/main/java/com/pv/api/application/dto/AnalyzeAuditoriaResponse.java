package com.pv.api.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AnalyzeAuditoriaResponse {

    private Long auditoriaId;

    private String estado;

    private String codigoExplicado;
    private String reingenieria;

    private List<AuditoriaDetalleResponse> issues;

    private LocalDateTime fechaHora;

    public AnalyzeAuditoriaResponse() {}

    public Long getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Long auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoExplicado() {
        return codigoExplicado;
    }

    public void setCodigoExplicado(String codigoExplicado) {
        this.codigoExplicado = codigoExplicado;
    }

    public String getReingenieria() {
        return reingenieria;
    }

    public void setReingenieria(String reingenieria) {
        this.reingenieria = reingenieria;
    }

    public List<AuditoriaDetalleResponse> getIssues() {
        return issues;
    }

    public void setIssues(List<AuditoriaDetalleResponse> issues) {
        this.issues = issues;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}