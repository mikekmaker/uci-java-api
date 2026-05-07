package com.pv.api.application.dto;


import java.time.LocalDateTime;
import java.util.List;

public class AuditoriaResponse {

    private Long id;

    private String codigoFuente;
    private String lenguaje;

    private String codigoExplicado;
    private String reingenieria;

    private String estado;

    private List<AuditoriaDetalleResponse> issues;

    private String errorMensaje;

    private Long tiempoEjecucion;

    private LocalDateTime fechaCreacion;

    public AuditoriaResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoFuente() {
        return codigoFuente;
    }

    public void setCodigoFuente(String codigoFuente) {
        this.codigoFuente = codigoFuente;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<AuditoriaDetalleResponse> getIssues() {
        return issues;
    }

    public void setIssues(List<AuditoriaDetalleResponse> issues) {
        this.issues = issues;
    }

    public String getErrorMensaje() {
        return errorMensaje;
    }

    public void setErrorMensaje(String errorMensaje) {
        this.errorMensaje = errorMensaje;
    }

    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}