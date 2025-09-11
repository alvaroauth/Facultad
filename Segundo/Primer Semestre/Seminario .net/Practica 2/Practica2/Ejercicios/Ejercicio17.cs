class Ejercicio17{
    public static void ejecutar(string[] args){
        int num = int.Parse(args[0]);
        Console.WriteLine($" El numero ingresado por argumento es: {num}");
        string result = (esPrimo(num))? "El numero ingresado es primo" : "El numero ingresado NO es primo";
        Console.WriteLine(result);
    }

    static bool esPrimo(int n){
        double raiz = Math.Sqrt(n);
        for (int i = 2; i <= raiz; i++){
            if (n%i == 0) return false;
        }
        return true;
    }
}