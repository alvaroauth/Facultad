class Ejercicio5{
    public static void ejecutar(){
        Console.WriteLine("Ingrese su nombre:");
        string? st = Console.ReadLine();
        switch(st){
            case "Juan":
                Console.WriteLine("Hola amigo!");
            break;

            case "Maria":
                Console.WriteLine("Buen día señora");
            break;

            case "Alberto":
                Console.WriteLine("Hola Alberto");
            break;

            case "":
                Console.WriteLine("¡Buen día mundo!");
            break;
            
            default:
                Console.WriteLine($"Buen dia {st}");
            break;
        }
    }
}