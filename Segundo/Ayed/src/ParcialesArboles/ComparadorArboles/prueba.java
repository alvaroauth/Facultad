package ParcialesArboles.ComparadorArboles;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
		GeneralTree<Integer> arbol1 = new GeneralTree<>(10);
        arbol1.addChild(new GeneralTree<>(4));
        arbol1.addChild(new GeneralTree<>(3));
        arbol1.addChild(new GeneralTree<>(2));
        arbol1.getChildren().getFirst().addChild(new GeneralTree<>(1));

        GeneralTree<Integer> arbol2 = new GeneralTree<>(15);
        arbol2.addChild(new GeneralTree<>(8));
        arbol2.addChild(new GeneralTree<>(5));
        arbol2.getChildren().getFirst().addChild(new GeneralTree<>(2));
        arbol2.getChildren().getFirst().addChild(new GeneralTree<>(-2));
        arbol2.getChildren().getFirst().addChild(new GeneralTree<>(6));
        arbol2.getChildren().get(1).addChild(new GeneralTree<>(7));

        System.out.println(ComapradorDeArbolesGenerales.esInferiorProfundo(arbol1, arbol2));
	}
}
