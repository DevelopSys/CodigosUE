// crear un array aletrando posiciones por pares
int[] rotar = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
// 2, 1, 3, 4, 5, 6, 7, 8, 9, 10
// 0  1  2  3  4  5  6  7  8  9 

// temporal = 1
/* for (var i = 0; i < rotar.Length - 1; i += 2)
{
    // 0 y 1
    int temporal = rotar[i];
    rotar[i] = rotar[i + 1];
    rotar[i + 1] = temporal;
} */

// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// 10, 1, 3, 4, 5, 6, 7, 8, 9, 1
//  0  1  2  3  4  5  6  7  8  9
// 0 1 2 3 4 -> incrementa en 1
// 9 8 7 6 5 -> decrementa en 1

// i = 1
// t=2∏
for (int i = 0; i < rotar.Length; i++)
{
    int temporal = rotar[i];
    rotar[i] = rotar[rotar.Length - 1 - i];
    rotar[rotar.Length - 1 - i] = temporal;
}

foreach (var item in rotar)
{
    Console.WriteLine(item);
}

// hacer un espejo del array