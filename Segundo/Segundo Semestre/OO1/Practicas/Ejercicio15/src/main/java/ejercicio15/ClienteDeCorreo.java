package ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {

    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo(){
        inbox = new Carpeta("inbox");
        carpetas = new ArrayList<>();
    }

    public void recibir(Email e){
        this.inbox.agregarEmail(e);
    }

    public int espacioOcupadp(){
        return (inbox.calcularTamanio() + carpetas.stream().mapToInt(c -> c.calcularTamanio()).sum());
    }

    public Email buscar(String text){
        Email e = inbox.buscarTexto(text);
        if (e != null)
            return e;
        return carpetas.stream().map(c -> c.buscarTexto(text))
                .filter(em -> em != null)
                .findFirst()
                .orElse(null);
    }

    public void agregarCarpeta(Carpeta c){
        this.carpetas.add(c);
    }
}
