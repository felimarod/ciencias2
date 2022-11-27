class Nodo(object):
    def __init__(self, telefono, nombre):
        self.telefono = telefono
        self.nombre = nombre
        self.izquierda = None
        self.derecha = None
        self.peso = 1


class AVL(object):
    def insertar(self, raiz, telefono, nombre):

        if not raiz:
            return Nodo(telefono, nombre)
        elif telefono < raiz.telefono:
            raiz.izquierda = self.insertar(raiz.izquierda, telefono, nombre)
        else:
            raiz.derecha = self.insertar(raiz.derecha, telefono, nombre)

        raiz.peso = 1 + max(self.avl_peso(raiz.izquierda), self.avl_peso(raiz.derecha))

        # Update the balance factor and balance the tree
        fb = self.avl_fb(raiz)
        if fb > 1:
            if telefono < raiz.izquierda.telefono:
                return self.rotacionDerecha(raiz)
            else:
                raiz.izquierda = self.rotacionIzquierda(raiz.izquierda)
                return self.rotacionDerecha(raiz)

        if fb < -1:
            if telefono > raiz.derecha.telefono:
                return self.rotacionIzquierda(raiz)
            else:
                raiz.derecha = self.rotacionDerecha(raiz.derecha)
                return self.rotacionIzquierda(raiz)

        return raiz

    def avl_peso(self, raiz):
        if not raiz:
            return 0
        return raiz.peso

    # Factor de Balance del nodo
    def avl_fb(self, nodo):
        if not nodo:
            return 0
        return self.avl_peso(nodo.izquierda) - self.avl_peso(nodo.derecha)

    def avl_Mintelefono(self, raiz):
        if raiz is None or raiz.izquierda is None:
            return raiz
        return self.avl_Mintelefono(raiz.izquierda)

    def preOrder(self, raiz):
        if not raiz:
            return
        print("{} {}".format(raiz.telefono, raiz.nombre))
        self.preOrder(raiz.izquierda)
        self.preOrder(raiz.derecha)
    
    def inOrder(self, raiz):
        if not raiz:
            return
        self.inOrder(raiz.izquierda)
        print("{} {}".format(raiz.telefono, raiz.nombre))
        self.inOrder(raiz.derecha)

    def posOrder(self, raiz):
        if not raiz:
            return
        self.posOrder(raiz.izquierda)
        self.posOrder(raiz.derecha)
        print("{} {}".format(raiz.telefono, raiz.nombre))

    def rotacionIzquierda(self, b):
        a = b.derecha
        T2 = a.izquierda
        a.izquierda = b
        b.derecha = T2
        b.peso = 1 + max(self.avl_peso(b.izquierda), self.avl_peso(b.derecha))
        a.peso = 1 + max(self.avl_peso(a.izquierda), self.avl_peso(a.derecha))
        return a

    def rotacionDerecha(self, b):
        a = b.izquierda
        T3 = a.derecha
        a.derecha = b
        b.izquierda = T3
        b.peso = 1 + max(self.avl_peso(b.izquierda), self.avl_peso(b.derecha))
        a.peso = 1 + max(self.avl_peso(a.izquierda), self.avl_peso(a.derecha))
        return a

    def buscar(self,raiz,value):
        if raiz.telefono != value:
            if value >raiz.telefono:
                return self.buscar(raiz.derecha,value)
            if value < raiz.telefono:
                return self.buscar(raiz.izquierda,value)
        if raiz:
            return raiz.nombre