class Ejercicio6{
    public static void ejecutar(){
        double[,] datos1 = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        double[,] datos2 = {
            { 9, 8, 7 },
            { 6, 5, 4 },
            { 3, 2, 1 }
        };

        Matriz m1 = new Matriz(datos1);
        Matriz m2 = new Matriz(datos2);

        Console.WriteLine("Matriz 1:");
        m1.imprimir();

        Console.WriteLine("\nMatriz 2:");
        m2.imprimir();

        Matriz suma = new Matriz(datos1);
        suma.sumarle(m2);
        Console.WriteLine("\nSuma (m1 + m2):");
        suma.imprimir();

        Matriz resta = new Matriz(datos1);
        resta.restarle(m2);
        Console.WriteLine("\nResta (m1 - m2):");
        resta.imprimir();

        Matriz producto = new Matriz(datos1);
        producto.multiplicarPor(m2);
        Console.WriteLine("\nMultiplicación (m1 * m2):");
        producto.imprimir();

        Console.WriteLine("\nDiagonal principal de m1:");
        double[] diagP = m1.DiagonalPrincipal;
        for (int i = 0; i < diagP.Length; i++)
            Console.Write(diagP[i] + " ");
        Console.WriteLine();

        Console.WriteLine("\nDiagonal secundaria de m1:");
        double[] diagS = m1.DiagonalSecundaria;
        for (int i = 0; i < diagS.Length; i++)
            Console.Write(diagS[i] + " ");
        Console.WriteLine();

        Console.WriteLine("\nFila 1 de m1:");
        double[] fila = m1.GetFila(1);
        for (int i = 0; i < fila.Length; i++)
            Console.Write(fila[i] + " ");
        Console.WriteLine();

        Console.WriteLine("\nColumna 2 de m1:");
        double[] columna = m1.GetColumna(2);
        for (int i = 0; i < columna.Length; i++)
            Console.Write(columna[i] + " ");
        Console.WriteLine();
    }
}