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

    public void Depositar(double monto){
        this._monto += monto;
    }

    public void Extraer(double monto){
        if (monto < this._monto)
            this._monto -= monto;
        else   
            Console.WriteLine("Operacion cancelada, monto insuficiente");
    }
    public void Imprimir(){
        Console.WriteLine($"Nombre: {this._titularNombre}, DNI:  {this._titularDNI}, Monto: {this._monto}");
    }
    
}