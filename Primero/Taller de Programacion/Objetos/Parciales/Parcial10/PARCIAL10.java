
package Parciales.Parcial10;

public class PARCIAL10 {
    public static void main(String[] args) {
        Tradicional tra = new Tradicional("Berisso","Montevideo y 7","Provincia",50,3);
        Digital dig = new Digital("Mercado Pago",100,4,"www.mercadopago.com.ar");
        
        Cuenta c1 = new Cuenta("0110599520000001235579","ALFIL.MARTE.RIMA",46013844,"Dolares");
        Cuenta c2 = new Cuenta("02900001-00000000058382","TACHA.GRANO.MARINO",41987230,"Pesos");
        Cuenta c3 = new Cuenta("07200878-20000001362686","CORONA.OBOE.CARTEL",23456789,"Dolares");
        Cuenta c4 = new Cuenta("0110233740000057889221","LUNA.CIELO.NUBE",30987654,"Pesos");
        Cuenta c5 = new Cuenta("0725020558000056789012","AGUA.MAR.PIEDRA",35123456,"Pesos");
        Cuenta c6 = new Cuenta("0070080150000034556693","VERDE.CASA.ARBOL",27890123,"Pesos");
        Cuenta c7 = new Cuenta("0170345040000077889901","AUTO.CELULAR.CALLE",46013844,"Dolares");
        
        tra.agregarCuentaFinal(c1);
        tra.agregarCuentaFinal(c2);
        tra.agregarCuentaFinal(c3);
        dig.agregarCuentaFinal(c4);
        dig.agregarCuentaFinal(c5);
        dig.agregarCuentaFinal(c6);
        dig.agregarCuentaFinal(c7);
        
        tra.depositarDinero("0110599520000001235579", 501.0);
        tra.depositarDinero("02900001-00000000058382", 500000.0);
        
        dig.depositarDinero("0110233740000057889221", 1000000);
        dig.depositarDinero("0070080150000034556693", 200000);
        dig.depositarDinero("0170345040000077889901", 500);
        
        System.out.println(tra.toString());
        System.out.println(dig.toString());
        
        String cbu1 = "0110599520000001235579";
        if (tra.puedeRecibirTarjeta(cbu1))
            System.out.println("El CBU "+cbu1+" puede recibir una tarjeta");
        else
             System.out.println("El CBU "+cbu1+"  NO   puede recibir una tarjeta");
        
        String cbu2 = "0070080150000034556693";
        if (dig.puedeRecibirTarjeta(cbu2))
            System.out.println("El CBU "+cbu2+" puede recibir una tarjeta");
        else
             System.out.println("El CBU "+cbu2+"  NO   puede recibir una tarjeta");
    }
}
