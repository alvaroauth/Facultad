class Ejercicio9{
    public static void ejecutar(){
        Auto a = new Auto();
        a.Marca = "Ford";
        Console.WriteLine(a.Marca);
        Console.WriteLine("=======================================");
        Console.WriteLine("El problema esta en que usa el nombre de la propiedad en ve del backing field en el set, en el get returnea el backing field");
    }
}