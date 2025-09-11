
class Ejercicio4{
    public static void ejecutar(){

        double[,] matriz = {
            { 1.234, 5.678, 9.012 },
            { 3.456, 7.890, 2.345 },
            { 6.789, 0.123, 4.567 }
        };

        double[] diagP = GetDiagonalPrincipal(matriz);

        Console.Write(" Diagonal Principal: [");
        foreach(double d in diagP)
            Console.Write($"{d}, ");
        Console.WriteLine("\b\b ]");

        double[] diagS = GetDiagonalSecundaria(matriz);

        Console.Write(" Diagonal Secundaria: [ ");
        foreach(double d in diagS)
            Console.Write($"{d}, ");
        Console.WriteLine("\b\b ]");
    }

    static double[] GetDiagonalPrincipal(double[,] matriz){
        int filas = matriz.GetLength(0);
        int columnas = matriz.GetLength(1);

        if (columnas != filas) throw new ArgumentException();
        else{
                int j= columnas-1;
            double[] resultado = new double[filas];
            for (int i = 0; i < filas ; i++, j--)
                resultado[i] = matriz[i,i];
            return resultado;
        }
        
    }

    static double[] GetDiagonalSecundaria(double[,] matriz){
        int filas = matriz.GetLength(0);
        int columnas = matriz.GetLength(1);

        if (columnas != filas) throw new ArgumentException();
        else{
                int j= columnas-1;
            double[] resultado = new double[filas];
            for (int i = 0; i < filas ; i++, j--)
                resultado[i] = matriz[j,i];
            return resultado;
        }
        
    }
}