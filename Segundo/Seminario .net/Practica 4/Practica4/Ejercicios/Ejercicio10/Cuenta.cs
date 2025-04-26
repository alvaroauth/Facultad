class Cuenta{
    private double _monto;
    private string? _titularDNI;
    private string? _titularNombre;

    public Cuenta(){
        this._monto = 0;
        this._titularNombre = "No especificado";
        this._titularDNI = "No especificado";
    }    

    public Cuenta(string? nombre, string? dni) : this(){
        this._titularNombre = nombre;
        this._titularDNI = $"{dni}";
    }

    public Cuenta(string nombre) : this(){
        this._titularNombre = nombre;
    }

    public Cuenta(int dni) : this(){
        this._titularDNI = $"{dni}";
    }

    public void depostiar(){
        
    }
    public void Imprimir(){
        Console.WriteLine($"Nombre: {this._titularNombre}, DNI:  {this._titularDNI ?? "No especificado" }");
    }
    
}