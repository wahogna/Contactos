package com.fjcortes.contactos;

public class Contactos {

        private String nombre;
        private String DateOfBird;
        private String Telefono;
        private String Email;
        private String Descripcion;

    public Contactos(String nombre, String dateOfBird, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.DateOfBird = dateOfBird;
        this.Telefono = telefono;
        this.Email = email;
        this.Descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDateOfBird() {
        return DateOfBird;
    }

    public void setDateOfBird(String dateOfBird) {
        DateOfBird = dateOfBird;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
