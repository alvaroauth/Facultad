
package Parciales.Parcial3;

public class Minorista extends Compra {
    private boolean jubilado;
    public Minorista(int numero, int max,boolean jub) {
        super(numero, max);
        this.setJubilado(jub);
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
    @Override
    public String toString(){
        return super.toString()+"   Es jubilado?: "+this.isJubilado();
    }
    
    
}
