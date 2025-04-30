class Ejercicio8{
    public static void ejecutar(){
        ListaDePersonas lp = new ListaDePersonas();
        lp.agregarPersona(new Persona("Alvaro",'H',46013,new DateTime(2004,08,18)));
        lp.agregarPersona(new Persona("Facundo",'H',15123,new DateTime(2005,10,22)));
        lp.agregarPersona(new Persona("Leandro",'H',44777,new DateTime(2004,03,22)));
        Persona? aux = lp[46013];
        if (aux != null)
            aux.Imprimir();
    }
}