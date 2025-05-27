
package Parciales.Parcial15;

public class PC {
    private boolean estado;
    private double consumo;
    
    public PC( double consumo){
        this.setEstado(false);
        this.setConsumo(consumo);
    }
    public PC(){
        this.setEstado(false);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getConsumo() {
        return consumo;
    }

    private void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return " --> Prendida: " + this.estado + "   Consumo=" + this.consumo;
    }
    
    
}
