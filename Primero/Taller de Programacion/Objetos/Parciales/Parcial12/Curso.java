
package Parciales.Parcial12;

public abstract class Curso {
    private int año;
    private Alumno [] alumnos;
    private int dimL;
    private int max;

    public Curso(int año, int max) {
        this.setAño(año);
        this.setMax(max);
        this.setDimL(0);
        this.alumnos = new Alumno[max];
        
    }

    public int getAño() {
        return año;
    }

    private void setAño(int año) {
        this.año = año;
    }

    public int getDimL() {
        return dimL;
    }

    private void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public int getMax() {
        return max;
    }

    private void setMax(int max) {
        this.max = max;
    }
    private String concatenar(){
        String aux = "";
        for (int i=0;i<this.getDimL();i++){
            aux += alumnos[i].toString()+"\n";
        }
        return aux;
    }
    public boolean agregarAlumno(Alumno a){
        if (this.dimL < this.max){
            this.alumnos[dimL++] = a;
            return true;
        }
        else
            return false;
    }
    
    private int buscarAlumno(int dni){
        int i=0;
        boolean encontro = false;
        int aux = -1;
        while (i<this.getDimL() && !encontro){
            if (this.alumnos[i].getDni()==dni)
                encontro = true;
            if (!encontro)
                i++;
        }
        if (this.getMax() != i)
            aux = i;
        return aux;
    }
    public void aumAsistencia(int dni){
        int alu = buscarAlumno(dni);
        if (alu != -1)
            this.alumnos[alu].aumAsistencias();
            
        
    }
    
    public void aumAutoevaluacion(int dni){
        int alu = buscarAlumno(dni);
        if (alu != -1)
            this.alumnos[alu].aumAutoevaluaciones();
    }
    
    public int cantidadDeAlumnosQuePuedenRendir(){
        int aux =0;
        for (int i=0;i<this.getDimL();i++){
            if (this.puedeRendir(this.alumnos[i]))
                aux++;
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String aux="";
        aux += this.cabecera()+"\n";
        aux += " - - - Lista de alumnos en el curso: "+"\n";
        aux += this.concatenar()+"\n";
        aux += " - - - Cantidad de alumnos en condiciones de rendir: "+this.cantidadDeAlumnosQuePuedenRendir()+"\n";
        return aux;
        
    }
    public abstract String cabecera();
    public abstract boolean puedeRendir(Alumno alu);
    
    
    
}
