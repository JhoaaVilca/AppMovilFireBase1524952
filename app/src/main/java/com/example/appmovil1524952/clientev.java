package com.example.appmovil1524952;

public class clientev {
    private String Apellidos;
    private String Direccion;
    private String Nombre;
    private String Correo;
    private String Dni;
    private String Telefono;
    private String Id;

    public clientev(String apellidos, String id, String dni, String telefono, String correo, String direccion, String nombre) {
        Apellidos = apellidos;
        Id = id;
        Dni = dni;
        Telefono = telefono;
        Correo = correo;
        Direccion = direccion;
        Nombre = nombre;
    }

    public clientev(){

    }

    public String getApellidos()   {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
