
package Parciales.Parcial2;


public class Concurso {
    private int [] dimL;
    private Alumno [][] alumnos;
    private int max;
    
    public Concurso (int n){
        int i, j;
        this.max = n;
        this.alumnos = new Alumno [5] [n];
        this.dimL = new int [5];
        for (i=0;i<5;i++){
            for (j=0;j<n;j++){
                this.alumnos[i][j] = new Alumno();
            }
        }
        for (i=0;i<5;i++){
            this.dimL[i] = 0;
        }
    }
    private boolean haylugar(int n){
        if (this.dimL[n] < this.max)
            return true;
        else
            return false;
    }
    public void agregarAlumno(Alumno a, int n){
        if ((n<6)&&(n>0)&&(this.haylugar(n-1))){
            int aux = dimL[n-1];
            this.alumnos[n-1][aux] = a;
            dimL[n-1]++;
        }
    }
    public void agregarPuntaje(String al, double p){
        int i=0, j=0;
        boolean ok = false;
        while ((i<5)&&(!ok)){
            while ((j<dimL[i])&&(!ok)){
                if (alumnos[i][j].getNombre().equals(al)){
                    ok = true;
                    alumnos[i][j].setPuntaje(p);
                    j++;
                }
                j++;
            }
            i++;
            j=0;
        }
    }
    public int getGenMaximo(){
        int maxAux = -10, aux=-1;
        for (int i=0; i<this.max;i++){
            if (this.dimL[i] > maxAux){
                aux = i;
                maxAux = dimL[i];
            }
        }
        return aux+1;
    }
    private String Concatenador(){
        int i, j;
        String aux="";
        for(i=0; i<5; i++){
            for(j=0;j < this.dimL[i]; j++){
                aux = aux  + "Genero: " + (i+1) + this.alumnos[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
@Override   
    public String toString(){
        return this.Concatenador();
    }
}
