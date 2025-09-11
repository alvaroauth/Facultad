class Ejercicio14{
    public static void ejecutar(){
        Console.WriteLine(" *-*-*-* Ingrese dos numeros para calcualr el maximo *-*-*-*");
        Console.WriteLine("Ingrese el primer numero");
        string? st1 = Console.ReadLine();
        Console.WriteLine("Ingrese el segundo numero");
        string? st2 = Console.ReadLine();

        if (!string.IsNullOrEmpty(st1) && !string.IsNullOrEmpty(st2)){
            int num1 = int.Parse(st1);
            int num2 = int.Parse(st2);

            int max = (num1 >=  num2)? num1 : num2;
            Console.WriteLine($"El maximo es: {max}");
        }
    }
}