using System.Runtime.CompilerServices;

class Ecuacion2{
    private int _a;
    private int _b;
    private int _c;

    public Ecuacion2(int a, int b, int c){
        this._a = a;
        this._b = b;
        this._c = c;
    }

    public double GetDiscriminante() => Math.Pow(this._b, 2)-(4*this._a*this._c);

    public int GetCantidadDeRaices() => this.GetDiscriminante() switch { < 0 => 0, 0 => 1, _ => 2 };

    public void ImprimirRaices(){
        switch (this.GetCantidadDeRaices()){
            case 0:
                Console.WriteLine("La ecuacion no posee soluciones reales");
                break;
            case 1:
                double sol = -this._b / (2 * this._a);
                Console.WriteLine($"La unica solucion es {sol}");
                break;
            case 2:
                double disc = this.GetDiscriminante();
                double x1 = (-this._b + disc) / (2 * this._a);
                double x2 = (-this._b - disc) / (2 * this._a); 
                Console.WriteLine($"Las dos soluciones son: X1 = {x1}, X2 = {x2}");
                break;
        }
    }
}