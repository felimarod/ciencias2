/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import java.util.Scanner;

public class Main {

    static Arbol arbol;
    static Scanner sc;
    static String nombre, telefono;
    static int codigoPostal = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        arbol = new Arbol();
        menu();
    }

    static void menu() {
        Persona persona = null;

        // Menu
        int opcion = -1;

        //System.out.println( "ARBOL BINARIO para directorio de Contactos\nRecorridos Preorden,Inorden y Posorden ");
        System.out.println("Bienvenido\nPor favor ingrese el número correspondiente a la acción que desea realizar.\n"
                + "1.\tIngresar nuevo Contacto\n"
                + "2.\tBuscar Contacto\n"
                + "3.\tListar Contactos\n"
                + "4.\tSalir");
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            menu();
        }
        switch (opcion) {
            case 1:
                System.out.println("Por favor ingrese los datos pedidos a continuación.");

                System.out.print("Nombre del nuevo contacto: ");
                nombre = sc.nextLine();

                System.out.print("Teléfono: ");
                telefono = sc.nextLine();

                System.out.print("Código Postal: ");
                codigoPostal = Integer.parseInt(sc.nextLine());

                //System.out.print(valor + " ");
                persona = new Persona(nombre, telefono, codigoPostal);

                arbol.insertarContacto(persona);
                System.out.println("");
                menu();
                break;
            case 2:
                System.out.print("Por favor ingrese el nombre de quien busca: ");
                nombre = sc.nextLine();
                persona = arbol.buscarContacto(nombre);
                if (persona != null) {
                    System.out.print("Datos de " + persona.getNombre() + ":\nTeléfono:\t" + persona.getTelefono() + "\tCódigo Postal: " + persona.getCodigoPostal() + "\n\n");
                } else {
                    System.out.println("No existe un contacto con el nombre " + nombre + "\n");
                }
                menu();
                break;
            case 3:
                //        System.out.println("\n\nRecorrido preorden");
                //        arbol.recorridoPreorden();
                System.out.println("\n\nRecorrido inorden");
                arbol.recorridoInorden();
                //        System.out.println("\n\nRecorrido posorden");
                //        arbol.recorridoPosorden();
                menu();
                break;
            case 4:
                break;
            default:
                menu();
                break;
        }

    }
}
