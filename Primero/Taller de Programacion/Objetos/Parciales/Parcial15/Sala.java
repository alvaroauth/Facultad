
package Parciales.Parcial15;

public class Sala {
    private PC [] compus;
    private int max;
    
    public Sala(int max){
        this.setMax(max);
        this.compus = new PC [max];
        for (int i=0;i<this.getMax();i++){
            this.compus[i] = null;
        }
        
    }

    public int getMax() {
        return max;
    }

    private void setMax(int max) {
        this.max = max;
    }
    
    public void agregarPC (int x, PC pc){
        this.compus[x-1] = pc;
    }
    public void encenderPc(){
        double min= 9999999;
        int aux=0;
        for (int i=0;i<this.getMax();i++){
            if (!this.compus[i].isEstado() && this.compus[i] != null && this.compus[i].getConsumo()<min){
                min = this.compus[i].getConsumo();
                aux = i;
            }
        }
        this.compus[aux].setEstado(true);
    }
    @Override
    public String toString (){
        String aux= "- - - PC's Encendidas - - -"+"\n";
        for (int i=0;i<this.getMax();i++){
            if(this.compus[i] != null && this.compus[i].isEstado())
                aux += " ---> Computadora "+(i+1)+this.compus[i].toString()+"\n";
        }
        return aux;
    }
}
