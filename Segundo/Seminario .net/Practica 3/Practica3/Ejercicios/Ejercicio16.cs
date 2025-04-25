class Ejercicio16{
    public static void ejecutar(){
        double suma = 0;

        Console.WriteLine("Ingese numeros para imprimir su suma");
        string? st = Console.ReadLine();
        while(!string.IsNullOrEmpty(st)){
            try{
                suma += double.Parse(st);
            }
            catch{
                Console.WriteLine("ojo con lo que ingresas");
            }
            Console.WriteLine("Ingese numeros para imprimir su suma");
            st = Console.ReadLine();
        }
        Console.WriteLine((suma !=0)? $"La suma de todos los numeros es de {suma}" : "No se ingresaron numeros validos");
    }
}