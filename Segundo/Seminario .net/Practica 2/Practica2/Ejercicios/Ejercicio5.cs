class Ejercicio5{
    public static void ejecutar(){
        char c1 = 'A';                 
        string st1 = "A";              
        object o1 = c1;                
        object o2 = st1;               
        char c2 = (char)o1;                    
        string st2 = (string)o2;           

        Console.WriteLine(" ---> Hay un boxing en la linea 3 (char se convierte a object)");
        Console.WriteLine(" ---> Hay un unboxing en la linea 5 (object se convierte a char)");
        }
}