
package Parciales;

public class Parcial_11 {
    /* Queremos representar las compras realizadas en un comercio. De cada compra se conoce
        numero, fecha, productos comprados ( a lo sumo N). Asimismo, el comercio le permite
        hacer compras por mayor que tienen los datos del consumidor final (Cuil y nombre). Los
        productos se caracterizan por tener codigo, descripcion precio unitario y cantidad de
        unidades
    
       1- Genere las clases necesarias. Proveo constructores para iniciar los objetos de su 
        modelo a partir de la informacion necesaria. En particular las compras deben iniciar 
        con un numero, una fecha y sin productos ( con capacidad de guardar N productos ) y 
        ademas para las compras por mayor, el consumidor final;
        
       2- Implemente los metodos necesarios, en las clases que corresponda para: 
            
           a- agregar un producto a la compra. Tener en cuenta que las compras al por mayor 
            solo se agrega si supera los 6 productos
    
           b- obtener el precio final de la compra. Tener en cuenta que el precio final es
            la suma de los productos finales de los productos agregados (el precio final de
            un producto es precio_unitario*cantidad_unidades). Las compras al por mayor
            descuentan el 21%
    
           c- Obtener resumen de compra, que concatene: numero, fecha, el codigo, descripcion
            y precio final de cada producto agregado, y precio final de la compra.
    
           d- Saber si la compra es abonable en cuotas. Esto es posible cuando su precio
            final supera los $100.000
    
       3- Realice un programa que instancie una compra y una compra al por mayor, con los
        datos necesarios y para un maximo de 10 productos. Cargue algunos productos a la 
        compra. Al finalizar, muestre el resumen de cada comprae imprima si son abonables 
        en cuotas.
    */
}
