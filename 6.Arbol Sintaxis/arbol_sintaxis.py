
sintaxis = {
    "sustantivo": ("perro", "perra", "gato", "gata", "persona", "mujer", "hombre"),
    "adjetivo": (),
    "verbo": ("es", "era", "está", "estaba", "estará", "fue", "será"),
    "adverbio": ("limpio", "limpia", "sucio", "sucia", "alto", "bajo", "grande", "pequeño"),
    "pronombre": (),
    "articulo": ("la", "el", "los"),
    "preposicion": ("para"),
    "conjuncion": (),
    "interseccion": ()
}


class Nodo(object):
    def __init__(self, valor):
        self.valor = valor
        self.hijos = []


class Arbol_sintaxis(object):
    def __init__(self):
        self.raiz = Nodo("o")

    def insertar(self, token):
        self.raiz.hijos.append(Nodo(token))

    def print_inorden(self):
        for hijo in self.raiz.hijos:
            if hijo != None:
                print(hijo.valor, end="\t") 

    def estructura_oracion(self):
        est = []
        for hijo in self.raiz.hijos:
            if hijo != None:
                est.append(hijo.valor)
        return est
