class Ejercicio2{
    public static void ejecutar(){
        Persona2 p1 = new Persona2("Alvaro",21,460457);
        Persona2 p2 = new Persona2("Facundo",22,56789);
        Persona2 p3 = new Persona2("Nico",19,450211);

        Console.WriteLine(p1.Imprimir());
        Console.WriteLine();
        Console.WriteLine(p2.Imprimir());
        Console.WriteLine();
        Console.WriteLine(p3.Imprimir());

    }
}