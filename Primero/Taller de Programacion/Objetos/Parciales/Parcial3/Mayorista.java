package Parciales.Parcial3;

public class Mayorista extends Compra {
    private String cuit;

    public Mayorista(int numero, int max,String cuit) {
        super(numero, max);
        this.setCuit(cuit);
    }
    @Override
    public String toString (){
        return super.toString()+"   CUIT: "+this.getCuit();
    }
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    
    
    
}
