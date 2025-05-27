
package Parciales.Parcial11;


public class ConsumidorFinal {
    private String cuil;
    private String nombre;

    public ConsumidorFinal(String cuil, String nombre) {
        this.setCuil(cuil);
        this.setNombre(nombre);
    }

    public String getCuil() {
        return cuil;
    }

    private void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        String aux="";
        aux+= " ---> CUIL: "+this.getCuil()+"\n";
        aux+= " ---> Nombre: "+this.getNombre()+"\n";
        return aux;
    }
    
    
}
