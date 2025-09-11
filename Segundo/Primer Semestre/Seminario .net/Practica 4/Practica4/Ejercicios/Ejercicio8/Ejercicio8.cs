class Ejercicio8{
    public static void ejecutar(){
        Console.WriteLine("En el primer caso compila porque se crea sola pero tira NullPointerException en ejecucion");
        Console.WriteLine();
        Console.WriteLine("En el segundo caso no compila porque las variables locales no se crean solas y y dice Use of unassigned local variable 'bar'.");
    }
}