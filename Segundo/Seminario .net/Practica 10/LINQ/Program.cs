/*List<string> lista = ["uno", "dos", "tres"];
var secuencia = lista.Select(st => $"({st})".ToUpper());
Mostrar(secuencia);
var secuencia2 = secuencia.Select(st => st.Length);
Mostrar(secuencia2);
var secuencia3 = secuencia2.Select(n => n/2.0);
Mostrar(secuencia3);

void Mostrar<T>(IEnumerable<T> secuencia)
{
   foreach (T elemento in secuencia)
   {
       Console.Write(elemento + " ");
   }
   Console.WriteLine();
}*/

var personas = Persona.GetLista();
personas.ForEach(p => Console.WriteLine(p));
Console.WriteLine();
personas.Where(p => p.Edad >= 18).ToList().ForEach(p => Console.WriteLine(p));



class Persona
{
    public string Nombre { get; private set; }
    public int Edad { get; private set; }
    public string Pais { get; private set; }
    public Persona(string nombre, int edad, string pais)
    {
        Nombre = nombre;
        Edad = edad;
        Pais = pais;
    }
    public override string ToString()
    {
        return $"{Nombre} ({Edad} años) {Pais.Substring(0, 3)}.";
    }

    // vamos a hardcodear una lista de personas
    // que usaremos en los siguientes ejemplos
    // para ello definimos el siguiente método estático
    public static List<Persona> GetLista()
    {
        return new List<Persona>() {
           new Persona("Pablo",15,"Argentina"),
           new Persona("Juan", 55,"Argentina"),
           new Persona("José",9,"Uruguay"),
           new Persona("María",33,"Uruguay"),
           new Persona("Lucía",16,"Perú"),
       };
    }
}