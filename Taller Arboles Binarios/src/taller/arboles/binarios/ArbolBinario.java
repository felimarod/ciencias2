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

    public int getCantidadNodos() {
        return hijosPorNodo(raiz);
    }

    private int hijosPorNodo(Nodo act) {
        if (act.hijoDer == null && act.hijoIzq == null) {
            return 1;
        } else {
            int nodos = 1;
            if (act.hijoIzq != null) {
                nodos += hijosPorNodo(act.hijoIzq);
            }
            if (act.hijoDer != null) {
                nodos += hijosPorNodo(act.hijoDer);
            }
            return nodos;
        }
    }

    public int getNumHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo act) {
        if (act.hijoDer == null && act.hijoIzq == null) {
            return 1;
        } else {
            int hojas = 0;
            if (act.hijoIzq != null) {
                hojas += contarHojas(act.hijoIzq);
            }
            if (act.hijoDer != null) {
                hojas += contarHojas(act.hijoDer);
            }
            return hojas;
        }
    }

    public int getProfundidadArbol() {
        return getProfundidadNodo(raiz);
    }

    private int getProfundidadNodo(Nodo act) {
        if (act == null) {
            return 0;
        }

        int profIzq;
        int profDer;

        profIzq = getProfundidadNodo(act.hijoIzq);
        profDer = getProfundidadNodo(act.hijoDer);

        if (profIzq > profDer) {
            return 1 + profIzq;
        } else {
            return 1 + profDer;
        }

    }

}
