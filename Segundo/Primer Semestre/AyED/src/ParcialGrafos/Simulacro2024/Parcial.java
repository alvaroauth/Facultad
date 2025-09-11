package ParcialGrafos.Simulacro2024;

import Practica5.Ejercicio1.*;

import java.util.*;

public class Parcial {

    public List<String> resolver(Graph<Ciudad> mapa, String ciudad, int cantDias) {
        List<String> resul = new LinkedList<>();

        if (mapa != null && !mapa.isEmpty()) {
            Vertex<Ciudad> origen = buscar(mapa, ciudad);

            if (origen != null) {
                boolean[] marcas = new boolean[mapa.getSize()];
                _resolver(mapa, origen, cantDias, resul, new LinkedList<String>(), origen.getData().getDias(), marcas);
            }
        }

        return resul;
    }

    private Vertex<Ciudad> buscar(Graph<Ciudad> ciudades, String origen) {
        Vertex<Ciudad> ver = null;
        Iterator<Vertex<Ciudad>> it = ciudades.getVertices().iterator();

        while(it.hasNext() && ver == null) {
            Vertex<Ciudad> aux = it.next();
            if (aux.getData().getCiudad().equals(origen)) {
                ver = aux;
            }
        }

        return ver;
    }

    private void _resolver(Graph<Ciudad> grafo, Vertex<Ciudad> origen, int cantDias, List<String> resul, List<String> lis, int actDias, boolean[] marcas) {
        lis.add(origen.getData().getCiudad());
        marcas[origen.getPosition()] = true;
        System.out.println(origen.getData().getCiudad()+" "+actDias);
        if (cantDias == actDias && lis.size() > resul.size()) {
            resul.clear();
            resul.addAll(lis);
        }
        else {
            for (Edge<Ciudad> e : grafo.getEdges(origen)) {
                Vertex<Ciudad> v = e.getTarget();
                int j = v.getPosition();
                int diasAux = actDias + v.getData().getDias();
                if (!marcas[j] && diasAux <= cantDias) {
                    _resolver(grafo, v, cantDias, resul, lis, diasAux, marcas);
                }
            }
        }

        lis.removeLast();
        marcas[origen.getPosition()] = false;
    }
}