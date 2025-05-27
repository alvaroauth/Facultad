
package Parciales.Parcial_Repetido1;

public class Funcion {
    private String titulo;
    private String fecha;
    private String hora;
    private Butaca [] [] butacas;
    private int filas;
    private int buta;
    
    public Funcion (String titulo, String fecha, String hora, int n, int m){
        this.setTitulo(titulo);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setFilas(n);
        this.setButa(m);
        this.butacas = new Butaca [n][m];
        int i,j;
        for (i =0;i<this.getFilas();i++){
            for (j=0;j<this.getButa();j++)
                this.butacas[i][j] = new Butaca(i,j);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    private void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    private void setHora(String hora) {
        this.hora = hora;
    }

    public int getFilas() {
        return filas;
    }

    private void setFilas(int filas) {
        this.filas = filas;
    }

    public int getButa() {
        return buta;
    }

    private void setButa(int buta) {
        this.buta = buta;
    }
    
    public double ocuparButaca( int n, int m){
        n--; m--;
        this.butacas[n][m].setEstado(true);
        return this.butacas[n][m].getPrecio();
    }
    public void desocuparButacas(int n){
        n--;
        for (int i=0;i<this.getButa();i++){
            this.butacas[n][i].setEstado(false);
        }
    }
    public String stringButaca (int m){
        String aux=" - - - Butacas Numero "+m+" - - -"+"\n";
        m--;
        for (int i=0;i<this.getFilas();i++){
            aux += this.butacas[i][m].toString()+"\n";
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String aux=" - - - FUNCION "+this.getTitulo().toUpperCase()+" - - -"+"\n";
        aux += "   ---> Fecha: "+this.getFecha()+"\n";
        aux += "   ---> Horario: "+this.getHora()+"\n";
        int i,j;
        for(i=0;i<this.getFilas();i++){
            aux += " - - - FILA "+(i+1)+" - - -"+"\n";
            for(j=0;j<this.getButa();j++){
                aux += this.butacas[i][j].toString()+"\n";
            }
        }
        return aux;
    }
    
}
