
enum Meses
{
    Enero,
    Febrero,
    Marzo,
    Abril,
    Mayo,
    Junio,
    Julio,
    Agosto,
    Septiembre,
    Octubre,
    Noviembre,
    Diciembre
}
class Ejercicio12{
    public static void ejecutar(){
        string[] aMeses = Enum.GetNames(typeof(Meses));
        Array.Reverse(aMeses);

        foreach (string a in aMeses){
               Console.WriteLine(a);
         }

        Console.WriteLine("Ingrese el mes a buscar");
        string? st = Console.ReadLine();
        if(!String.IsNullOrEmpty(st)){
            bool existe = (Enum.IsDefined(typeof(Meses), st.ToLower()));
            Console.WriteLine(existe);
        }
    }
}