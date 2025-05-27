
package Parciales.Parcial9;

public class Estacionamiento {
    private String direccion;
    private double costoHora;
    private Vehiculo [] [] vehiculos;
    private int cantSectores;
    private int cantVehiculos;
    private double [] recaudacion;

    public Estacionamiento(String direccion, double costoHora, int s, int v) {
        this.direccion = direccion;
        this.costoHora = costoHora;
        this.cantSectores = s;
        this.cantVehiculos = v;
        this.vehiculos = new Vehiculo[s][v];
        this.recaudacion = new double [this.getCantSectores()];
        int i,j;
        for (i=0;i<this.cantSectores;i++){
            for (j=0;j<this.cantVehiculos;j++){
                this.vehiculos[i][j] = null;
            }
        }
        for (i=0;i<this.getCantSectores();i++)
            this.recaudacion[i] = 0;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public int getCantSectores() {
        return cantSectores;
    }

    public int getCantVehiculos() {
        return cantVehiculos;
    }
    
    public void agregarVehiculo (Vehiculo vehi, int s, int v){
        this.vehiculos[s-1][v-1] = vehi;
        this.recaudacion[s-1] += (vehi.getHoras()*this.getCostoHora());
    }
    
    public String eliminarModelo(String m, int x){
        x--;
        String aux = " - AUTOS ELIMINADOS -"+"\n";
        boolean pri = false;
        for (int i=0;i<this.getCantVehiculos();i++){
            if(this.vehiculos[x][i] != null){
                if (m.equals(this.vehiculos[x][i].getMarca())){
                    if (!pri)
                        pri = true;
                    aux += "Posicion: ("+(x+1)+","+(i+1)+")   Eliminado: "+ vehiculos[x][i].toString()+"\n";
                    this.vehiculos[x][i] = null;
                    
                }
            }
        }
        if (!pri)
            return aux += "No se eliminaron autos"+"\n";
        else
            return aux;
    }
    
    public int masRecaudo(){
        int i,aux = -1 ;
        double max =-1;
        for (i = 0; i<this.getCantSectores();i++){
            if (this.recaudacion[i]>max){
                max = this.recaudacion[i];
                aux = i;
            }
        }
        return aux;
    }
    @Override
    public String toString(){
        String aux = "";
        int i,j;
        for(i=0;i<this.getCantSectores();i++){
            aux += " - SECTOR "+(i+1)+" -"+"\n";
            for(j=0;j<this.getCantVehiculos();j++){
                aux += "Posicion "+(j+1)+": ";
                if (this.vehiculos[i][j] == null)
                    aux += "Vacio."+"\n";
                else
                    aux += this.vehiculos[i][j].toString()+"\n";
            }
            aux +="\n";
        }
        return aux;
    }
    
    
    
}
