class Persona2{
    private string _nombre;
    private int _edad;
    private int _dni;

    public Persona2(string nombre,int edad,int dni){
        this._nombre = nombre;
        this._edad = edad;
        this._dni = dni;
    }
    public string Imprimir(){
        return $"Nombre: {this._nombre} \t Edad: {this._edad} \t DNI: {this._dni}";
    }

}