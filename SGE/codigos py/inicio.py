# Comentario unico
"""
Cometaripos de lineas múltiples
para poder documentar
"""
nombre = 'Borja'  # string
edad = 39  # number -> int
altura = 1.78  # number -> float
experiencia = True  # boolean
asignaturas = ['PMDM', 'SGE', 'AD']  # list[string] list[Any]

nombre1, edad1, altura1 = 'Borja1', 39, 1.78

print(type(nombre))
print(type(edad1))
print(type(asignaturas))
print(type(altura))

lenguaje = 'Python'
asignatura = 'SGE'
curso = 2023
ciclo = 'DAM'
anio = 2
cursando = True

# print(palabra + " "+lenguaje)
# Este contenido es para el curso de SGE en el ciclo de DAM 2 y en concreto para la asignatura SGE que esta cursando True
""" print('Este contenido es para el curso de %s en %s en el ciclo de %s %d y en concreto para la asignatura %s que esta cursando' %
      (asignatura, lenguaje, ciclo, anio, asignatura)) """

""" print('Este contenido es para el curso de {} en {} en el ciclo de {} {} y en concreto para la asignatura {} que esta cursando {}'.format(
    asignatura, lenguaje, ciclo, anio, asignatura, cursando)) """

print(
    f'Este contenido es para el curso de {asignatura} en {lenguaje} en el ciclo de {ciclo} {anio} y en concreto para la asignatura {asignatura} que esta cursando {cursando}')

palabra = 'Esto es un ejemplo de palabra para evaluarla en'
correo = 'borja@univearsidadeuropea.es'
# print(len(asignaturas))
# print(palabra[0])
print(palabra[len(palabra)-1])

posicion = correo.index('@')
nombreUsuario = correo[0:posicion]
dominio = correo[posicion+1:len(correo)]

print(nombreUsuario)
print(dominio.capitalize())
print(correo.count('ea'))
print(correo.endswith('es'))
print(correo.find('x'))

# borja - 0:4
# universidadeuropea.es 5:final

# Coleccion list
# [1,2,123,123,123,123,123,123]
numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

del numeros[-1]
print(numeros)

numeros.remove(8)


# lo borra y lo retorna
print(f'El numero {numeros.pop(0)} ha sido borrado con exito')


# print(numeros[-1])
print(numeros[len(numeros)-1])
primeros = numeros[0:5]
print(numeros)


print(primeros)

palabras = list()
palabras.append('primera')
palabras.append('segunda')
palabras.append('tercera')
palabras.extend(['cuarta', 'quinta', 'sexta'])
palabras.insert(0, "Dato")
print(palabras)

resultado = ["4", "5", "6"] + ["1", "2", "3"]
resultado = ["4", "5", "6"] * 4
print(resultado)
