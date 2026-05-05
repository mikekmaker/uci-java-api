package com.pv.api.application.dto;

public class MeResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String username;

    public MeResponse(Long id, String nombre, String apellido, String username) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getUsername() { return username; }
}