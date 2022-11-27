import random
import csv

nombres = (
    "María",
    "José",
    "Luis",
    "Luz",
    "Ana",
    "Carlos",
    "Juan",
    "Jorge",
    "Marta",
    "Sandra",
    "Gloria",
    "Blanca",
)
apellidos = (
    "Rodríguez",
    "Martínez",
    "García",
    "Gómez",
    "López",
    "González",
    "Hernández",
    "Sánchez",
    "Pérez",
    "Ramírez",
    "Díaz",
    "Torres"
)
telefonos = []

class contacto:
    def __init__(self, nombre, apellido, numero):
        self.nombre_completo = nombre + " " + apellido
        self.numero = numero

    def get_datos(self):
        return [self.nombre_completo,self.numero]

contactos = []

nums = [ i for i in range(800050)]

for i in range(800000):
    ran = random.randint(0,len(nums) -1)
    contactos.append(contacto(random.choice(nombres), random.choice(apellidos), 3*10**10 + nums.pop(ran)))

with open('contactos.csv', 'w', newline='') as csvfile:
    spamwriter = csv.writer(csvfile, delimiter=' ',
                            quotechar='|', quoting=csv.QUOTE_MINIMAL)
    for contacto in contactos:
        spamwriter.writerow(contacto.get_datos())
print("Terminado")

