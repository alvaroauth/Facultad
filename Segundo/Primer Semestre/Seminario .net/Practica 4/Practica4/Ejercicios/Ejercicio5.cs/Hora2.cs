class Hora2{
    private int _horas;
    private int _minutos;
    private double _segundos;

    public Hora2(int horas,int minutos,double segundos){
        this._horas = horas;
        this._minutos = minutos;
        this._segundos = segundos;
    }

    public Hora2(double num){
        this._horas = (int)num;

        double parteDecimal = num - this._horas;

        this._minutos = (int)(parteDecimal * 60);

        double parteDecimalMin = (parteDecimal * 60) - this._minutos;

        this._segundos = parteDecimalMin * 60;
    }
    

    public void Imprimir() => Console.WriteLine($"{this._horas} horas, {this._minutos} minutos, {this._segundos} segundos");
}