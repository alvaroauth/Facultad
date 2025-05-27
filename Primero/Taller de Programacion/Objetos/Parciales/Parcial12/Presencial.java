
package Parciales.Parcial12;

public class Presencial extends Curso {
    private String aula;

    public Presencial(String aula, int año, int max) {
        super(año, max);
        this.setAula(aula);
    }

    public String getAula() {
        return aula;
    }

    private void setAula(String aula) {
        this.aula = aula;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public String cabecera(){
        return " - CURSO PRESENCIAL -"+"\n"+" ---> Aula: "+this.getAula();
    }
    @Override
    public boolean puedeRendir(Alumno alu){
        return alu.getAsistencias() > 2;
    }
    
    
    
}
