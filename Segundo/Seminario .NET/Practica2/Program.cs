using System.Numerics;
using System.Text;
enum Meses {Enero,Febrero,Marzo,Abril,Mayo,Junio,Julio,Agosto,Septiembre,Octubre,Noviembre,Diciembre};
class Program
{
    private static void Main(string[] args)
    {
        Console.WriteLine("-------------------------------  1  -------------------------------\n");
        object o1 = "A";
        object o2 = o1;
        // *1
        o2 = "Z";
        // *2
        Console.WriteLine(o1 + " " + o2);
        // La explicacion es que al hacer o2 = "Z", el programa pone "Z" en otro lugar de la memoria heap, ya que
        //  la misma no puede sobreescribirse, en el *1, si hacemos o1 == 02 va a dar true, en cambio, 
        // en el *2 va a dar false
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  2  -------------------------------\n");
        char c1 = 'A';
        string st1 = "A";
        object o3 = c1; //Aca hay un Boxing, mete al cahr en una caja y lo manda a la heap
        object o4 = st1; //Aca hay otro boxing, hace lo mismo que el de arriba
        char c2 = (char)o3; //Aca hay un Unboxing, ya que c2 esta siendo traido desde la heap
        string st2 = (string)o4; //idem que arriba
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  3  -------------------------------\n");
        //Las conversiones Implicitas las hace el mismo compialdor ya que no hay riesgo de perdida de datos, por ejemplo 
        // convertir un byte en un int, el int es mas grande por lo que es imposible que se pierda algo, si fuera al reves habria que acalarar 
        //de forma explicita con byte b = (byte)i, asumiendo el programador la responsabilidad del caso en que se pieda algo
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  4  -------------------------------\n");
        object o = "Hola Mundo!";
        string? st = o as string;
        int i = 12;
        byte b = (byte)i;
        double d = i;
        float f = (float)d;
        o = i;
        i = (int)o + 1;
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  5  -------------------------------\n");
        //Es exactamente igual que el 3 xd
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  6  -------------------------------\n");
        //int i;
        //Console.WriteLine(i);

        // No compila debido a que C# no deja imprimir datos a los que no se les haya dado un valor inicial o asignado antes
        Console.WriteLine("\n");



        Console.WriteLine("-------------------------------  7  -------------------------------\n");

        DateTime ini = DateTime.Now; // Ignorar, es del ejercicio 9

        char c3 = 'A';
        char c4 = 'A';
        Console.WriteLine(c3 == c4);
        object o5 = c3;
        object o6 = c4;
        // object o6 = o5;
        Console.WriteLine(o5 == o6);
        // Imprime primero True y despues False, debido a que cuando comparamos chars comparamos el 
        // contenido en la memoria stack, mientras que en los objetos comparamos sus referencias, y estas
        // son distinas por mas que sea el mismo elemento, si hicieramos o5 = c3, o6 = o5, daria true

        DateTime fin = DateTime.Now; // Ignorar, es del ejercicio 9

        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  8  -------------------------------\n");
        // El StringBuilder es un String al que se lo puede modificar ya sea entero o por partes, e decir no es ininmutable, se recomienda utilizar en caso
        // de que haya que agregarle un espacio al final a cada String en un vector por ejemplo, en ese caso un string normal volveria a crear la cantidad 
        // que haya de nuevo solo agregandole un espacio
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  9  -------------------------------\n");
        TimeSpan duracion = fin - ini; //Ver en el ejercicio 7
        Console.WriteLine($"La duracion fue de {duracion.TotalMilliseconds} milisegundos");
        Console.WriteLine("\n");


        Console.WriteLine("-------------------------------  10  -------------------------------\n");
        object[] v = new object[10];
        v[0] = new StringBuilder("Net");
        for (int i2 = 1; i2 < 10; i2++)
        {
            v[i2] = v[i2 - 1];
        }
        (v[5] as StringBuilder).Insert(0, "Framework .");
        foreach (StringBuilder s in v)
            Console.WriteLine(s);
        //dibujar el estado de la pila y la mem. heap
        //en este punto de la ejecución
        Console.WriteLine("---------------------------------------------");
        //En este punto de la pila todas las posiciones del vector referencian a lo mismo gracias al for, cada posicion es un mismo StringBuilder, un cambio en cualquiera se hace en todos

        v[5] = new StringBuilder("CSharp");
        foreach (StringBuilder s in v)
            Console.WriteLine(s);
        //dibujar el estado de la pila y la mem. heap
        //en este punto de la ejecución

        //En este punto todas las posiciones menos el 5 apuntan al mismo, que no se modifico, y el 5 genero una nueva celda de memoria con otra frase, desvinculandose del resto

        Console.WriteLine("\n");

        Console.WriteLine("-------------------------------  11  -------------------------------\n");
        string? st4 = Console.ReadLine();
        if (!string.IsNullOrEmpty(st4)){
            string[] vs = st4.Split(' ');
            foreach (string aux in vs)
            {
                Console.WriteLine(aux);
            }
        }

        Console.WriteLine("\n");

        Console.WriteLine("-------------------------------  11  -------------------------------\n");
        for (Meses m = Meses.Enero; m <= Meses.Diciembre; m++)
        {
            Console.WriteLine(m);
        }
        Console.WriteLine("---------------------------------------------");
        for (Meses m = Meses.Diciembre; m >=Meses.Enero ; m--)
        {
            Console.WriteLine(m);
        }


        Console.ReadKey();
    }
}


