""" Árbol AVL - Implementación en Python """
import time
import csv
from AVL import AVL

def buscar(t, raiz):
    # 30000728680 - Luis Gonzáles
    value = int(input("Ingresa el valor del dato a buscar"))
    inicio = time.time()
    nombre = t.buscar(raiz,value)
    fin = time.time()

    print("Nombre:",nombre)
    print("Tiempo de busqueda:",fin - inicio)
    


if __name__ == '__main__':
    with open('contactos.csv', newline='') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
        t = AVL()
        raiz = None

        inicio = time.time()
        for row in spamreader:
            raiz = t.insertar(raiz,int(row[1]),row[0])
        fin = time.time()
        #t.preOrder(raiz) 
        print("Tiempo de inserciones", fin-inicio)
        buscar(t,raiz)


    
