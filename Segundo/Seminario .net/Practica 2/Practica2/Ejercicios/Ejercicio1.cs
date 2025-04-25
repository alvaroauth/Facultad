class Ejercicio1{
    public static void ejecutar(){
        object o1 = "A";
        object o2 = o1;
        o2 = "Z";
        Console.WriteLine(o1 + " " + o2);
        Console.WriteLine("-------------------------------");
        Console.WriteLine("No imprimen lo mismo porque los strings son ininmutables, entonces cuando le asigna un nuevo valor apunta a nueva celda de memoria");
    }
}