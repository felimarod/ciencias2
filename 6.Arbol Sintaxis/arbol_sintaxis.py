
sintaxis = {
    "sustantivo": ("perro","perra","gato","gata","persona","mujer","hombre"),
    "adjetivo": (),
    "verbo": ("esta","estaba","estará","fue","será"),
    "adverbio": ("limpio","sucio","alto","bajo","grande","pequeño"),
    "pronombre": (),
    "articulo": ("la","el","los"),
    "preposicion": ("para"),
    "conjuncion" : (),
    "interseccion": ()
}


class Nodo(object):
    def __init__(self,valor):
        self.valor = valor
        self.hijos = []
        

class Arbol_binario(object):
    def __init__(self):
        self.raiz = Nodo("o")
    def insertar(self, token):
        self.raiz.hijos.append(Nodo(token))
