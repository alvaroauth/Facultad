
package Parciales.Parcial14;

import PaqueteLectura.GeneradorAleatorio;

public class Parcial {
    private Alumno [] [] alumnos;
    private int [] dimL;
    private int maxSalas;
    private int maxAlumnos;
    
    public Parcial (int n, int m){
        this.setMaxSalas(n);
        this.setMaxAlumnos(m);
        this.alumnos = new Alumno [n][m];
        this.dimL = new int [n];
        int i, j;
        for (i=0;i<this.getMaxSalas();i++)
            this.dimL[i] = 0;
        for (i=0;i<this.getMaxSalas();i++){
            for (j=0;j<this.getMaxAlumnos();j++){
                this.alumnos[i][j] = new Alumno("Vacio.", 0);
            }
        }
    }

    private void setMaxSalas(int maxSalas) {
        this.maxSalas = maxSalas;
    }

    private void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getMaxSalas() {
        return maxSalas;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }
    public void agregarAlumno(Alumno alu,int x){
        x--;
        this.alumnos[x][this.dimL[x]++] = alu;
    }
    public void agregarTemas(){
        GeneradorAleatorio.iniciar();
        int i,j;
        for (i=0;i<this.getMaxSalas();i++){
            for (j=0;j<this.getMaxAlumnos();j++){
                this.alumnos[i][j].setTema(GeneradorAleatorio.generarInt(this.getMaxAlumnos())+1);
            }
        }
    }
    
    public String alumnosTema(int t){
        String aux=" - - - TEMA "+t+" - - -"+"\n";
        int i,j;
        for (i=0;i<this.getMaxSalas();i++){
            for (j=0;j<this.dimL[i];j++){
                    if (this.alumnos[i][j].getTema() == t)
                        aux += this.alumnos[i][j].toString()+"\n";
            }
        }
        return aux;
    }
    @Override
    public String toString(){
        String aux="";
        int i,j;
        for (i=0;i<this.getMaxSalas();i++){
            aux += " - - - Sala "+(i+1)+" - - -"+"\n";
            for (j=0;j<this.dimL[i];j++){
                aux += "   ---> Alumno "+(j+1)+": "+this.alumnos[i][j].toString()+"\n";
            }
        }
        return aux;
    }
    }
    
    

