package Practica3.Ejercicio4;

import Practica3.Ejercicio1.*;

public class prueba {

	public static void main(String[] args) {
        AreaEmpresa m = new AreaEmpresa("M", 14);
        AreaEmpresa j = new AreaEmpresa("J", 13);
        AreaEmpresa k = new AreaEmpresa("K", 25);
        AreaEmpresa l = new AreaEmpresa("L", 10);
        AreaEmpresa a = new AreaEmpresa("A", 4);
        AreaEmpresa b = new AreaEmpresa("B", 7);
        AreaEmpresa c = new AreaEmpresa("C", 5);
        AreaEmpresa d = new AreaEmpresa("D", 6);
        AreaEmpresa e = new AreaEmpresa("E", 10);
        AreaEmpresa f = new AreaEmpresa("F", 18);
        AreaEmpresa g = new AreaEmpresa("G", 9);
        AreaEmpresa h = new AreaEmpresa("H", 12);
        AreaEmpresa i = new AreaEmpresa("I", 19);

        GeneralTree<AreaEmpresa> treeM = new GeneralTree<>(m);
        GeneralTree<AreaEmpresa> treeJ = new GeneralTree<>(j);
        GeneralTree<AreaEmpresa> treeK = new GeneralTree<>(k);
        GeneralTree<AreaEmpresa> treeL = new GeneralTree<>(l);
        GeneralTree<AreaEmpresa> treeA = new GeneralTree<>(a);
        GeneralTree<AreaEmpresa> treeB = new GeneralTree<>(b);
        GeneralTree<AreaEmpresa> treeC = new GeneralTree<>(c);
        GeneralTree<AreaEmpresa> treeD = new GeneralTree<>(d);
        GeneralTree<AreaEmpresa> treeE = new GeneralTree<>(e);
        GeneralTree<AreaEmpresa> treeF = new GeneralTree<>(f);
        GeneralTree<AreaEmpresa> treeG = new GeneralTree<>(g);
        GeneralTree<AreaEmpresa> treeH = new GeneralTree<>(h);
        GeneralTree<AreaEmpresa> treeI = new GeneralTree<>(i);

        treeJ.addChild(treeA);
        treeJ.addChild(treeB);
        treeJ.addChild(treeC);
        treeK.addChild(treeD);
        treeK.addChild(treeE);
        treeK.addChild(treeF);
        treeL.addChild(treeG);
        treeL.addChild(treeH);
        treeL.addChild(treeI);

        treeM.addChild(treeJ);
        treeM.addChild(treeK);
        treeM.addChild(treeL);
        
        System.out.println(AnalizadorArbol.devolverMaximoPromedio(treeM));
	}
}
