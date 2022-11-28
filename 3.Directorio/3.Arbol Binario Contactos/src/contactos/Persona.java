/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

/**
 *
 * @author salazar
 */
public class Persona {

    //miembros de acceso
    private String nombre, telefono;
    private int codigoPostal;
    private Persona contactoizquierdo, contactoderecho;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Persona getContactoizquierdo() {
        return contactoizquierdo;
    }

    public Persona getContactoderecho() {
        return contactoderecho;
    }

    //iniciar dato y hacer de este nodo un nodo hoja
    public Persona(String nombre, String telefono, int codigoPostal) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        contactoizquierdo = contactoderecho = null; //el nodo no tiene hijos
    }

    //buscar punto de insercion  e insertar nodo nuevo
    public synchronized void insertar(Persona persona) {
        //insertar en subarbol izquierdo
        if (this.nombre.compareTo(persona.nombre) < 0) {
            //System.out.println("Se supone que: " + this.getNombre() + " es menor que " + persona.getNombre());
            //insertar nuevo nodoarbol
            if (contactoderecho == null) {
                contactoderecho = persona;
            } else //continua recorriendo subarbol derecho
            {
                contactoderecho.insertar(persona);
            }

        } //insertar nodo derecho
        else {

            //inserta nuevo nodoarbol
            if (contactoizquierdo == null) {
                contactoizquierdo = persona;
            } else //continua recorriendo subarbol izquierdo
            {
                contactoizquierdo.insertar(persona);
            }
        }
    } //fin del metodo insertar 

}
