diccionarioInforme = {'titulo': "Titulo informe", 'prioridad': 'alta',
                      'contenido': 'este es el contenido del informe', 'colaboradores': ["Borja", "Javier", 'Pilar']}

# diccionarioFuncion = dict(
#    ["1a", "2a", "3a", "4a", "5a", {'elemento': "elemento"}])

diccionarioFuncion = dict({'elemento': "elemento"})
print(diccionarioFuncion)

# print(diccionarioInforme['titulo'])
# sacar todos los colaboradores del informe

diccionarioInforme['titulo'] = "Este es el titulo"

# del (diccionarioInforme['prioridad'])
# print(f'elemento eliminado: {diccionarioInforme.pop("prioridad")}')

# print(diccionarioInforme)

for i in diccionarioInforme.keys():
    print(i)


for colaborador in diccionarioInforme['colaboradores']:
    print(colaborador)
