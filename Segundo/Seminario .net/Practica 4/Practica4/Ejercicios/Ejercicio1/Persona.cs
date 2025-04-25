class Persona{
    public string nombre;
    public int edad;
    public int dni;

    public Persona(string nombre,int edad,int dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public virtual string toString(){
        return $"Nombre: {this.nombre} \t Edad: {this.edad} \t DNI: {this.dni}";
    }

}