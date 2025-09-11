class Cuenta2{
    private static int s_id {get;set;} = 0;
    private static int s_qRechazados{get;set;} = 0;
    private static int s_qDepositos{get;set;} = 0;
    private static int s_qExtracciones{get;set;} =0;
    private static double s_totalDepositos{get;set;} = 0;
    private static double s_totalExtracciones{get;set;} =0;
    private double _monto {get;set;} = 0;
    private  int  _id {get;set;} =1;
    public static List <Cuenta2> s_listaCuentas =new List<Cuenta2>();


    public Cuenta2(){
        this._monto = 0;
        this._id = ++s_id;
        s_listaCuentas.Add(this);
        Console.WriteLine($"SE CREO LA CUENTA ID = {this._id}");
    }   

    public Cuenta2 Depositar(double monto){
        this._monto += monto;
        s_qDepositos++;
        s_totalDepositos += monto;
        Console.WriteLine($"SE DEPOSITO {monto} EN LA CUENTA {this._id} ( SALDO= {this._monto} )");
        return this;
    }

    public Cuenta2 Extraer(double monto){
        if (monto <= this._monto){
            this._monto -= monto;
            s_qExtracciones++;
            s_totalExtracciones += monto;
            Console.WriteLine($"SE EXTRAJO {monto} DE LA CUENTA {this._id} (SALDO= {this._monto} )");
        }
        else{
            Console.WriteLine  ("OPERACION DENEGADA-SALDO INSUFICIENTE");
            s_qRechazados++;
        } 
        return this;
    }

    public static void ImprimirDetalle(){
        Console.WriteLine($" - - -  Cuentas creadas: {s_id}");
        Console.WriteLine($" - - -  Cantidad de depositos: {s_qDepositos}");
        Console.WriteLine($" - - -  Cantidad de extracciones: {s_qExtracciones}");
        Console.WriteLine(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        Console.WriteLine($" - - -    Total de depositos: {s_totalDepositos}");
        Console.WriteLine($" - - - Total de extracciones: {s_totalExtracciones}");
        Console.WriteLine($" - - -                 Saldo: {s_totalDepositos - s_totalExtracciones}");
        Console.WriteLine(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        Console.WriteLine($"Se rechazaron {s_qRechazados} pagos por falta de fondos");
    }

    public void Imprimir(){
        Console.WriteLine($"ID: {_id}, Monto: {_monto}");
    }

    public List<Cuenta2> getCuentas(){
        return new List<Cuenta2> (s_listaCuentas);
    }
}