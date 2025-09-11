class Auto2{
    public string Marca { get; private set; } = "Ford";
    public Auto2(string marca) => this.Marca = marca;
    public Auto2() { }
}
class Taxi2 : Auto2{
    public int Pasajeros { get; private set; }
    public Taxi2(int pasajeros) => this.Pasajeros = pasajeros;
}