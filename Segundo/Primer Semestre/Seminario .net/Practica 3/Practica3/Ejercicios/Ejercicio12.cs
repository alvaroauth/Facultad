using System.Reflection.PortableExecutable;

class Ejercicio12{
    public static void ejecutar(){
        Console.WriteLine(" Ingrese una secuencia de caracteres para saber si es balanceada");

        string? st = Console.ReadLine();

        bool ok = false;

        if (!string.IsNullOrEmpty(st)){
            Stack<char> pila = new Stack<char>();
            ok = true;

            List<char> apertura = [ '{', '[', '(' ];
            List<char> cierre =  [ '}', ']', ')' ];

            if ((st.Length %2 != 0 )&&(cierre.Contains(st[0]))) ok = false;
            else{
                int i = 0;
                char act,ape,cie;
                while (i < st.Length && ok){
                    act = st[i];
                    if (apertura.Contains(act)) pila.Push(act);
                    else if (pila.Count != 0){
                        ape = pila.Pop();
                        cie = act;
                        if (apertura.IndexOf(ape) != cierre.IndexOf(cie)) ok = false;
                    }
                    i++;
                }
            }

        }
        string resul = (ok)? "La cadena esta balanceada" : "La cadena esta desbalanceada";
        Console.WriteLine(resul);
    }
}