
package Parciales.Parcial6;

public class Concurso {
    private Cancion [][] canciones;
    private int [] dimL;
    private int maxCan;
    private int maxCate;

    public Concurso(int maxCan, int maxCate) {
        int i,j;
        this.maxCan = maxCan;
        this.maxCate = maxCate;
        this.canciones = new Cancion [maxCate][maxCan];
        this.dimL = new int [maxCate];
        for (i=0;i<this.maxCate;i++){
            this.dimL[i] = 0;
        }
        for(i=0;i<this.maxCate;i++){
            for(j=0;j<this.maxCan;j++){
                this.canciones[i][j]=null;
            }
        }
    }
    
    
    private void iniciarVector(){
        for (int i=0;i<this.getMaxCate();i++){
            this.dimL[i] = 0;
        }
    }
    private void iniciarMatriz(){
        int i,j;
        for(i=0;i<this.getMaxCate();i++){
            for(j=0;j<this.getMaxCan();j++){
                this.canciones=null;
            }
        }
    }

    public int getMaxCan() {
        return maxCan;
    }

    public int getMaxCate() {
        return maxCate;
    }
    public void agregarCancion(Cancion cancion, int categoria){
        this.canciones[categoria][dimL[categoria]++] = cancion;
    }
    
//    public void interpretarCancion(int id, Estudiante e, double p){
//        int i=0,j;
//        boolean ok = false;
//        while ((i<this.getMaxCate())&&(!ok)){
//            j=0;
//            while ((i<this.dimL[i])&&(!ok)){
//                j++;
//                if (this.canciones[i][j].getIdentificador() == id){
//                    ok = true;
//                }
//            }
//            i++;
//        }
//    }
    
    public void interpretarCancion(int id, Estudiante estudiante, double puntaje) {
        int i = 0;
        boolean encontre = false;
        while (i < maxCate && !encontre) {
            int pos = 0;
            while(pos < dimL[i] && canciones[i][pos].getIdentificador()!= id)
                pos++;
            if(pos < dimL[i]){
                encontre = true;
                canciones[i][pos].evaluarEstudiante(estudiante, puntaje);
            }
            i++;
        }
    }
    public Estudiante devolverGanador(int id){
        Estudiante aux = null;
        int i = 0;
        boolean encontre = false;
        while (i < maxCate && !encontre) {
            int j = 0;
            while(j < dimL[i] && canciones[i][j].getIdentificador()!= id)
                j++;
            if(j < dimL[i]){
                encontre = true;
                aux = canciones[i][j].getEstudiante();
            }
            i++;
        }
        return aux;
    }
    public Cancion geMaxPuntaje(int cat){
        Cancion aux = null;
        double max = -1;
        for (int i= 0;i<this.dimL[cat];i++){
            if (max < this.canciones[cat][i].getPuntaje()){
                max = canciones[cat][i].getPuntaje();
                aux = canciones[cat][i];
            }
        }
        return aux;
    }
}
