class Ejercicio9{
    public static void ejecutar(){
        Console.WriteLine("Ingrese dos palabras separadas por un espacio");
        string? st = Console.ReadLine();
        if ((!string.IsNullOrEmpty(st)) && (st.Length%2 == 1)){
            int i = 0;
            Boolean ok = st[0] == st[st.Length-1];
            while(i < st.Length/2 && ok){
                ok = st[++i] == st[st.Length-1-i];
            }
            if (ok) Console.WriteLine(" Las palabras son simetricas ");
            else Console.WriteLine(" Las palabras NO son simetricas ");
        }
    }
}