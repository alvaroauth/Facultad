class Ejercicio21{
    public static void ejecutar(){
        Imprimir("abc", 1.21, 13 ,'a', DayOfWeek.Saturday);
        Imprimir(1, 2, "tres");
        Imprimir();
    }

    static void Imprimir(params object[] o){
        foreach(object ob in o)
            Console.Write($"{ob}   ");
        Console.WriteLine();
    }
}