/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import static Janelas.ClassPrincipal.R_repaint;
import static Janelas.ClassPrincipal.jPanel1;
import java.awt.Color;
import static Janelas.ClassPrincipal.colocarNoOrigem;

/**
 *
 * @author eniojr
 */
public class Algoritmo_Prim {
    
   private int     acumulado;
   private int     arestaMenor;
   private int     fim;
   private boolean estadoNo=false;
   private boolean aumentaTamanho;
   private int     noApontado;  
   private int     noApontador;
   private int     tamanho;
   private int     arestaMaior;
   private Grafo   grafo;
   private int     top;
   private int     noOrigem;
   
   
   
   public Algoritmo_Prim(Grafo grafo , int top ,int aristaMayor ){
       this.acumulado = 0;
       this.arestaMenor = 0;
       this.fim = 0;
       this.estadoNo=false;
       this.aumentaTamanho = false;
       this.noApontado = 0;  
       this.noApontador = 0;
       this.tamanho = 1;
       this. arestaMaior=aristaMayor;
       this.grafo = grafo;
       this.top = top;
   }

    public int getCumulado() {
        return acumulado;
    }
  
   
  public void prim(){
      this.noOrigem= colocarNoOrigem("Coloque a Origem do Nó..","Origem de Nó não existe",top);
       jPanel1.paint(jPanel1.getGraphics());
       R_repaint(top,grafo);
       grafo.crearEnArbol(top);
       grafo.setEnArbol(0, noOrigem);
       //algoritmo de Prim ---->>
       do{
           this.arestaMenor = this.arestaMaior;
           this.fim=2;
            for (int j = 0; j < tamanho; j++) {
                for (int k = 0; k < top; k++){
                    if(grafo.getmAdjacencia(k, grafo.getEnArbol(j))==1){
                        for (int h = 0; h < tamanho; h++) {
                             if(grafo.getEnArbol(h)==k ){
                                 this.estadoNo=true; 
                                 break;
                             }
                        }
                        if(estadoNo==false){
                            if(grafo.getmCoeficiente(k, grafo.getEnArbol(j))<=arestaMenor && grafo.getmCoeficiente(k, grafo.getEnArbol(j))>0 ){
                                 arestaMenor=grafo.getmCoeficiente(k, grafo.getEnArbol(j));
                                 this.noApontado=k;
                                 this.aumentaTamanho=true;
                                 this.noApontador=grafo.getEnArbol(j);
                                 this.fim=1;
                            }
                        }
                        this.estadoNo=false;
                    }
                }
            }//fim  for (int j = 0; j < tamano; j++)              
         if(aumentaTamanho==true){
                    Pintar.pintarCamino(jPanel1.getGraphics(),grafo.getCordeX(noApontador), grafo.getCordeY(noApontador),grafo.getCordeX(noApontado), grafo.getCordeY(noApontado),Color.red); 
                    Pintar.clickSobreNodo(jPanel1.getGraphics(),grafo.getCordeX(noApontador), grafo.getCordeY(noApontador), null,Color. red);
                    Pintar.clickSobreNodo(jPanel1.getGraphics(),grafo.getCordeX(noApontado), grafo.getCordeY(noApontado), null, Color.red);                                  
                    grafo.setEnArbol(tamanho, noApontado);
                    this.tamanho++;
                    this.aumentaTamanho=false;
                    this.acumulado += this.arestaMenor;
         }
        }while(fim<2);
   }
    
}
