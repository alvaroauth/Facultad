class Ejercicio10{
    public static void ejecutar(){

        double num = 3.456;
        Console.WriteLine("Formato compuesto: {0:F2}", num);


        double num2 = 2.934;
        Console.WriteLine($"Interpolado: {num2:F1}");

        double num3 = 7.555;

        double truncado = Math.Truncate(num3 * 100) / 100;

        Console.WriteLine("Truncado manual: " + truncado);
        Console.WriteLine("Formato redondeado: {0:F2}", num3);
    }
}