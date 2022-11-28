""" Árbol AVL - Implementación en Python """
import time
import csv
from RN import RN, Nodo

def buscar(t):
    # 30000728680 - Luis Gonzáles
    value = int(input("Ingresa el valor del dato a buscar"))
    inicio = time.time()
    nombre = t.buscar(t.raiz,value)
    fin = time.time()

    print("Nombre:",nombre)
    print("Tiempo de busqueda:",fin - inicio)


if __name__ == '__main__':
    with open('../4.AVL Directorio/contactos.csv', newline='') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
        t = RN()
        raiz = None

        inicio = time.time()
        for row in spamreader:
            raiz = t.insertar(Nodo(int(row[1]),row[0]))
        fin = time.time()
        #t.inOrden(t.raiz) 
        print("Tiempo de inserciones", fin-inicio)
        buscar(t)