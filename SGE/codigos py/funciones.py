from inicio import primeros


def nombreFuncion(paramentro1, paramentro2):
    print(paramentro1)
    print(paramentro2)

# nombreFuncion(1, 2)


def imprimirDatos(dato1, dato3, dato2='defecto'):
    print(f'El dato pasado como param dato1 es {dato1}')
    print(f'El dato pasado como param dato2 es {dato2}')
    print(f'El dato pasado como param dato3 es {dato3}')


# imprimirDatos("primer dato", "segundo dato", "tercer dato")
# imprimirDatos(dato3="tercero", dato1="primero")

def imprimirAdicionales(*datos):
    # imprimir un conjunto de datos
    for i in datos:
        for j in i:
            print(j)


def funcionRetorno(param1, param2):  # None
    suma = param1+param2
    return [param1, param2]


# for i in funcionRetorno(4, 7):
#    print(i)


# numero de parametos = 9
# numero de parametos = n de 0 a infinito
# imprimirAdicionales(1, 2, 3, 4, 5, 6, 7, 8, 9, [10, 11, 12, 13, 14, 15, 16])
# imprimirAdicionales([1, 2, 3, 4, 5, 6, 7, 8, 9], ["palabra1", "palabra2"], [10, 11, 12, 13, 14, 15, 16])
