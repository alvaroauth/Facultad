class Ejercicio18{
    public static void ejecutar(string[] args){
        int num = int.Parse(args[0]);
        Console.WriteLine($"El factorial de {num} numero es {fac(num)}");
        Console.WriteLine();
        Console.WriteLine($"El factorial (de manera recursiva) de {num} numero es {facRecursivo(num)}");
        Console.WriteLine();
        Console.WriteLine($"El factorial (expression-bodied methods) de {num} numero es {facTernario(num)}");
    }

    static int fac(int n){
        int fa = 1;
        if (n==0) return 1;
        else{
            for(int i = n ;i > 1 ;  i--)
                fa = fa * i;
        }
        return fa;
    }

    static int facRecursivo(int n){
        if (n==0 || n== 1) return 1;
        else return n * facRecursivo(n-1);
    }

    static int facTernario(int n) => n <= 1 ? 1 : n *facTernario(n-1) ;
}