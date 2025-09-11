class Ejercicio13{
    public static void ejecutar(){
        
        Console.WriteLine("Ingrese un numero decimal para convertir ");
        string? st = Console.ReadLine();
        Console.WriteLine();

        Console.WriteLine("Ingrese la base del nuevo numero");
        string? ba = Console.ReadLine();
        Console.WriteLine();

        if (!string.IsNullOrEmpty(st) && !string.IsNullOrEmpty(ba)){

            Stack<int> pila = new Stack<int>();

            int num = int.Parse(st);
            int bas = int.Parse(ba);
            int resto;

            while (num != 0){
                resto = num % bas;
                pila.Push(resto);
                num /= bas;
            }

            string cadena = "";
            int dig;
            while(pila.Count != 0){
                dig = pila.Pop();
                if (bas == 16){
                    string aux = dig.ToString("X");
                    cadena += aux;
                }
                else cadena += dig.ToString();
            }
            Console.WriteLine(cadena);
        }
    }
}