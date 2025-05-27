
package Practica_3;

public class Estanteria {
    private int cantLibros;
    private int maximo = 20;
    private Libro [] Libros;
    
    public Estanteria (){
        this.cantLibros = 0;
        this.Libros = new Libro [this.maximo];
    }
    public boolean hayLugar(){
        return this.cantLibros < this.maximo;
    }
    
    public int getLibros(){
        return cantLibros;
    }
    
    public boolean agregarLibro (Libro lib){
        if (this.hayLugar()){
            this.Libros[this.cantLibros] = lib;
            this.cantLibros++;
            return true;
        }
        else
            return false;
    }
    public Libro devolverLibro(String titulo){
        int i= 0;
        boolean ok = false;
        while ((i<this.cantLibros)&&(!ok)){
            i++;
            if (titulo.equals(this.Libros[i].getTitulo())){
                ok = true;}
        }
        if (ok){
            return this.Libros[i];
        }
        else{
            return null;
        }
    }
}
