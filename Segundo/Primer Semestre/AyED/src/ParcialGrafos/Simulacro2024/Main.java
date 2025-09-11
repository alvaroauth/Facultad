package ParcialGrafos.Simulacro2024;

import Practica5.Ejercicio1.*;
import Practica5.Ejercicio1.adjList.AdjListGraph;

public class Main {
    public static void main(String[] args) {
        Graph<Ciudad> mapa = new AdjListGraph<>(); // Suponiendo que tenés una implementación concreta llamada MiGrafo

        Vertex<Ciudad> marDelPlata = mapa.createVertex(new Ciudad("Mar del Plata", 7));
        Vertex<Ciudad> pilar = mapa.createVertex(new Ciudad("Pilar", 1));
        Vertex<Ciudad> dolores = mapa.createVertex(new Ciudad("Dolores", 1));
        Vertex<Ciudad> chascomus = mapa.createVertex(new Ciudad("Chascomús", 1));
        Vertex<Ciudad> laPlata = mapa.createVertex(new Ciudad("La Plata", 5));
        Vertex<Ciudad> hudson = mapa.createVertex(new Ciudad("Hudson", 1));
        Vertex<Ciudad> madariaga = mapa.createVertex(new Ciudad("Madariaga", 1));
        Vertex<Ciudad> pinamar = mapa.createVertex(new Ciudad("Pinamar", 4));
        Vertex<Ciudad> marAzul = mapa.createVertex(new Ciudad("Mar Azul", 3));
        Vertex<Ciudad> lasGaviotas = mapa.createVertex(new Ciudad("Las Gaviotas", 1));
        Vertex<Ciudad> querandi = mapa.createVertex(new Ciudad("Querandí", 1));

        // Conexiones (basadas en las líneas negras del grafo)
        // Mar del Plata ↔ Pilar
        mapa.connect(marDelPlata, pilar);
        mapa.connect(pilar, marDelPlata);

// Pilar ↔ Dolores
        mapa.connect(pilar, dolores);
        mapa.connect(dolores, pilar);

// Dolores ↔ Chascomús
        mapa.connect(dolores, chascomus);
        mapa.connect(chascomus, dolores);

// Chascomús ↔ La Plata
        mapa.connect(chascomus, laPlata);
        mapa.connect(laPlata, chascomus);

// La Plata ↔ Hudson
        mapa.connect(laPlata, hudson);
        mapa.connect(hudson, laPlata);

        // La Plata ↔ Hudson
        mapa.connect(laPlata, madariaga);
        mapa.connect(madariaga, laPlata);

// Dolores ↔ Madariaga
        mapa.connect(dolores, madariaga);
        mapa.connect(madariaga, dolores);

// Madariaga ↔ Pinamar
        mapa.connect(madariaga, pinamar);
        mapa.connect(pinamar, madariaga);

// Pinamar ↔ Mar Azul
        mapa.connect(pinamar, marAzul);
        mapa.connect(marAzul, pinamar);

// Mar Azul ↔ Mar del Plata
        mapa.connect(marAzul, marDelPlata);
        mapa.connect(marDelPlata, marAzul);

// Mar Azul ↔ Las Gaviotas
        mapa.connect(marAzul, lasGaviotas);
        mapa.connect(lasGaviotas, marAzul);

// Mar Azul ↔ Querandí
        mapa.connect(marAzul, querandi);
        mapa.connect(querandi, marAzul);


        System.out.println(new Parcial().resolver(mapa, "Mar del Plata", 20));
    }
}
