package ParcialesArboles.Parcial16;

import Practica3.Ejercicio1.GeneralTree;

public class prueba {
	public static void main(String[] args) {
        GeneralTree<Integer> tree = new GeneralTree<>(20);
        tree.addChild(new GeneralTree<>(1));
        tree.addChild(new GeneralTree<>(45));
        tree.addChild(new GeneralTree<>(21));
        tree.getChildren().getFirst().addChild(new GeneralTree<>(6));
        tree.getChildren().getFirst().addChild(new GeneralTree<>(0));
        tree.getChildren().get(1).addChild(new GeneralTree<>(8));
        tree.getChildren().get(2).addChild(new GeneralTree<>(10));
        tree.getChildren().get(2).getChildren().getFirst().addChild(new GeneralTree<>(22));
        tree.getChildren().get(2).getChildren().getFirst().addChild(new GeneralTree<>(2));

        Parcial p = new Parcial();
        
        System.out.println(p.resolver(tree));
    }
}
