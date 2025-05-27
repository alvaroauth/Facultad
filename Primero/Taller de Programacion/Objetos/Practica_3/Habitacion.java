/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_3;

import PaqueteLectura.GeneradorAleatorio;
public class Habitacion {
    private Cliente cliente;
    private boolean ocupada;
    private double precio;
    
    public Habitacion(){
        this.cliente = null;
        this.ocupada = false;
        this.precio = GeneradorAleatorio.generarDouble(6001)+2000;
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public double getPrecio() {
        return precio;
    }

    public void aumentarPrecio(double precio) {
        this.precio += precio;
    }
    
    public void ocupar(Cliente c){
        this.cliente = c;
        this.ocupada = true;
    }

    @Override
    public String toString(){
        String aux = "Precio= " + this.precio +" , Ocupada= " + this.ocupada+" }" ; 
        if (ocupada)
            aux += " Cliente= "+this.cliente.toString();
        return aux;
    }
    
    
}
