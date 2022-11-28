/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

/**
 *
 * @author salazar
 */
public class Arbol {

    private Persona raiz;

    //contruir un arbol vacio
    public Arbol() {
        raiz = null;
    }

    //insertar un nuevo nodo en el arbol de busqueda binaria
    public synchronized void insertarContacto(Persona persona) {
        if (raiz == null) {
            raiz = persona; //crea nodo raiz
        } else {
            raiz.insertar(persona); // llama al metodo insertar
        }
    }
    
    public Persona buscarContacto(String nombre) {
        Persona actual= raiz;
        while(actual != null){
            if(actual.getNombre().equals(nombre))
                return actual;
            if(actual.getNombre().compareTo(nombre) < 0){
                actual = actual.getContactoderecho();
            } else {
                actual = actual.getContactoizquierdo();
            }
        }
        return null;
    }

    //--------------- EMPESAR EL RECORRIDO EN PREORDEN-----------------------
    public synchronized void recorridoPreorden() {
        ayudantePreorden(raiz);
    }
    //metodo recursivo para recorrido en preorden

    private void ayudantePreorden(Persona nodo) {
        if (nodo == null) {
            return;
        }

        imprimirInfoContacto(nodo);
        ayudantePreorden(nodo.getContactoizquierdo()); //recorre subarbol izquierdo
        ayudantePreorden(nodo.getContactoderecho()); //recorre subarbol derecho
    }

    //--------------EMPEZAR RECORRIDO INORDEN-----------------------------------
    public synchronized void recorridoInorden() {
        ayudanteInorden(raiz);
    }

    // metodo recursivo para recorrido inorden
    private void ayudanteInorden(Persona nodo) {
        if (nodo == null) {
            return;
        }

        ayudanteInorden(nodo.getContactoizquierdo());
        imprimirInfoContacto(nodo);
        ayudanteInorden(nodo.getContactoderecho());
    }

    //-----------------------------EMPEZAR RECORRIDO POSORDEN---------------------------------
    public synchronized void recorridoPosorden() {
        ayudantePosorden(raiz);
    }

    //metodo recursivo para recorrido posorden
    private void ayudantePosorden(Persona nodo) {
        if (nodo == null) {
            return;
        }

        ayudantePosorden(nodo.getContactoizquierdo());
        ayudantePosorden(nodo.getContactoderecho());
        imprimirInfoContacto(nodo);
    }
    
    private void imprimirInfoContacto(Persona nodo){
        System.out.print("Nombre:\t" + nodo.getNombre() + "\tTeléfono: " + nodo.getTelefono() + "\tCódigo Postal: " + nodo.getCodigoPostal() + "\n");
    }

}
