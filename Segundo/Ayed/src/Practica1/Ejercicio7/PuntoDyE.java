package Practica1.Ejercicio7;

import java.util.*;
import java.util.stream.Collectors;

public class PuntoDyE {
	Estudiante E1 = new Estudiante("Alejandro","Magno","elconquistador123@gmail.com","mace356","Macedonia, Castillo");
	Estudiante E2 = new Estudiante("Napoleon","Bonaparte","Nap1815waterloo@gmail.com","st1800","Santa Elena");
	Estudiante E3 = new Estudiante("Gengis","Kan","gengiskanladinastia@gmail.com","im1200","Imperio mongol");
	Estudiante[] array = {E1,E2,E3};
	
	public static List<Estudiante> tresEstudiantes(Estudiante[] e){
		//1
		List<Estudiante> ListEst = new ArrayList<>();
		for(int i=0;i<3;i++) {
			ListEst.add(e[i]);
		}
		
		//2
		List<Estudiante> ListEstCopia = new ArrayList<>(ListEst);
		
		// 3
		for(Estudiante E: ListEst)
            System.out.println(E.toString());
        for(Estudiante E: ListEstCopia)
            System.out.println(E.toString());
        
		//4
        ListEst.get(0).actualizarEmail("Bucefaloiliada@gmail.com");
        
		//5
        for(Estudiante E: ListEst)
            System.out.println(E.toString());
        for(Estudiante E: ListEstCopia)
            System.out.println(E.toString());
        
        //6
        List<Estudiante> ListAddAll = new ArrayList<>();
        ListAddAll.addAll(ListEst);
        
        List<Estudiante> ListCopyOf = List.copyOf(ListEst);
        
        ArrayList<Estudiante> ListClone = (ArrayList<Estudiante>) ((ArrayList<Estudiante>)ListEst).clone();
        
        List<Estudiante> copiaProfunda = ListEst.stream().map((Estudiante -> new Estudiante(Estudiante.getNombre(), Estudiante.getApellido(), Estudiante.getEmail(), Estudiante.getComision(), Estudiante.getDireccion()).collect(Collectors.toList()));
            
        
		return ListEst;
	}
}
