class Ejercicio3{
    public static void ejecutar(){
        Cuenta2 c1 = new Cuenta2();
        c1.Depositar(100).Depositar(50).Extraer(120).Extraer(50);
        Cuenta2 c2 = new Cuenta2();
        c2.Depositar(200).Depositar(800);
        new Cuenta2().Depositar(20).Extraer(20);
        c2.Extraer(1000).Extraer(1);
        Console.WriteLine("\nDETALLE");
        Cuenta.ImprimirDetalle();
        Console.WriteLine();
        Console.WriteLine("#####################################################");
        Console.WriteLine();

        List<Cuenta2> lista = Cuenta2.s_listaCuentas;
        foreach(Cuenta2 c in lista)
            c.Imprimir();
        lista[0].Depositar(123);
        lista[0].Imprimir();
    }
}
        