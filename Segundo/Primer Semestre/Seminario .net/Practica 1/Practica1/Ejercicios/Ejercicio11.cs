class Ejercicio11{
    public static void ejecutar(){
        Console.WriteLine("10 / 3 = " + 10 / 3);             
        Console.WriteLine("10.0 / 3 = " + 10.0 / 3);         
        Console.WriteLine("10 / 3.0 = " + 10 / 3.0);         

        int a = 10, b = 3;
        Console.WriteLine("Si a y b son variables enteras, y a = 10 y b = 3:");
        Console.WriteLine("Entonces a / b = " + a / b);       

        double c = 3;
        Console.WriteLine("Si c es una variable double, y c = 3:");
        Console.WriteLine("Entonces a / c = " + a / c); 

        Console.WriteLine("-----------------------------------------------------------------");
        Console.WriteLine("A: El / hace que si ambos miembros son enteros, imprime un entero, en caso de que alguno sea doble (ya sea variable o inmediato) hace division entre reales");
        Console.WriteLine("B: El + en strings concatena lo que sea convirtiendo a string todo");
    }
}