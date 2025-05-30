package Parciales.Parcial1;

public class Alumno {
    private int dni;
    private String nombre;
    private Materias [] aprobadas;
    private int cantAprobadas;
    private int cantMax;

    
    public int getCantAprobadas() {
        return cantAprobadas;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public Alumno(int dni, String nom, int max){
        this.dni = dni;
        this.nombre = nom;
        this.cantAprobadas = 0;
        this.cantMax = max;
        this.aprobadas = new Materias [cantMax];
    }
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    private Materias[] getAprobadas() {
        return aprobadas;
    }
    
    public boolean hayEspacio(){
        return this.cantMax != this.cantAprobadas;
    }
    
    public void agregarMateria(Materias mat){
        if(this.hayEspacio()){
            this.aprobadas[this.cantAprobadas++] = mat;
        }
    }
    
    public boolean esGraduado(){
        int aux = 0;
        String auxstr = "Tesis";
        if(this.cantAprobadas == this.cantMax){
            while((aux < this.cantAprobadas)&&(!this.aprobadas[aux].getNombre().equals(auxstr))){
                aux++;
            }
        }
        return !(aux == this.cantAprobadas);
    }
    
    private String Concatenador(){
        int i;
        String aux="";
        for(i=0;i<this.getCantAprobadas();i++){
            aux = aux + " " + this.aprobadas[i].toString();
        }
        return aux;
    }
    
@Override   
    public String toString(){
        String aux = "DNI: " + this.getDni()+ " | " + " Nombre: " + this.getNombre()+ " | " + "\n" +" Materias Aprobadas: " + "\n" + this.Concatenador()+ " | " +  "Es Gradruado:  " +this.esGraduado()  + "\n";
        return aux;
    }
}