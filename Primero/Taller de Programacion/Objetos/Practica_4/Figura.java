
package Practica_4;


public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
    
    public Figura (String r, String l){
        setColorRelleno(r);
        setColorLinea(l);
    }
    @Override
    public String toString(){
        String aux = "  CL: "+getColorLinea()+"  CR: "+getColorRelleno()+"  Area: "+this.calcularArea()+"  Perimetro: "+this.calcularPerimetro();
        return aux;
    }
    public void despintar(){
        setColorLinea("Negro");
        setColorRelleno("Blanco");
    }
    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    public abstract double calcularPerimetro();
    public abstract double calcularArea();
    
    
    
}
