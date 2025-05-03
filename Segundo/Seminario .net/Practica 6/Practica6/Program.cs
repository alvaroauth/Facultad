Console.WriteLine(" --> Ingrese un ejercicio para ejecutar <--");
string? st = Console.ReadLine();
Console.WriteLine();
if (!string.IsNullOrEmpty(st)){
    int opcion = int.Parse(st);

    switch(opcion){
        case 1:
            Ejercicio1.ejecutar();
            break;
        case 2: 
            Ejercicio2.ejecutar();
            break;
        case 3: 
            Ejercicio3.ejecutar();
            break;
        case 4: 
            Ejercicio3.ejecutar();
            break;
    }
}
Console.ReadKey();