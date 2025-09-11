class Ejercicio15{
    public static void ejecutar(){

        int x = 0;
        try
        {
        Console.WriteLine($"Primer writeline {1.0 / x}");
        Console.WriteLine("Sigo");
        Console.WriteLine(1 / x);
        Console.WriteLine("todo OK");
        }
        catch (Exception e)
        {
        Console.WriteLine(e.Message);
        }
    }
}