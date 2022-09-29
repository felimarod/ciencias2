/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class pilaExpre {

    private int n, cima;
    private String[] datos;

    public pilaExpre() {
        
        n = 100;
        cima = -1;
        datos = new String[n];
    }

    public boolean esvacia() {
        boolean x = cima == -1 ? true : false;
        return x;
    }

    public boolean esllena() {
        boolean x = cima == n - 1 ? true : false;
        return x;
    }

    public void insertar(String x) {
        if (esllena()) {
            System.out.println("pila llena");
        } else {
            cima++;
            datos[cima] = x;
            //System.out.println("dato entrante "+datos);
        }
    }

    public String eliminar() {
        String x = "";
        if (esvacia()) {
            //System.out.println("pila vacia");
        } else {
            x = datos[cima];
            cima--;
        }
        return x;
    }

    public void vaciar(pilaExpre x) {
        while (!x.esvacia()) {
            insertar(x.eliminar());
        }
    }

    public void mostrar() {
        String x;
        pilaExpre aux = new pilaExpre();
        while (!esvacia()) {
            x = eliminar();
            aux.insertar(x);
        }
        vaciar(aux);
    }

    public int cantDatos() {
        return cima;
    }
}
