from arbol_sintaxis import sintaxis, Nodo, Arbol_sintaxis


def identificar_tipo_palabra(pal):
    for tipo in sintaxis:
        if pal in sintaxis[tipo]:
            return tipo


arbol = Arbol_sintaxis()

arbol.insertar("articulo")
arbol.insertar("sustantivo")
arbol.insertar("verbo")
# Complemento
arbol.insertar("adverbio")

est = arbol.estructura_oracion()


print("La estructura de la oración es: ")
for i in range(len(est) ):
    print(est[i], end="\t")

print("\n\nEjemplo: La gata está limpia")
palabras = input("\nIngrese la frase que desea verificar: ").split()

est = arbol.estructura_oracion()
tam_ora = len(est)

if len(palabras) < len(est):
    print("La cantidad de palabras ingresadas no es acorde con el mínimo esperado")
    exit(2)

i = 0
while i < tam_ora:
    #print("Palabra a verificar:", palabras[i], "\tTipo de palabra esperada",est[i])
    if identificar_tipo_palabra(palabras[i]) != est[i]:
        print("\nLa oración no es acorde a la estructura esperada")
        exit(2)
    i += 1

print("La frase cumple con la forma de la oración planteada al inicio.")