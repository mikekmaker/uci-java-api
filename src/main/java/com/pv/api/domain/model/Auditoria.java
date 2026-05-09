package com.pv.api.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Auditoria {

    private Long id;
    private Long userId;

    private String codigoFuente;
    private String lenguaje;

    private String codigoExplicado;
    private String reingenieria;

    private AuditStatus estado;

    private String errorMensaje;
    private String errorDetalle;

    private Long tiempoEjecucion;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    private List<AuditoriaDetalle> detalles;

    private String resultadoGeneral;

    public Auditoria() {
    }

    public Auditoria(Long id,
                     Long userId,
                     String codigoFuente,
                     String lenguaje,
                     String codigoExplicado,
                     String reingenieria,
                     AuditStatus estado,
                     String errorMensaje,
                     String errorDetalle,
                     Long tiempoEjecucion,
                     LocalDateTime fechaCreacion,
                     LocalDateTime fechaActualizacion,
                     List<AuditoriaDetalle> detalles,
                     String resultadoGeneral) {
        this.id = id;
        this.userId = userId;
        this.codigoFuente = codigoFuente;
        this.lenguaje = lenguaje;
        this.codigoExplicado = codigoExplicado;
        this.reingenieria = reingenieria;
        this.estado = estado;
        this.errorMensaje = errorMensaje;
        this.errorDetalle = errorDetalle;
        this.tiempoEjecucion = tiempoEjecucion;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.detalles = detalles;
        this.resultadoGeneral = resultadoGeneral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public AuditStatus getEstado() {
        return estado;
    }

    public void setEstado(AuditStatus estado) {
        this.estado = estado;
    }

    public String getErrorMensaje() {
        return errorMensaje;
    }

    public void setErrorMensaje(String errorMensaje) {
        this.errorMensaje = errorMensaje;
    }

    public String getErrorDetalle() {
        return errorDetalle;
    }

    public void setErrorDetalle(String errorDetalle) {
        this.errorDetalle = errorDetalle;
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

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<AuditoriaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<AuditoriaDetalle> detalles) {
        this.detalles = detalles;
    }

    public String getResultadoGeneral() {
        return resultadoGeneral;
    }

    public void setResultadoGeneral(String resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }
}