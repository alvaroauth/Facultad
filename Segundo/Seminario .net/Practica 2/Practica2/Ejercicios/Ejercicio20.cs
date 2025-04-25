class Ejercicio20{
    public static void ejecutar(){
        Console.WriteLine("Ingrese el primer numero ( A )");
        string? a = Console.ReadLine();
        Console.WriteLine("Ingrese el segundo numero ( B )");
        string? b = Console.ReadLine();

        if (!string.IsNullOrEmpty(a) && !string.IsNullOrEmpty(b)){
            int numA = int.Parse(a);
            int numB = int.Parse(b);

            swap(ref numA, ref numB);

            Console.WriteLine($"El numero A ahora es {numA}, y el numero B ahora es {numB}");

        }
    }

    static void swap (ref int a, ref int b){
        int aux = a;
        a = b;
        b = aux;
    }
}