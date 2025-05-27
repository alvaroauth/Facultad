
package Parciales.Parcial13;

public class Agenda {
    private int turnos;
    private int dias;
    private Paciente [][] pacientes;

    public Agenda(int dias,int turnos ) {
        this.setTurnos(turnos);
        this.setDias(dias);
        this.pacientes = new Paciente [dias][turnos];
        int i,j;
        for(i=0;i<this.getDias();i++){
            for(j=0;j<this.getTurnos();j++)
                this.pacientes[i][j] = null;
        }
    }

    public int getTurnos() {
        return turnos;
    }

    private void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public int getDias() {
        return dias;
    }

    private void setDias(int dias) {
        this.dias = dias;
    }
    public void agregarPaciente(Paciente p, int d, int t){
        d--;
        t--;
        this.pacientes[d][t] = p;
    }
    
    public void eliminarPaciente(String nom){
        int i,j;
        for(i=0;i<this.getDias();i++){
            for(j=0;j<this.getTurnos();j++){
                if (this.pacientes[i][j] != null){
                    if ( nom.equals(this.pacientes[i][j].getNombre()))
                        this.pacientes[i][j] = null;
                }
            }
        }
    }
    
    public boolean pacienteAgendado(int d, String nom){
        boolean tiene = false;
        int i=0;
        d--;
        while (i<this.getTurnos() && !tiene){
            if (this.pacientes[d][i] != null){
                if(this.pacientes[d][i].getNombre().equals(nom))
                    tiene = true;
            }
            i++;
        }
        return tiene;
    }
    
    private String concatenarTurnos(int x){
        String aux= "";
        for (int i=0;i<this.getTurnos();i++){
            aux += " --> Turno "+(i+1)+": ";
            if (this.pacientes[x][i] != null)
                aux += pacientes[x][i].toString()+"\n";
            else
                aux +="Vacio."+"\n";
        }
        return aux;
    }
    private String concatenarDias(){
        String aux="";
        for (int i =0;i<this.getDias();i++){
            aux+= " - - - Dia "+(i+1)+" - - -"+"\n";
            aux += this.concatenarTurnos(i);
            aux += "\n";
        }
        return aux;
    }
    @Override
    public String toString(){
        return this.concatenarDias();
    }
    
    
}
