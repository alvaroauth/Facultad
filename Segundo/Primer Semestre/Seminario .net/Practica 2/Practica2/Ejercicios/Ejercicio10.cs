class Ejercicio10{
    public static void ejecutar(){
        /*

        Despues del primer foreach

        Pila:
        |        |
        |   s    | --> Referencia al StringBuilder ("Framework Net")
        |   v    | --> Referencia al arreglo v en el heap
        |________|

        Heap:
        [Arreglo v]
        [0: Ref] --> [StringBuilder: "Framework Net"]
        [1: Ref] --> [StringBuilder: "Framework Net"]
        [2: Ref] --> [StringBuilder: "Framework Net"]
        [3: Ref] --> [StringBuilder: "Framework Net"]
        [4: Ref] --> [StringBuilder: "Framework Net"]
        [5: Ref] --> [StringBuilder: "Framework Net"]
        [6: Ref] --> [StringBuilder: "Framework Net"]
        [7: Ref] --> [StringBuilder: "Framework Net"]
        [8: Ref] --> [StringBuilder: "Framework Net"]
        [9: Ref] --> [StringBuilder: "Framework Net"]

        Despues del segundo foreach

        Pila:
        |        |
        |   s    | --> Referencia al StringBuilder (varía según iteración)
        |   v    | --> Referencia al arreglo v en el heap
        |________|

        Heap:
        [Arreglo v]
        [0: Ref] --> [StringBuilder: "Framework Net"]
        [1: Ref] --> [StringBuilder: "Framework Net"]
        [2: Ref] --> [StringBuilder: "Framework Net"]
        [3: Ref] --> [StringBuilder: "Framework Net"]
        [4: Ref] --> [StringBuilder: "Framework Net"]
        [5: Ref] --> [StringBuilder: "CSharp"]
        [6: Ref] --> [StringBuilder: "Framework Net"]
        [7: Ref] --> [StringBuilder: "Framework Net"]
        [8: Ref] --> [StringBuilder: "Framework Net"]
        [9: Ref] --> [StringBuilder: "Framework Net"]

        */

        Console.WriteLine("El dibujo esta comentado :p");
    }
}