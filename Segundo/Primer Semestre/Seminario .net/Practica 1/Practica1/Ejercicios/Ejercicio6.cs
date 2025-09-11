class Ejercicio6{
    public static void ejecutar(){
        Console.WriteLine("Ingrese uan cadena de carateres");
        string? st = Console.ReadLine();
        while (!string.IsNullOrEmpty(st)){
            Console.WriteLine($"La longitud de la cadena ingresada es {st.Length}");
            st = Console.ReadLine();
        }
    }
}