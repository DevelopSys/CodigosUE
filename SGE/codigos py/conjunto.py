conjuntoUno = {1, 2, 3, 4, 5, 6, 7, 8, 9}
conjuntoDos = {3, 4, 7, 11, 12, 14, 15, 16}
conjuntoFuncion = set([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])

# print(type(conjuntoFuncion))
# conjunto.add(9)
# conjunto.remove(9)

# for i in conjunto:
#    print(i)

# union
conjuntoResultante = conjuntoUno.union(conjuntoDos)
# diferencia
conjuntoResultante = conjuntoUno.difference(conjuntoDos)
# diferencia simetrica
conjuntoResultante = conjuntoUno.symmetric_difference(conjuntoDos)
# interseccion
conjuntoResultante = conjuntoUno.intersection(conjuntoDos)
print(conjuntoResultante)
