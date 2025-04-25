class Ejercicio12{
    public static void ejecutar(){
        Console.WriteLine("Ingrese un numero para imprimir toos sus divisores");
        string? st = Console.ReadLine();
        if (!string.IsNullOrEmpty(st)){
            int num = int.Parse(st);
            for (int i = 0; i<= num; i++)
                if (num%i == 0) Console.WriteLine(i);
        }
    }
}