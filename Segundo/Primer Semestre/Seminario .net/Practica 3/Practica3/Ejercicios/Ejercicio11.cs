class Ejercicio11{
    public static void ejecutar(){

        List<int> a = [ 1, 2, 3, 4 ];
        //a.Remove(5);
        //a.RemoveAt(4);

        Console.WriteLine("a.Remove(5);    //Da error porque el 5 no se encuentra en la lista, y el remove elimina la primera ocurrencia del elemento ");
        Console.WriteLine();
        Console.WriteLine("a.RemoveAt(4);  //Da error porque la lista no tenia posicion 4, va de 0 a lenght-1, osea de 0 a 3 ");

    }
}