
package Parciales.Parcial12;

public class Virtual extends Curso {
    private String url;

    public Virtual(String url, int año, int max) {
        super(año, max);
        this.setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public String cabecera(){
        return " - CURSO VIRTUAL -"+"\n"+" ---> URL: "+this.getUrl();
    }
    @Override
    public boolean puedeRendir(Alumno alu){
        return (alu.getAsistencias()) > 0 && (alu.getAutoevaluaciones() > 2);
    }
}
