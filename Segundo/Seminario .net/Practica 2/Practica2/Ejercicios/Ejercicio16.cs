class Ejercicio16{
    public static void ejecutar(string[] args){
        Console.WriteLine("Se imprimen los nombres pasados por argumento");
        for (int i =0; i< args.Length ;i++)
            Console.WriteLine($"Hola {args[i]} !!!");

        foreach(string s in args)
            Console.WriteLine($"Hola {s} !!!");
    }
}