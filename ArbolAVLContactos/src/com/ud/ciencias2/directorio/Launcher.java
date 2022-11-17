package com.ud.ciencias2.directorio;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Felipe & David
 */
public class Launcher {

    ArbolOrdenamiento<String> arbol;
    Scanner read;
    long id = 1;

    Launcher() {
        arbol = new ArbolOrdenamiento<>();
        read = new Scanner(System.in);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Launcher().run();
    }

    private void run() {
        int op;

        do {
            System.out.println("\n\nDirectorio de Contactos\n"
                    + "1. Cargar datos\n"
                    + "2. Ingresar contacto\n"
                    + "3. Buscar Contacto\n"
                    + "4. Imprimir inorden\n"
                    + "5. Salir");

            op = read.nextInt();

            switch (op) {
                case 1:
                    leerArchivo();
                    break;
                case 2:
                    agregarManual();
                    break;
                case 3:
                    String nombre;
                    System.out.println("Ingrese el nombre del contacto a buscar");
                    nombre = read.nextLine();
                    arbol.buscar(nombre);
                    break;
                case 4:
                    arbol.recorridoInorden();
                    break;
                default:
                    System.out.println("Saliendo");
                    break;
            }
        } while (op != 4);
    }

    public void leerArchivo() {
        FileReader archivo = null;
        CSVReader csvReader = null;
        try {

            archivo = new FileReader("/home/felipe/Repositorios/Sistemas/ciencias2/ArbolAVLContactos/src/com/ud/ciencias2/directorio/data-contactos.csv");
            csvReader = new CSVReader(archivo);

            // Se insertan los datos al árbol
            String[] fila = csvReader.readNext(); // Salta la primer linea
            while ((fila = csvReader.readNext()) != null) {
                this.arbol.insertar(new Contacto(id++, fila[0], Long.parseLong(fila[1])));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                archivo.close();
                csvReader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    private void agregarManual() {
        String nombre = read.nextLine();
        Long num = Long.parseLong(read.nextLine());
        this.arbol.insertar(new Contacto(id++, nombre, num));
    }

}
