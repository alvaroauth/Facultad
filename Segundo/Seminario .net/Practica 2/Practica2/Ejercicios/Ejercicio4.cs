class Ejercicio4{
    public static void ejecutar(){
        
        object o = "Hola Mundo!";

        //string st = o;
        string? st = o as string;

        int i = 12;

        //byte b = i;
        byte b = (byte)i;

        double d = i;

        //float f = d;
        float f = (float)d;

        o = i;

       //i = o + 1;
        i = (int)o + 1;

        Console.WriteLine("string st = o;  No compila porque object no se convierte implicitamente a string");
        Console.WriteLine();

        Console.WriteLine("byte b = i;  No compila porque al pasar un entero a byte se pueden perder datos");
        Console.WriteLine();

        Console.WriteLine("float f = d;  No compila porque al pasar un double a float se puede perder precision");
        Console.WriteLine();

        Console.WriteLine("string st = o;  Se requiere casteo explicito");
        Console.WriteLine();

    }
}