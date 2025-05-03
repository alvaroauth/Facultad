class Ejercicio2{
    public static void ejecutar(){
        A[] vector = [ new C(1),new D(2),new B(3),new D(4),new B(5)];
        foreach (A a in vector){
            if (a is B)
                a.Imprimir();
        }
        Console.WriteLine();
        A[] vector2 = [ new C(1),new D(2),new B(3),new D(4),new B(5)];
        foreach (A a in vector2){
            if (a.GetType() == typeof(B))
                a.Imprimir();
        }
    }
}