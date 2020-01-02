/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;


import static Janelas.ClassPrincipal.jPanel1;
import static Janelas.ClassPrincipal.R_repaint;
import java.awt.Color;
import javax.swing.JOptionPane;
import static Janelas.ClassPrincipal.colocarNoOrigem;

/**
 *
 * @author eniojr
 */
public class Dijkstra {
   private Grafo grafo;
   private int   subTop;
   private No    auxi=null;
   private int   auxAcumulado; // e um acumulador auxiliar
   private int   subAcomulado;
   private No    no[]; 
   private int   top;
   private int   permanente;     
   private int   noFinal; 
   
   
    public Dijkstra (Grafo graf, int top,int permanente, int noFinal){
        this.grafo = graf;        
        this.top = top;
        this.no= new No[top]; 
        this.permanente = permanente;
        this.noFinal = noFinal;
        
    }

    public int getAcumulado(){
        return no[noFinal].getAcumulado(); 
    }
        
    public void dijkstra(){ 
         for (int i = 0; i < top; i++)  // cria um vetor no de tamanho do top que tem o número do nó pintado
                    no[i]= new No(); 
         
        if(permanente != noFinal){
             jPanel1.paint(jPanel1.getGraphics());
             R_repaint(top, grafo);   
             Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(permanente), grafo.getCordeY(permanente), null,Color.GREEN); // pinta de cor verde os nos
            
        
            no[permanente].setVisitado(true);        
            no[permanente].setNombre(permanente);       
            
            do{            
              subAcomulado=0;
              auxAcumulado = 2000000000; // iguala isso a figura e que os nós dos nós, supostamente, nunca serão maiores
              no[permanente].setEtiqueta(true); 
              for (int j = 0; j < top; j++) {
                  if(grafo.getmAdjacencia(j, permanente)==1){
                        subAcomulado= no[permanente].getAcumulado()+grafo.getmCoeficiente(j, permanente);                                 
                        if(subAcomulado <= no[j].getAcumulado() && no[j].isVisitado()==true && no[j].isEtiqueta()== false){
                            no[j].setAcumulado(subAcomulado);
                            no[j].setVisitado(true);
                            no[j].setNombre(j);
                            no[j].setPredecesor(no[permanente]);
                        }
                        else if( no[j].isVisitado()==false){
                            no[j].setAcumulado(subAcomulado);
                            no[j].setVisitado(true);
                            no[j].setNombre(j);
                            no[j].setPredecesor(no[permanente]); 
                       }
                 }
              }
              for (int i = 0; i <top; i++) { // olha para qual dos nós visitados tem o menor par de acumulado para escolhe-lo como permanente
                if(no[i].isVisitado()== true && no[i].isEtiqueta()== false){
                   if(no[i].getAcumulado()<=auxAcumulado){
                       permanente= no[i].getNombre();
                       auxAcumulado= no[i].getAcumulado();
                   }
                }               
             }
            subTop++;                
          }while(subTop<top+1);          
          auxi= no[noFinal]; 
           if(auxi.getPredecesor() == null )
             JOptionPane.showMessageDialog(null,"No se Pudo LLegar Al Nodo "+noFinal);          
          while(auxi.getPredecesor() != null){           
              Pintar.pintarCamino(jPanel1.getGraphics(), grafo.getCordeX(auxi.getNombre()), grafo.getCordeY(auxi.getNombre()), grafo.getCordeX(auxi.getPredecesor().getNombre()), grafo.getCordeY(auxi.getPredecesor().getNombre()),Color.GREEN);
              Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(auxi.getNombre()), grafo.getCordeY(auxi.getNombre()), null,Color.GREEN);
             auxi=auxi.getPredecesor();              
          }  
         Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(noFinal), grafo.getCordeY(noFinal), null,Color.GREEN);     
       }
       else Pintar.clickSobreNodo(jPanel1.getGraphics(), grafo.getCordeX(noFinal), grafo.getCordeY(noFinal), null,Color.GREEN);    
    }
    
    
 
}
