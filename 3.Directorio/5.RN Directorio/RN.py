# Nodo de árbol rojo-negro
class Nodo(object):
    def __init__(self, numero, nombre):
        self.numero = numero  # Campo de datos
        self.nombre = nombre
        self.color = 0  # 0 rojo 1 negro
        self.izquierdo = None
        self.derecho = None
        self.padre = None


# Árbol negro rojo
class RN(object):
    def __init__(self):
        self.raiz = None

    def inOrden(self, x):
        if x == None:
            return
        self.inOrden(x.izquierdo)
        colorStr = 'negro' if x.color == 1 else 'rojo'
        padreStr = 'Padre =' + ('nil' if x.padre == None else str(x.padre.numero))
        print(x.numero, x.nombre, colorStr, padreStr)
        self.inOrden(x.derecho)

    # Agregar un nodo
    def insertar(self, x):
        # Si no hay un nodo raíz como nodo raíz
        if self.raiz == None:
            self.raiz = x
            x.color = 1  # El nodo raíz es negro
            # print ('Agregado exitosamente', x.numero)
            return
        # Encuentre una posición de inserción adecuada
        p = self.raiz
        while p != None:
            if x.numero < p.numero:
                if p.izquierdo == None:
                    p.izquierdo = x
                    x.padre = p
                    # print ('Agregado exitosamente', x.numero)
                    self.ajustar(x)
                    break
                p = p.izquierdo
            else:
                if p.derecho == None:
                    p.derecho = x
                    x.padre = p
                    # print ('Agregado exitosamente', x.numero)
                    self.ajustar(x)
                    break
                p = p.derecho

    # Ajusta el árbol rojo-negro
    def ajustar(self, x):
        while True:
            if x == self.raiz:  # Si se procesa el nodo raíz, el color es negro
                x.color = 1
                return
            p = x.padre  # Padre
            if p.color == 1 or x.color == 1:  # Mientras uno de mí y papá sea negro, no puede ser doblemente rojo, luego regrese
                return
            # A continuación, analiza la situación de Red Dad
            g = p.padre  # El abuelo Red Dad debe tener un padre, porque el rojo nunca es el nodo raíz
            u = g.izquierdo if p == g.derecho else g.derecho  # El tío El tío puede ser un nodo vacío
            if u != None and u.color == 0:  #     Luego coloréalo y continúa ajustando del abuelo
                u.color = p.color = 1  # Tío y papá se ponen negros
                g.color = 0  # El abuelo se pone rojo
                x = g  # x apunta al abuelo y luego continúa el ciclo
                continue
            # A continuación, analiza la situación del tío Hei. Hay cuatro situaciones: izquierda, izquierda, derecha, izquierda, derecha
            if p == g.izquierdo and x == p.izquierdo:  # Izquierda izquierda
                # Usa a papá como punto de apoyo
                self.rotatederecho(p)
            elif p == g.izquierdo and x == p.derecho:  # Acerca de
                # Usa x como punto de apoyo
                self.rotateizquierdo(x)
                # Use x como pivote para girar al abuelo a la derecha (la rotación anterior convierte al abuelo en un nuevo padre)
                self.rotatederecho(x)
            elif p == g.derecho and x == p.derecho:  # Derecha derecha es en realidad la imagen especular de izquierda e izquierda
                # Abuelo zurdo con padre como pivote
                self.rotateizquierdo(p)
            elif p == g.derecho and x == p.izquierdo:  # Derecha izquierda es en realidad la imagen especular de izquierda y derecha
                # Usa x como punto de apoyo
                self.rotatederecho(x)
                # Toma x como punto de apoyo para girar a la izquierda al abuelo (la rotación anterior convierte al abuelo en un nuevo padre)
                self.rotateizquierdo(x)

    #
    # En cuanto a la rotación de los árboles rojo y negro, siempre ha sido un punto difícil
    # Aquí proporciono una fórmula:
    # Rotación derecha: el fulcro ocupa la posición original del punto de rotación, el punto de rotación derecho del fulcro se usa como el izquierdo y el punto de rotación es el derecho del fulcro
    # Rotación izquierda: el fulcro ocupa la posición original del punto de rotación, el punto de rotación izquierdo del fulcro se usa como el derecho y el punto de rotación es la izquierda del fulcro
    #
    # Pivote p para diestros
    def rotatederecho(self, p):
        g = p.padre  # El nodo padre del pivote es el punto de giro
        # Diestro g
        if g == self.raiz:  # Si g es el nodo raíz, entonces p se convierte en el nodo raíz
            self.raiz = p
            p.padre = None
        else:  # Si g no es el nodo raíz, entonces debe haber g. El padre p ocupa la posición de g
            gp = g.padre
            p.padre = gp
            if g == gp.izquierdo:
                gp.izquierdo = p
            else:
                gp.derecho = p
        g.izquierdo = p.derecho
        if p.derecho != None:
            p.derecho.padre = g
        p.derecho = g
        g.padre = p
        # g y p intercambio de color
        p.color, g.color = g.color, p.color

    # Pivote p para zurdos
    def rotateizquierdo(self, p):
        g = p.padre  # El nodo padre del pivote es el punto de giro
        # Zurdo g
        if g == self.raiz:  # Si g es el nodo raíz, entonces p se convierte en el nodo raíz
            self.raiz = p
            p.padre = None
        else:  # Si g no es el nodo raíz, entonces debe haber g. El padre p ocupa la posición de g
            gp = g.padre
            p.padre = gp
            if g == gp.izquierdo:
                gp.izquierdo = p
            else:
                gp.derecho = p
        g.derecho = p.izquierdo
        if p.izquierdo != None:
            p.izquierdo.padre = g
        p.izquierdo = g
        g.padre = p
        # g y p intercambio de color
        p.color, g.color = g.color, p.color

    # Buscar nodo dado el valor
    def buscar(self,raiz,value):
        if raiz.numero != value:
            if value >raiz.numero:
                return self.buscar(raiz.derecho,value)
            if value < raiz.numero:
                return self.buscar(raiz.izquierdo,value)
        if raiz:
            return raiz.nombre


