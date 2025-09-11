class Ejercicio6{
    public static void ejecutar(){
        Ecuacion2 e1 = new Ecuacion2(1,4,5);
        Ecuacion2 e2 = new Ecuacion2(1,-6,9);
        Ecuacion2 e3 = new Ecuacion2(1,-5,6);

        Console.WriteLine("x^2 + 4x + 5");
        Console.WriteLine();
        e1.ImprimirRaices();
        Console.WriteLine();
        Console.WriteLine("------------------------------------------------------------------");
        Console.WriteLine("x^2 - 6x + 9");
        Console.WriteLine();
        e2.ImprimirRaices();
        Console.WriteLine();
        Console.WriteLine("------------------------------------------------------------------");
        Console.WriteLine("x - 5x + 6");
        Console.WriteLine();
        e3.ImprimirRaices();
        Console.WriteLine("------------------------------------------------------------------");

    }
}