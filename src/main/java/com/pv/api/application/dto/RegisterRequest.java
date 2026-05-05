package com.pv.api.application.dto;

public class RegisterRequest {

    private String username;
    private String password;
    private String nombre;
    private String apellido;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
}