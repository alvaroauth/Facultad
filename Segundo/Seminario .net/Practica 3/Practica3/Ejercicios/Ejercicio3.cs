class Ejercicio3{
    public static void ejecutar(){

        double[,] matriz = {
            { 1.234, 5.678, 9.012 },
            { 3.456, 7.890, 2.345 },
            { 6.789, 0.123, 4.567 }
        };

        Console.WriteLine("Ingrese el foramto del string");
        string? st = Console.ReadLine();

        if (!string.IsNullOrEmpty(st))
            ImprimirMatrizConFormato(matriz, st);
    }

        static void ImprimirMatrizConFormato(double[,] matriz,string formato){

        Console.Write("[ ");

        for (int i = 0; i < matriz.GetLength(0); i++){
            Console.Write("( ");

            for (int j = 0; j < matriz.GetLength(1); j++){
                Console.Write($"{matriz[i, j].ToString(formato)}, ");
            }

            Console.Write("\b\b ");
            Console.Write(") ");
            
            if (i < matriz.GetLength(0) - 1) Console.Write("; ");
        }
        Console.Write("]");
    }
}