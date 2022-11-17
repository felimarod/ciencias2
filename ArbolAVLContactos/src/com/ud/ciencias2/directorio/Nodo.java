package com.ud.ciencias2.directorio;

public abstract class Nodo <T> extends Arbol <T>{
    
    public int altura;
    public int dato;
    public int fe;
    Contacto contacto;
    long key;
    
    private Nodo <T> izqNodo = null;
    private Nodo <T> derNodo = null;
    private Nodo <T> padreNodo;
    
    
    
    public Nodo(Contacto objContacto) {
        altura = 1;
        key = (objContacto.getId());
        contacto = objContacto;
        
    }
    
    private T valor;
    
    @Override
    public void imprimir() {
       System.out.println(contacto.getId() + " " + contacto.getNombre() + " " + contacto.getTelefono()); // mostrar datos del nodo
        
        
       // System.out.print("(");
        if(izqNodo != null){
            izqNodo.imprimir();
        }
       // System.out.print(",");
        if(derNodo != null){
            derNodo.imprimir();
        }
     //   System.out.print(")");
    }
    
    
    
    @Override
    public void ayudanteInorden( Nodo raiz)
    {
        if(raiz == null)
            return;
        System.out.println(contacto.getId() + " " + contacto.getNombre() + " " + contacto.getTelefono()); // mostrar datos del nodo
    }
    
   
    
    public Nodo(T valor) {
        this.padreNodo = null;
        this.valor = valor;
        altura = 1;
        key = Integer.parseInt(valor.toString());
    }
    
    public Nodo<T> getPadreNodo() {
        return padreNodo;
    }
    
    public Nodo<T> getDerNodo() {
        return derNodo;
    }
    
    public Nodo<T> getIzqNodo() {
        return izqNodo;
    }
    
    public T getValor() {
        return valor;
    }
    
    public void setPadreNodo(Nodo<T> padreNodo) {
        this.padreNodo = padreNodo;
    }
    
    public void setDerNodo(Nodo<T> derNodo) {
        this.derNodo = derNodo;
    }
    
    public void setIzqNodo(Nodo<T> izqNodo) {
        this.izqNodo = izqNodo;
    }
    
    public void setValor(T valor) {
        this.valor = valor;
    }
    
    public abstract Nodo buscarSucesor();
    
    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }
    
    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
}