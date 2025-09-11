class Ejercicio9{
    public static void ejecutar(){

        DateTime inicio = DateTime.Now;
        
        char c1 = 'A';
        char c2 = 'A';
        //Console.WriteLine(c1 == c2);

        object o1 = c1;
        object o2 = c2;
        //Console.WriteLine(o1 == o2);

        //Console.WriteLine("--------------------------------------");
        //Console.WriteLine(" Imprime eso porque el primero es una comparacion entre primitivos, se compara su contenido, en el segundo se compararn direcciones de memoria, apuntan a dos celdas de memoria dsitinas");

        DateTime fin = DateTime.Now;

        TimeSpan tiempo = fin- inicio;

        Console.WriteLine($"Tiempo de ejecución: {tiempo.TotalMilliseconds} ms");
    }
}