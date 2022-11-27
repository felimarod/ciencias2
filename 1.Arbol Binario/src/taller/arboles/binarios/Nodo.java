/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller.arboles.binarios;

/**
 *
 * @author Estudiantes
 */
public class Nodo {
    int dato;
    Nodo hijoDer, hijoIzq;

    public Nodo(int dato) {
        this.dato = dato;
        this.hijoDer = null;
        this.hijoIzq = null;
    }
}
