

class Informe:

    # todas las variables declaradas desde self

    def __init__(self, nombre, titulo, contenido, elementos):
        self.__nombre = nombre
        self.titulo = titulo
        self.contenido = contenido
        self.elementos = elementos

    def funcionEjemplo(self):
        print(self.__nombre)
        print(self.titulo)
        print(self.contenido)
        print(self.elementos)

    @staticmethod
    def getNombre(self):
        return self.__nombre


informe = Informe("Nombre", "titulo", "contenido", [1, 2, 3, 4, 5, 6])
informe.funcionEjemplo()
print(f'el titulo del informe es {informe.getNombre()}')


class InformePersonalizado(Informe):
    def __init__(self, nombre, titulo, contenido, elementos, personalizado):
        super().__init__(nombre, titulo, contenido, elementos)
        self.personalizo = personalizado

    def funcionEjemplo(self):
        print(self.personalizo)
        return super().funcionEjemplo()


infoPerso = InformePersonalizado("Nombre", "titulo", "contenido", [
                                 1, 2, 3, 4, 5, 6], "Personalizado")
