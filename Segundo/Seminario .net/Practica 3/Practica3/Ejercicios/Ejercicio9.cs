class Ejercicio9{
    public static void ejecutar(){


        //var a = 3L;
        dynamic b = 32;
        object obj = 3;
        //a = a * 2.0;
        Console.WriteLine("Da error porque no se puede convertir double en long");
        Console.WriteLine();
        b = b * 2.0;
        b = "hola";
        obj = b;
        b = b + 11;
        //obj = obj + 11; 
        Console.WriteLine("No existe el operador + para el object");
        Console.WriteLine();
        var c = new { Nombre = "Juan" };
        var d = new { Nombre = "María" };
        var e = new { Nombre = "Maria", Edad = 20 };
        var f = new { Edad = 20, Nombre = "Maria" };
        //f.Edad = 22;
        Console.WriteLine("No se puede modificar un var con mas de un campo, es de solo lectura");
        Console.WriteLine();
        d = c;
        //e = d;
        //f = e;
        Console.WriteLine("Los campos tienen distintos atributos adentro, no es valida la asignacion");
        Console.WriteLine();
    }
}