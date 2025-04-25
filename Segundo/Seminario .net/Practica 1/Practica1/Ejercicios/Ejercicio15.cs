class Ejercicio15{
    public static void ejecutar(){
        Console.WriteLine("int i = 0;");
        Console.WriteLine("for (int i = 1; i <= 10;)");
        Console.WriteLine("{");
        Console.WriteLine("\tConsole.WriteLine(i++);");
        Console.WriteLine("}");
        Console.WriteLine();
        Console.WriteLine("------------------------------------------------");
        Console.WriteLine();
        Console.WriteLine(" El problema esta en que declara dos veces i, en el for y en el programa principal, se soluciona de dos maneras");
        Console.WriteLine();
        Console.WriteLine("Manera 1: ");
        Console.WriteLine();
        Console.WriteLine("for (int i = 1; i <= 10;i++)");
        Console.WriteLine("{");
        Console.WriteLine("\tConsole.WriteLine(i);");
        Console.WriteLine("}");
        Console.WriteLine();
        Console.WriteLine("Manera 2: ");
        Console.WriteLine();
        Console.WriteLine("int i = 0;");
        Console.WriteLine("for (; i <= 10;)");
        Console.WriteLine("{");
        Console.WriteLine("\tConsole.WriteLine(i++);");
        Console.WriteLine("}");
        Console.WriteLine("------------------------------------------------");
    }
}