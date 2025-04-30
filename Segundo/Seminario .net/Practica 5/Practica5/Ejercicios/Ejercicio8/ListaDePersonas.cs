
class ListaDePersonas{
    
    private List<Persona> _lista;

    public Persona? this[int i] => _lista.FirstOrDefault(p => (int)p[2] == i);

    public ListaDePersonas(){
        this._lista = new List<Persona>();
    }

    public ListaDePersonas(List<Persona> l){
        this._lista = l;
    }
    public void agregarPersona(Persona p){
        this._lista.Add(p);
    }
}
