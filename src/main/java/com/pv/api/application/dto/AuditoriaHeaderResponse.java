package com.pv.api.application.dto;

import java.time.LocalDateTime;

public class AuditoriaHeaderResponse {

    private Long Id;
    private String lenguaje;
    private String estado;
    private LocalDateTime fechaCreacion;

    public AuditoriaHeaderResponse() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long auditoriaId) {
        this.Id = auditoriaId;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}