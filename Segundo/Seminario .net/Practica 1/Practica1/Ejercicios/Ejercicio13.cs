class Ejercicio13{
    public static void ejecutar(){
        Console.WriteLine("if ((b != 0) & (a/b > 5)) Console.WriteLine(a/b); ");
        Console.WriteLine("-------------------------------------------------");
        Console.WriteLine(" El problema es que al ser & simple, chequea ambas condiciones si o si, y si b = 0 se fija\n que a/b sea mayor a 5, y se rompe, por lo que hay que poner && para solucionarlo");
    }
}