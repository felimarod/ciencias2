package com.ud.ciencias2.directorio;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, CsvValidationException, CsvException {

        ArbolOrdenamiento<Integer> arbol = new ArbolOrdenamiento<Integer>();

        Scanner read = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n\n\nDirectorio de Contactos");
            System.out.println("1. Cargar árbol");
            System.out.println("2. Buscar Contacto");
            System.out.println("3. Imprimir inorden");
            System.out.println("4. Salir");

            op = read.nextInt();

            switch (op) {
                case 1:
                    cargarArbol(arbol);
                    break;
                case 2:
                    int id;
                    System.out.println("Ingrese el id del contacto a buscar");
                    id = read.nextInt();
                    arbol.buscar(id);
                    break;
                case 3:
                    arbol.recorridoInorden();
                    break;
                default:
                    System.out.println("Saliendo");
                    break;
            }
        } while (op != 4);
    }

    public static void cargarArbol(ArbolOrdenamiento<Integer> arbol) throws FileNotFoundException, IOException, CsvValidationException, CsvException {
        FileReader archivo = new FileReader("/home/felipe/Repositorios/Sistemas/ciencias2/ArbolAVLContactos/src/com/ud/ciencias2/directorio/data-contactos.csv");
        
        final CSVReader csvReader = new CSVReader(archivo);

        // Se insertan los datos al árbol
        String[] fila = null;
        long id = 0;
        while((fila = csvReader.readNext()) != null) {
            arbol.insertar(new Contacto(++id, fila[0], Long.parseLong(fila[1])));
        }
    }

}
