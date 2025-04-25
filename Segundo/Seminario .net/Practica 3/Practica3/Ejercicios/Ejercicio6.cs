class Ejercicio6{
    public static void ejecutar(){

        double[,] A = {
            { 1, 2, 3 },
            { 0, -1, 4 },
            { 5, 6, 0 }
        };

        double[,] B = {
            { -2, 1, 0 },
            { 3, 5, 7 },
            { 6, -4, 2 }
        };

        double[,]? mSuma = Suma(A,B);
        double[,]? mResta = Resta(A,B);
        double[,]? mMul = Multiplicacion(A,B);

        Console.WriteLine("   +++ SUMA +++");
        Console.WriteLine();
        if (mSuma == null) Console.WriteLine("Matriz Nula"); else ImprimirMatriz(mSuma);
        Console.WriteLine();

        Console.WriteLine("   +++ Resta +++");
        Console.WriteLine();
        if (mResta == null) Console.WriteLine("Matriz Nula"); else ImprimirMatriz(mResta);
        Console.WriteLine();

        Console.WriteLine("   *** Multiplicacion ***");
        Console.WriteLine();
        ImprimirMatriz(mMul);
        Console.WriteLine();


    }

    static double[,]? Suma(double[,] A, double[,] B){
        int Afil = A.GetLength(0);
        int Bfil = B.GetLength(0);
        int Acol = A.GetLength(1);
        int Bcol = B.GetLength(1);

        if ((Acol == Bcol)&&(Afil == Bfil)){

            double[,] Resul = new double[Afil, Acol];
            for(int i = 0; i < Afil ; i++){
                for (int j = 0; j < Acol; j++)
                    Resul[i,j] = A[i,j] + B[i,j];
            }

            return Resul;
        }
        return null;
    }

    static double[,]? Resta(double[,] A, double[,] B){
        int Afil = A.GetLength(0);
        int Bfil = B.GetLength(0);
        int Acol = A.GetLength(1);
        int Bcol = B.GetLength(1);

        if ((Acol == Bcol)&&(Afil == Bfil)){

            double[,] Resul = new double[Afil, Acol];
            for(int i = 0; i < Afil ; i++){
                for (int j = 0; j < Acol; j++)
                    Resul[i,j] = A[i,j] - B[i,j];
            }

            return Resul;
        }
        return null;
    }

    static double[,] Multiplicacion(double[,] A, double[,] B){
        int Bfil = B.GetLength(0);
        int Acol = A.GetLength(1);
        
        if ((Acol != Bfil)) throw new ArgumentException();

        else{

            int Afil = A.GetLength(0);
            int Bcol = B.GetLength(1);
            double[,] Resul = new double[Afil, Bcol];

            for(int i = 0; i < Afil ; i++){
                for (int j = 0; j < Bcol; j++){
                    double suma = 0;

                    for (int k = 0; k < Acol ; k++)
                        suma += A[i,k] * B[k,j];

                    Resul[i,j] = suma;
                }      
            }
            return Resul;
        }
    }

    static void ImprimirMatriz(double[,] matriz){
        int filas = matriz.GetLength(0);
        int columnas = matriz.GetLength(1);

        Console.WriteLine("Matriz:");
        for (int i = 0; i < filas; i++)
        {
            Console.Write("| ");
            for (int j = 0; j < columnas; j++)
            {
                Console.Write($"{matriz[i, j],6} ");
            }
            Console.WriteLine("|");
        }
        Console.WriteLine();
    }
}