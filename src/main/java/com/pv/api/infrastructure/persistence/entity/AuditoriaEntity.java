package com.pv.api.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "auditoria")
public class AuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "codigo_fuente", columnDefinition = "TEXT")
    private String codigoFuente;

    @Column(name = "lenguaje")
    private String lenguaje;

    @Column(name = "codigo_explicado", columnDefinition = "TEXT")
    private String codigoExplicado;

    @Column(name = "reingenieria", columnDefinition = "TEXT")
    private String reingenieria;

    @Column(name = "resultado_general", columnDefinition = "TEXT")
    private String resultadoGeneral;

    @Column(name = "estado")
    private String estado;

    @Column(name = "error_mensaje")
    private String errorMensaje;

    @Column(name = "error_detalle", columnDefinition = "TEXT")
    private String errorDetalle;

    @Column(name = "tiempo_ejecucion")
    private Long tiempoEjecucion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @OneToMany(mappedBy = "auditoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuditoriaDetalleEntity> detalles;

    public AuditoriaEntity() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getCodigoFuente() {
        return codigoFuente;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getCodigoExplicado() {
        return codigoExplicado;
    }

    public String getReingenieria() {
        return reingenieria;
    }

    public String getResultadoGeneral() {
        return resultadoGeneral;
    }

    public String getEstado() {
        return estado;
    }

    public String getErrorMensaje() {
        return errorMensaje;
    }

    public String getErrorDetalle() {
        return errorDetalle;
    }

    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public List<AuditoriaDetalleEntity> getDetalles() {
        return detalles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCodigoFuente(String codigoFuente) {
        this.codigoFuente = codigoFuente;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public void setCodigoExplicado(String codigoExplicado) {
        this.codigoExplicado = codigoExplicado;
    }

    public void setReingenieria(String reingenieria) {
        this.reingenieria = reingenieria;
    }

    public void setResultadoGeneral(String resultadoGeneral) {
        this.resultadoGeneral = resultadoGeneral;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setErrorMensaje(String errorMensaje) {
        this.errorMensaje = errorMensaje;
    }

    public void setErrorDetalle(String errorDetalle) {
        this.errorDetalle = errorDetalle;
    }

    public void setTiempoEjecucion(Long tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setDetalles(List<AuditoriaDetalleEntity> detalles) {
        this.detalles = detalles;
    }
}