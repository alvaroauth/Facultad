class Ejercicio19{
    public static void ejecutar(string[] args){
        int num = int.Parse(args[0]);
        int f, fr;
        Fac(num, out f);
        FacRec(num, out fr);
        Console.WriteLine($"El factorial de {num} numero es {f}");
        Console.WriteLine();
        Console.WriteLine($"El factorial (de manera recursiva) de {num} numero es {fr}");
        Console.WriteLine();
    }

    static void Fac(int n, out int f){
        f = 1;
        for (int i = n; i > 1; i--)
            f *= i;
    }

    static void FacRec(int n, out int f)
    {
        if (n <= 1)
            f = 1;
        else
        {
            FacRec(n - 1, out int temp);
            f = n * temp;
        }
}
}