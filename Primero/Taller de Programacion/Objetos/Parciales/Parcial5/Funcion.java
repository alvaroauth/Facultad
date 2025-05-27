
package Parciales.Parcial5;

public class Funcion {
    private String titulo;
    private String fecha;
    private String hora;
    private Butaca [][] butacas;
    private int maxF;
    private int maxB;
    
    public Funcion(String titulo, String fecha, String hora, int n, int m) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.maxB=m;
        this.maxF=n;
        butacas = new Butaca [n][m];
        int i,j;
        for (i=0;i<n;i++){
            for (j=0;j<m;j++){
                String aux= "Butaca: ("+(i+1)+","+(j+1)+")";
                butacas[i][j] = new Butaca(aux, this.setPrecioButaca(i), false);
            }
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getMaxF() {
        return maxF;
    }

    public int getMaxB() {
        return maxB;
    }
    
    private double setPrecioButaca(int n){
        return 800+(100*n);
    }
    public double ocuparButaca(int n, int m){
        this.butacas[n-1][m-1].setOcupada(true);
        return this.butacas[n-1][m-1].getPrecio();
    }
    public void desocuparButacas(int n){
        n--;
        for (int i=0; i<this.getMaxB();i++){
            this.butacas[n][i].setOcupada(false);
        }
    }
    public String repButacas(int m){
        String aux="";
        for (int i=0;i<this.getMaxF();i++){
            aux += butacas[i][m-1].toString()+"\n";
        }
        return aux;
    }
    @Override
    public String toString(){
        String aux="";
        aux += "Titulo: "+this.getTitulo()+"   Fecha: "+this.getFecha()+"   Hora: "+this.getHora()+"\n";
        aux += "Butacas:"+"\n";
        int i;
        for(i=0;i<this.getMaxF();i++){
            aux+= this.repButacas(i+1);
        }
        return aux;
    }
}
