package com.pv.api.domain.model;

import java.time.LocalDateTime;

public class User {

    private Long userId;
    private String username;
    private String password;
    private String role;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Boolean activo;

    public User() {}

    public User(String username, String password, String role,
                String nombre, String apellido, Boolean activo) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nombre = nombre;
        this.apellido = apellido;
        this.activo = activo;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }

    public User(Long userId, String username, String password, String role,
                String nombre, String apellido,
                LocalDateTime fechaCreacion,
                LocalDateTime fechaActualizacion,
                Boolean activo) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.activo = activo;
    }

    public Long getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
    public Boolean getActivo() { return activo; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}