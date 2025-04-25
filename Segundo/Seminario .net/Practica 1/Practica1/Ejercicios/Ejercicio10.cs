class Ejercicio10{
    public static void ejecutar(){
        Console.WriteLine("Multiplos de 17 o 29: ");
        for (int i = 1; i <= 1000; i++){
            if (i % 17 == 0 || i % 29 == 0)
                Console.WriteLine(i);
        }
    }
}