
package Parciales;
public class Parcial_06 {
    /* Una escuela de canto quiere organizar un concurso entre sus estudiantes y necesita un sistema que le permita administrar las canciones a intrepretar, organizadas por categorias; ademas de conocer a los estudiantes que participan en el concurso
       De las canciones se desea conocer su nombre, su compositor, su identificador (numero unico para cada cancion), el estudiante que hizo la mejor interpretacion de la cancion (el "ganador" de la cancion) y el puntaje otorgado por los profesores
       De los estudiantes se conoce nombre, apellido y dni
        
       El concurso de canto deberia crearse conociendo la cantidad maxima de categorias y la cantidad maxima de canciones por categoria ( la misma para todas las categorias ). Las canciones deberian crearse con su identificador unico, nombre, compositor y con el puntaje en 0. Los estudiantes deberan crearse con todos sus atributos
    
       a) agregar una nueva cancion al concurso en una determinada categoria ( suponga que en dicha categoria hay lugar para la cancion)
    
       b) interpretar una cancion. Se recibe el identificador de la cancion (que seguro existe), el estudiante que hace la interpretacion y el puntaje otorgado por los profesores. Si el puntaje otorgado es mas grande que el puntaje actual de la cancion, se actualiza el puntaje y el estudiante ganador para la cancion
    
       c) Conocer el estudiante ganador de una cancion, dado el identificador de la cancion (que seguro existe) devuelve el estudiante que haya obtenido el puntaje mas alto, o null si ningun estudiante interpreto la cancion
    
       d) Conocer la cancion con el puntaje mas grande en una determinada categoria
    
    Implemente en un programa principal que realice lo siguiente
        
       a) cree un concurso de tres categorias y 5 canciones como maximo para cada categoria
    
       b) agregue 5 canciones nuevas
    
       c) Vaya leyendo te teclado nombre apellido y dni del estudiante, junto con el identificador de la cancion y puntaje otorgado, hasta ingresar un identificador igual a cero. "Simule" las interpretaciones de las canciones por los estudiantes por los estudiantes invocando al metodo correspondiente 
    
       d) Lea un identificador de cancion de cancion por teclado ( que seguro existe) e informe nombre apellido y dni del estudiante ganador. OJO que la canciion puede no haber sido interpretada por naide, en cuyo caso deberia informar "Nadie"
    
       e) El nombre y compositor de la cancion mejor interpretada para cada una de las cinco categorias
    */
}
