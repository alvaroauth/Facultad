class Ejercicio16{
    public static void ejecutar(){
        int i = 1;
        if (--i == 0){ // i pasa de 1 a 0, y se evalúa como 0 == 0 → verdadero
            Console.WriteLine("cero"); // ✅ Se imprime "cero"
        }

        if (i++ == 0){ // i en este momento vale 0 → se evalúa como 0 == 0 → verdadero
            Console.WriteLine("cero"); // ✅ Se imprime "cero"
        }

        Console.WriteLine(i); // Después del post-incremento anterior, i ahora vale 1 → se imprime "1"
    }
}