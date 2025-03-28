package Practica1.Ejercicio3;
/*

3. Creación de instancias mediante el uso del operador new
a. Cree una clase llamada Estudiante con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● comision
● email
● direccion
b. Cree una clase llamada Profesor con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● email
● catedra
● facultad
c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la
clase Profesor, que retorne un String con los datos de los atributos de las mismas.
Para acceder a los valores de los atributos utilice los getters previamente
definidos.
d. Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los
respectivos métodos setters.
e. Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la
línea donde itera sobre los profesores
f. Ejecute la clase Test en modo debug y avance paso a paso visualizando si el
estudiante o el profesor recuperado es lo esperado.

*/
public class Ejercicio3 {
	public static void main(String[] args) {
		Estudiante[] arregloE = new Estudiante[2];
        Profesor[] arregloP = new Profesor[3];
        arregloE[0] = new Estudiante("Cristian","Medina","cristianxeneize12@gmail.com","m34","3 y 33 n1067");
        arregloE[1] = new Estudiante("Miguel Angel","Borja","mborjamillonario912@gmail.com","m2","6 y 70 n 7890");
        arregloP[0] = new Profesor("Julian","Alvarez","juliancityatletico@gmail.com","m7","bilbao y callao");
        arregloP[1] = new Profesor("Leandro","Paredes","leoparedesazulyoro@gmail.com","m12","Spezia y fiorentina");
        arregloP[2] = new Profesor("Emiliano","Martinez","dibumartienzreydecopas@gmail.com","m55","aston villa");
        for(int i=0; i<2; i++) {
            System.out.println(arregloE[i].tusDatos());
        }
        for(int i=0; i<3; i++) {
            System.out.println(arregloP[i].tusDatos());
        }
	}
}
