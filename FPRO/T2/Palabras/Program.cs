public class Palabras
{

    public static void Main(string[] args)
    {

        string[] palabras = new string[] { "Hola", "Adios", "que", "Tal" };
        // string[][] palabrasMulti = new string[][] { {"Hola"}, "Adios", "que", "Tal" };
        // [null,null, null,null,null,null,null,null,null,null]
        Console.WriteLine(palabras[palabras.Length - 1]);
        char[] abecedario = new char[] { 'a', 'b', 'c', 'd', 'e' };


        string palabraGenerada = ""; // 5 letras aleatorias del abecedario

        for (int i = 0; i < 5; i++)
        {
            int random = new Random().Next(0, abecedario.Length - 1);
            char letra = abecedario[random];
            palabraGenerada += letra;
        }

        Console.WriteLine(palabraGenerada);
        palabraGenerada = "Esto es un ejemplo";
        // correo@gmail.com // gmail
        // palabraGenerada.Split("@")[1].Split(".")[0]; // [E,sto e,s un ejemplo]
        string[] corte = palabraGenerada.Split("@");
        
        

    }



}