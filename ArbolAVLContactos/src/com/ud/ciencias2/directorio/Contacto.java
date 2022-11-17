package com.ud.ciencias2.directorio;

/**
 *
 * @author Felipe & David
 */
public class Contacto {

    private long id;
    private String nombre;
    private long telefono;

    public Contacto(long id, String nombre, long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
