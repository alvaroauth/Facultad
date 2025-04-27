Console.WriteLine("Ingrese el ejercicio que quiere ejecutar");
string? st = Console.ReadLine();

if (!string.IsNullOrEmpty(st)){
    int op = int.Parse(st);

    switch (op){
        case 1:
            Ejercicio1.ejecutar();
            break;

    }
}