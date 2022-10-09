/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller.arboles.binarios;

import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class TallerArbolesBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbBin = new ArbolBinario();

        boolean seguir = true;
        int opcion = -1;
        int dato;

        System.out.println("Bienvenido :D");

        while (seguir) {
            System.out.println("--------------------");
            System.out.println("Ingresa el número correspondiente a la acción que deseas realizar\n"
                    + "1. Agregar un número\n"
                    + "2. Obtener el nivel de un número dado\n"
                    + "3. Averiguar cuantos NODOS hay en el arbol\n"
                    + "4. Averiguar cuantas HOJAS hay en el árbol\n"
                    + "5. Ver la profundidad del árbol\n"
                    + ". Salir");
            arbBin.insertar(4);
            arbBin.insertar(2);
            arbBin.insertar(8);
            arbBin.insertar(1);
            arbBin.insertar(3);
            arbBin.insertar(9);
            try {
                opcion = Integer.parseInt(sc.nextLine());
                System.out.println("--------------------");
                switch (opcion) {
                    case 1:
                        System.out.print("Por favor ingrese el dato a guardar: ");
                        dato = Integer.parseInt(sc.nextLine());
                        arbBin.insertar(dato);
                        break;
                    case 2:
                        System.out.print("Por favor ingrese el dato al cual buscar su nivel: ");
                        dato = Integer.parseInt(sc.nextLine());
                        System.out.println("El nivel del nodo " + dato + " es el " + arbBin.buscar(dato));
                        break;
                    case 3:
                        System.out.println("La cantidad de nodos existentes son: " + arbBin.getCantidadNodos());
                        break;
                    case 4:
                        System.out.println("La cantidad de nodos hoja son: " + arbBin.getNumHojas());
                        break;
                    case 5:
                        System.out.println("La profundidad del árbol es: " + arbBin.getProfundidadArbol());
                        break;
                    default:
                        seguir = false;
                }
                System.out.println("--------------------");
            } catch (NumberFormatException nfe) {
                System.out.println("----Ingrese un dato valido.----");
            }
        }
    }

}
