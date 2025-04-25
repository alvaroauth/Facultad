class Ejercicio4{
    public static void ejecutar(){
        Console.WriteLine("Ingrese un nombre");
        string? st = Console.ReadLine();
        if (!string.IsNullOrEmpty(st))
            Console.WriteLine($"Hola {st}");
        else    
            Console.WriteLine("Hola Mundo");
    }
}