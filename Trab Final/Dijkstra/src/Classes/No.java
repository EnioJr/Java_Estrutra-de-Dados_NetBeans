/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author eniojr
 */
public class No {    
   private  int nome ;
   private boolean visitado ;
   private boolean etiqueta;
   private int acumulado; // carrega o acúmulo de cada nó
   private No Predecesor;
   
   public No(){
       this.nome =-1;
       this.visitado = false;
       this.etiqueta = false;
       this.Predecesor  = null;
       this.acumulado =0;       

   }

     public int getNombre() {
        return nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public boolean isEtiqueta() {
        return etiqueta;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public No getPredecesor() {
        return Predecesor;
    }

    public void setNombre(int nombre) {
        this.nome = nombre;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void setEtiqueta(boolean etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setAcumulado(int acomulado) {
        this.acumulado = acomulado;
    }

    public void setPredecesor(No Predecesor) {
        this.Predecesor = Predecesor;
    }

    
}
