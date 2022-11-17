/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.ud.ciencias2.directorio;

/**
 *
 * @author Estudiantes
 * @param <T>
 */
public class NodoOrdenamiento  <T extends Comparable> extends Nodo <T> {
    Contacto contacto;
    public NodoOrdenamiento(Nodo<T> padreNodo,T valor, Contacto contacto) {
        super(contacto);
    }
    
    public NodoOrdenamiento(Contacto contacto) {
        super(contacto);
    }
    
    
    
    @Override
    public void insertar(Contacto contacto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        if(this.getValor().compareTo(contacto.getId()) > 0){
            if(this.getIzqNodo() == null){
                this.setIzqNodo(new NodoOrdenamiento(this, contacto.getId(),contacto));
            }else{
                this.getIzqNodo().insertar(contacto);
            }
            
            
        }else{
            if(this.getDerNodo() == null){
                this.setDerNodo(new NodoOrdenamiento(this, contacto.getId(),contacto));
            }else{
                this.getDerNodo().insertar(contacto);
            }
        }
    }
    
    @Override
    public void eliminar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Nodo eliminar(Nodo n, long v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
    @Override
    public Nodo buscarSucesor() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        if(this.getIzqNodo()!= null){
            return this.getIzqNodo().buscarSucesor();
        }else{
            return this;
        }
    }
    
    @Override
    public void buscar(Nodo nodoActual, int valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
