class Ejercicio8{
    public static void ejecutar(){
        
        object obj = new int[10];
        dynamic dyna = 13;
        //Console.WriteLine(obj.Length);
        Console.WriteLine("Console.WriteLine(obj.Length);  //Falla porque obj no tiene un metodo lenght ya que no sabe lo que contiene, la manera seria ((int[] obj).lenght)");
        //Console.WriteLine(dyna.Length);
        Console.WriteLine("Console.WriteLine(dyna.Length);  //Falla en ejecucion porque dyna es un int y no tiene el metodo .lenght");

    }
}