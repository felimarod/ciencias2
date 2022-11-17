/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.ud.ciencias2.directorio;

/**
 *
 * @author Estudiantes
 */
public class ArbolOrdenamiento<T extends Comparable> extends Arbol<T> {
    
    private Nodo <T> raiz = null;
    
    @Override
    public void insertar(Contacto contacto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        long key = (contacto.getId());
        this.setRaiz(insertarAVL(getRaiz(), contacto));
    }
    
    private Nodo insertarAVL(Nodo nodoActual, Contacto contacto) {
        if (nodoActual == null) {
            return (new Nodo(contacto) {
                @Override
                public void insertar(Contacto contacto) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
                
                @Override
                public void eliminar(Object valor) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
                
                @Override
                public Nodo eliminar(Nodo n, long v) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
                
                @Override
                public Nodo buscarSucesor() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
                
                @Override
                public void buscar(Nodo nodoActual, int valor) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            });
        }
        
        if (contacto.getId() < nodoActual.key) {
            nodoActual.setIzqNodo(insertarAVL(nodoActual.getIzqNodo(), contacto));
        }else if (contacto.getId() > nodoActual.key) {
            nodoActual.setDerNodo(insertarAVL(nodoActual.getDerNodo(), contacto));
        }else {
            return nodoActual;
        }
        
        nodoActual.altura = 1 +
                max(getAltura(nodoActual.getIzqNodo()), getAltura(nodoActual.getDerNodo()));
        
        
        int fe = getFactorEquilibrio(nodoActual);
        
        if (fe > 1 && contacto.getId() < nodoActual.getIzqNodo().key) {
            return rightRotate(nodoActual);
        }
        
        if (fe < -1 && contacto.getId() > nodoActual.getDerNodo().key) {
            return leftRotate(nodoActual);
        }
        
        if (fe > 1 && contacto.getId() > nodoActual.getIzqNodo().key) {
            nodoActual.setIzqNodo(leftRotate(nodoActual.getIzqNodo()));
            return rightRotate(nodoActual);
        }
        
        if (fe < -1 && contacto.getId() < nodoActual.getDerNodo().key) {
            nodoActual.setDerNodo(rightRotate(nodoActual.getDerNodo()));
            return leftRotate(nodoActual);
        }
        
        return nodoActual;
    }
    
    public void buscar(T valor) {
        buscar(getRaiz(),Integer.parseInt(valor.toString()));
    }
    
    public void buscar(Nodo nodoActual, int valor) {
       if (nodoActual == null) {
            return;
        }
        if (valor == nodoActual.contacto.getId() || valor == nodoActual.contacto.getId()) {
            System.out.println(nodoActual.contacto.getId() + " " + nodoActual.contacto.getNombre() + " " + nodoActual.contacto.getTelefono()); // mostrar datos del nodo
        } else {
            buscar(nodoActual.getIzqNodo(), valor); //recorre subarbol izquierdo
            buscar(nodoActual.getDerNodo(), valor); //recorre subarbol derecho
        }
    }
    
    
    @Override
    public void eliminar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int key = Integer.parseInt(valor.toString());
        setRaiz(eliminar(getRaiz(), key));
        
    }
    
    
    @Override
    public Nodo eliminar(Nodo nodoActual, long key) {
        if (nodoActual == null)
            return nodoActual;
        
        if (key < nodoActual.key){
            nodoActual.setIzqNodo(eliminar(nodoActual.getIzqNodo(), key));
        }else if (key > nodoActual.key){
            nodoActual.setDerNodo(eliminar(nodoActual.getDerNodo(), key));
        }else {
            if ((nodoActual.getIzqNodo() == null) || (nodoActual.getDerNodo() == null)) {
                Nodo temp = null;
                if (temp == nodoActual.getIzqNodo()) {
                    temp = nodoActual.getDerNodo();
                }else {
                    temp = nodoActual.getIzqNodo();
                }
                
                if (temp == null) {
                    nodoActual = null;
                }else{
                    
                    nodoActual = temp;
                }
            }else {
                Nodo temp = getNodoConValorMinimo(nodoActual.getIzqNodo());
                nodoActual.key = temp.key;
                nodoActual.setIzqNodo(eliminar(nodoActual.getIzqNodo(), temp.key));
            }
        }if (nodoActual == null)
            return nodoActual;
        nodoActual.altura = max(getAltura(nodoActual.getIzqNodo()), getAltura(nodoActual.getIzqNodo())) + 1;
        int fe = getFactorEquilibrio(nodoActual);
        if (fe > 1 && getFactorEquilibrio(nodoActual.getIzqNodo()) >= 0) {
            return rightRotate(nodoActual);
        }
        if (fe < -1 && getFactorEquilibrio(nodoActual.getIzqNodo()) <= 0) {
            return leftRotate(nodoActual);
        }
        if (fe > 1 && getFactorEquilibrio(nodoActual.getIzqNodo()) < 0) {
            nodoActual.setIzqNodo(leftRotate(nodoActual.getIzqNodo()));
            return rightRotate(nodoActual);
        }
        if (fe < -1 && getFactorEquilibrio(nodoActual.getIzqNodo()) > 0) {
            nodoActual.setDerNodo(rightRotate(nodoActual.getIzqNodo()));
            return leftRotate(nodoActual);
        }
        return nodoActual;
    }
    
    private Nodo rightRotate(Nodo nodoActual) {
        Nodo nuevaRaiz = nodoActual.getIzqNodo();
        Nodo temp = nuevaRaiz.getDerNodo();
        
        
        nuevaRaiz.setDerNodo(nodoActual);
        nodoActual.setIzqNodo(temp);
        
        
        nodoActual.altura = max(getAltura(nodoActual.getIzqNodo()), getAltura(nodoActual.getDerNodo())) + 1;
        nuevaRaiz.altura = max(getAltura(nuevaRaiz.getIzqNodo()), getAltura(nuevaRaiz.getDerNodo())) + 1;
        
        return nuevaRaiz;
    }
    private Nodo leftRotate(Nodo nodoActual) {
        Nodo nuevaRaiz = nodoActual.getDerNodo();
        Nodo temp = nuevaRaiz.getIzqNodo();
        
        
        nuevaRaiz.setIzqNodo(nodoActual);
        nodoActual.setDerNodo(temp);
        
        
        nodoActual.altura = max(getAltura(nodoActual.getIzqNodo()), getAltura(nodoActual.getDerNodo())) + 1;
        nuevaRaiz.altura = max(getAltura(nuevaRaiz.getIzqNodo()), getAltura(nuevaRaiz.getDerNodo())) + 1;
        
        return nuevaRaiz;
    }
    private int getAltura(Nodo nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return nodoActual.altura;
    }
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    private int getFactorEquilibrio(Nodo nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return getAltura(nodoActual.getIzqNodo()) - getAltura(nodoActual.getDerNodo());
    }
    private Nodo getNodoConValorMinimo(Nodo node) {
        Nodo current = node;
        
        while (current.getIzqNodo() != null){
            current = current.getIzqNodo();
        }
        
        return current;
    }

    
}
