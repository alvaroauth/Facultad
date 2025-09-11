class Ejercicio1{
    public static void ejecutar(){
        Persona p1 = new Persona("Alvaro",21,460457);
        Persona p2 = new Persona("Facundo",22,56789);
        Persona p3 = new Persona("Nico",19,450211);

        Console.WriteLine(p1.toString());
        Console.WriteLine();
        Console.WriteLine(p2.toString());
        Console.WriteLine();
        Console.WriteLine(p3.toString());

    }
}