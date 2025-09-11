class Ejercicio2{
    public static void ejecutar(){
        double[,] matriz = new double[,]
        {
            { 1.1, 2.2, 3.3 },
            { 4.4, 5.5, 6.6 },
            { 7.7, 8.8, 9.9 }
        };

        ImprimirMatriz(matriz);
    }

        static void ImprimirMatriz(double[,] matriz){
        Console.Write("[ ");
        for (int i = 0; i < matriz.GetLength(0); i++){
            Console.Write("( ");
            for (int j = 0; j < matriz.GetLength(1); j++){
                Console.Write($"{matriz[i, j]}, ");
            }
            Console.Write("\b\b ");
            Console.Write(") ");
            if (i < matriz.GetLength(0) - 1) Console.Write("; ");
        }
        Console.Write("]");
    }
}