class Ejercicio1{
    public static void ejecutar(){
        Console.CursorVisible = false;

        ConsoleKeyInfo k = Console.ReadKey(true);

        while (k.Key != ConsoleKey.End){
            Console.Clear();
            Console.Write($"{k.Modifiers}-{k.Key}-{k.KeyChar}");
            k = Console.ReadKey(true);
        }
    }
}