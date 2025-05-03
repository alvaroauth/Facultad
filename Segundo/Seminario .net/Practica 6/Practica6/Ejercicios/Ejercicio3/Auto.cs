class Auto{
    protected double velocidad;
    public virtual void Acelerar() => Console.WriteLine("Velocidad = {0}", velocidad += 10);
}
class Taxi : Auto{
    public override void Acelerar() => Console.WriteLine("Velocidad = {0}", velocidad += 5);
}