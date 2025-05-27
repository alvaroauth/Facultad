
package Practica_3;


public class Hotel {
    private int maximo;
    private Habitacion [] habitaciones;
    
    public Hotel (int n){
        maximo = n;
        habitaciones = new Habitacion[n];
        for (int j = 0; j < n; j++) 
           habitaciones[j] = new Habitacion();
    }
        
    public void agregarCliente(Cliente c, int n){
        habitaciones[n].ocupar(c);
    }
    public int getNumHabitaciones(){
        return this.maximo;
    }
    
    public void aumentarHabitaciones(double n){
        for(int i=0;i<maximo;i++){
            habitaciones[i].aumentarPrecio(n);
        }
    }
    
    @Override
    public String toString(){
        String aux = "";
        for (int i = 0;i<maximo;i++){
            aux += " * * * Habitacion "+i+"   "+habitaciones[i].toString()+"\n";
        }
        return aux;
    }
}
