class Persona{
    private string _nombre;
    private char _sexo;
    private int _dni;
    private DateTime _nacimiento;
    private readonly int _edad;

    public Object? this[int i]{
        get{
            if (i == 0) return _nombre;
            if (i == 1) return _sexo;
            if (i == 2) return _dni;
            if (i == 3) return _nacimiento;
            if (i == 4) return _edad;
            return null;
        }
    }

    public Persona(string nombre, char sexo, int dni, DateTime nacimiento){
        this._nombre = nombre;
        this._sexo = sexo;
        this._dni = dni;
        this._nacimiento = nacimiento;
        this._edad = calcularEdad(nacimiento);
    }

    private int calcularEdad(DateTime cum){
        int edad = DateTime.Now.Year - cum.Year;
        DateTime cumAux = cum;
        edad = (DateTime.Now < cumAux.AddYears(edad))? edad-1 : edad;
        return edad;
    }

    public void Imprimir(){
        Console.WriteLine($"Nombre: {this._nombre}, Sexo: {this._sexo}, DNI: {this._dni}, Fecha de nacimiento: {this._nacimiento.ToString("dd/MM/yyyy")}, Edad: {this._edad}");
    }
}