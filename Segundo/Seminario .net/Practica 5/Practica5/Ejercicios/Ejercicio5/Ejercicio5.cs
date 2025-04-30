class Ejercicio5{
    public static void ejecutar(){
        Console.WriteLine("new ClaseA().c = 'a';\t Da error porque no exite ClaseA");
        Console.WriteLine();
        Console.WriteLine("c = 'B';\t Da error porque no podes acceder a atributos de isntancia en un metodo estatico");
        Console.WriteLine();
        Console.WriteLine("new A().st = otro string;\t Da error porque no podes acceder a atributos estaticos desde instancias");
    }
}