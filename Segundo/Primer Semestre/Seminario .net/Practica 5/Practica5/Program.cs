Console.WriteLine("Ingrese el ejercicio que quiere ejecutar");
string? st = Console.ReadLine();

if (!string.IsNullOrEmpty(st)){
    int op = int.Parse(st);

    switch (op){
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
            Ejercicio4.ejecutar();
            break;
        case 5:
            Ejercicio5.ejecutar();
            break;
        case 6:
            Ejercicio6.ejecutar();
            break;
        case 7:
            Ejercicio7.ejecutar();
            break;
        case 8:
            Ejercicio8.ejecutar();
            break;
        case 9:
            Ejercicio9.ejecutar();
            break;
        case 10:
            Ejercicio10.ejecutar();
            break;
        default:
            Ejercicio11.ejecutar();
            break;
    }
}
Console.ReadKey();