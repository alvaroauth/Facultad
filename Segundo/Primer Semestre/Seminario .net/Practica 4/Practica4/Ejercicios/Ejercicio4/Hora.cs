class Hora{
    private int _horas;
    private double _minutos;
    private double _segundos;

    public Hora(int horas,double minutos,double segundos){
        this._horas = horas;
        this._minutos = minutos;
        this._segundos = segundos;
    }

    public void Imprimir() => Console.WriteLine($"{_horas} horas, {_minutos} minutos, {_segundos} segundos");
}