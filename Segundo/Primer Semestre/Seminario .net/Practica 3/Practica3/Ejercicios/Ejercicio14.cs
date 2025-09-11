class Ejercicio14{
    public static void ejecutar(){
        
        Queue<int> cola = new Queue<int>(new int[] {5,3,9,7});

        Console.WriteLine(" Ingrese una clave para encriptar");
        string? st = Console.ReadLine();

        if (!string.IsNullOrEmpty(st)){

            char[] caracteres = st.ToCharArray();
            foreach ( char car in caracteres){
                if (enRango(car)){
                    int aux = evaluar(car);
                    aux = codificar(aux, cola);
                    Console.Write(convertirNumero(aux));
                }
            }
        }
    }
    
    private static Boolean enRango(char car) => ((car <= 'Z' && car >= 'A')||(car == 'Ñ')||(car == ' '));

    private static int evaluar(char c){
        if (c == 'Ñ')
            return 15;
        if(c== ' ')
            return 28;
        if (c <= 'N')
            return c-'A'+1;
        else 
            return c-'A'+2;
    }

    private static int codificar(int c, Queue<int> cola){
        int clave = cola.Dequeue();
        cola.Enqueue(clave);

        c += clave;
        if (c > 28)
            c -= 28;

        return c;
    }

    private static char convertirNumero(int aux){
        if (aux == 15) return 'Ñ';
        if (aux == 28) return ' ';

        if (aux <= 14) aux += 'A'-1;
        else aux += 'A'-2;
        return (char)aux;
    }
}