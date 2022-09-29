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
            System.out.println("Ingresa el número correspondiente a la acción que deseas realizar\n"
                    + "1. Agregar un número\n"
                    + "2. Obtener el nivel de un número dado\n"
                    + "3. Averiguar cuantos NODOS hay en el arbol\n"
                    + "4. Averiguar cuantas HOJAS hay en el árbol\n"
                    + ". Salir");
            switch (opcion) {
                case 1:
                    System.out.print("Por favor ingrese el dato a guardar: ");
                    try {
                        dato = Integer.parseInt(sc.nextLine());
                        arbBin.insertar(dato);
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor ingrese un número");
                    }
                    break;
                case 2: 
                    System.out.print("Por favor ingrese el dato al cual buscar su nivel: ");
                    try {
                        dato = Integer.parseInt(sc.nextLine());
                        System.out.println("El nivel del nodo " + dato + " es el " + arbBin.buscar(dato));
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor ingrese un número");
                    }                    
                    break;
                case 3:
                    System.out.println("La cantidad de nodos existentes son: " + arbBin.getCantidadNodos());
                    break;
                case 4:
                    System.out.println("La cantidad de nodos hoja son: " + arbBin.getNumHojas());
                    break;
                default:
                    seguir = false;
            }
        }
    }

}
