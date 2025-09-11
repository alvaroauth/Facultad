class Ejercicio3{
    public static void ejecutar(){
        Persona3 p1 = new Persona3("Alvaro",21,460457);
        Persona3 p2 = new Persona3("Facundo",22,56789);

        Console.WriteLine(p1.Imprimir());
        Console.WriteLine();
        Console.WriteLine(p2.Imprimir());
        Console.WriteLine();
        Console.WriteLine(p1.EsMayorQue(p2)? "La primera persona es mayor que la segunda" : " La primera persona NO es mayor que la segunda");

    }
}