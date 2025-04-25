

class Ejercicio11{
    public static void ejecutar(){
        Console.WriteLine("Ingrese una frase para imprimir cada palabra por separado");
        string? st = Console.ReadLine();
        if (!string.IsNullOrEmpty(st)){
            string[] vectorString = st.Split(" ");
            foreach(string s in vectorString)
                Console.WriteLine(s);
        }
    }
}