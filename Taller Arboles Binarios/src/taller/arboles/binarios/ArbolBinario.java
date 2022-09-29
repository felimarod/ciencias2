/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.arboles.binarios;

/**
 *
 * @author Estudiantes
 */
public class ArbolBinario {

    Nodo raiz;
    int tam;

    public ArbolBinario() {
        raiz = null;
    }

    boolean estaVacio() {
        return raiz == null;
    }

    void insertar(int dato) {
        Nodo p = null;
        Nodo nAct = raiz;

        Nodo x = new Nodo(dato);

        if (raiz == null) {
            raiz = x;
        } else {
            while (nAct != null) {
                p = nAct;
                if (dato < nAct.dato) {
                    nAct = nAct.hijoIzq;
                } else {
                    nAct = nAct.hijoDer;
                }
            }
            if (dato < p.dato) {
                p.hijoIzq = x;
            } else {
                p.hijoDer = x;
            }
        }
    }

    int buscar(int dato) {
        Nodo p = null;
        Nodo nAct = raiz;
        int nivel = 0;
        while (nAct != null && nAct.dato != dato) {
            System.out.println("Valor act " + nAct.dato);
            p = nAct;
            if (dato < nAct.dato) {
                nAct = nAct.hijoIzq;
            } else {
                nAct = nAct.hijoDer;
            }
            nivel++;
        }
        if (nAct == null) {
            return -1;
        } else {
            return nivel;
        }
    }
    
    public int getCantidadNodos(){
        return cantidadNodos(raiz);
    }
    private int cantidadNodos(Nodo act) {
        if(act.hijoDer == null && act.hijoIzq == null) 
            return 1;
        else {
            int nodos = 1;
            if(act.hijoIzq != null)
                nodos += cantidadNodos(act.hijoIzq);
            if(act.hijoDer != null)
                nodos += cantidadNodos(act.hijoDer);
            return nodos;
        }
    }
    
    public int getNumHojas(){
        return numHojas(raiz);
    }
    private int numHojas(Nodo act) {
        if(act.hijoDer == null && act.hijoIzq == null) 
            return 1;
        else {
            int hojas = 0;
            if(act.hijoIzq != null)
                hojas += numHojas(act.hijoIzq);
            if(act.hijoDer != null)
                hojas += numHojas(act.hijoDer);
            return hojas;
        }
        
    }

}
