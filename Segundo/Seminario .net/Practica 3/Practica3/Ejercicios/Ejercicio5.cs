class Ejercicio5{
    public static void ejecutar(){

        double[,] matriz = {
            { 1.234, 5.678, 9.012 },
            { 3.456, 7.890, 2.345 },
            { 6.789, 0.123, 4.567 }
        };
        double[][] arregloDeArreglo = GetArregloDeArreglo(matriz);

        int fil = arregloDeArreglo.GetLength(0);

        for (int i = 0; i < fil ; i++){
            int col = arregloDeArreglo[i].GetLength(0);
            for (int j = 0; j< col; j++)
                Console.Write($"| {arregloDeArreglo[i][j]} | ");
            Console.WriteLine("\b\n");
        }
    }

    static double[][] GetArregloDeArreglo(double [,] matriz){
        int col = matriz.GetLength(1);
        int fil = matriz.GetLength(0);
        double [][] aux = new double[fil][];

        for (int i = 0; i < fil ; i++){
            aux[i] = new double[col];
            for (int j = 0; j< col; j++)
                aux[i][j] = matriz[i,j];
        }

        return aux;
    }
}