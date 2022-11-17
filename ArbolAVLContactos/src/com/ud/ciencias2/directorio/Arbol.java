/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.ud.ciencias2.directorio;

/**
 * Clase arbol generada de forma abstracta para implementar cualquier tipo de
 * arbol
 * @author Estudiantes
 */
public abstract class Arbol <T> {
    
    private Nodo <T> raiz = null;
    
    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
    
    public abstract void insertar(Contacto contacto);
    public abstract void eliminar(T valor);
    public abstract Nodo eliminar(Nodo n,long v);
    public abstract void buscar(Nodo nodoActual, int valor);
    
    public void imprimir(){
        
        System.out.print("(");
        if(this.getRaiz() != null){
            raiz.imprimir();
        }
        System.out.print(")");
    }
    
        
     public synchronized void recorridoInorden()
    {
        ayudanteInorden(getRaiz());
    }
    
    public void ayudanteInorden( Nodo raiz)
    {
        if(raiz == null)
            return;
        
        ayudanteInorden(raiz.getIzqNodo());
        raiz.ayudanteInorden(raiz);  
        ayudanteInorden(raiz.getDerNodo());
    }
    
    
   
    
}  
