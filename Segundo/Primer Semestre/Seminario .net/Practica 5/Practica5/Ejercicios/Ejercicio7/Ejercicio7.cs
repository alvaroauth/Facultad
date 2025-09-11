class Ejercicio7{
    public static void ejecutar(){
        Persona p1 = new Persona("Alvaro",'H',46013,new DateTime(2004,08,18));

        p1.Imprimir();

        Console.WriteLine(p1[0]);
        Console.WriteLine(p1[1]);
        Console.WriteLine(p1[2]);
        Console.WriteLine(p1[3]);
        Console.WriteLine(p1[4]);
        Console.WriteLine(p1[5]);
    }
}