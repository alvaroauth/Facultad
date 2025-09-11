class Ejercicio7{
    public static void ejecutar(){
        
        int i = 10;

        var x = i * 1.0;
        Console.WriteLine("var x = i * 1.0;  // x queda como float");

        var y = 1f;
        Console.WriteLine("var y = 1f;  // y queda como float");

        var z = i * y;
        Console.WriteLine("var z = i * y;  // z queda como float");

    }
}