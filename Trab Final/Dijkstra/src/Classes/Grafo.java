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
public class Grafo {
   private int mCoeficiente[][] = new int [51][51];
   private int mAdjacencia [][] = new int [51][51];
   private int cordeX [] = new int [51];
   private int cordeY [] = new int [51];
   private int nome [] = new int [51];
   private int noGrafo [];
   
   
   
   public Grafo(){
        
    }

    public int getmCoeficiente(int i, int j ) {
        return mCoeficiente[i][j];
    }

    public int getmAdjacencia(int i,int j) {
        return mAdjacencia[i][j];
    }

    public int getCordeX(int i) {
        return cordeX[i];
    }

    public int getCordeY(int i) {
        return cordeY[i];
    }

    public int getNome(int i) {
        return nome[i];
    }

    public int getEnArbol(int i) {
        return noGrafo[i];
    }

    public void setmCoeficiente(int i,int j ,int mCoeficiente) {
        this.mCoeficiente[i][j] = mCoeficiente;
    }

    public void setmAdjacencia(int i,int j ,int mAdyacencia) {
        this.mAdjacencia[i][j] = mAdyacencia;
    }

    public void setCordeX(int i,int cordeX) {
        this.cordeX[i] = cordeX;
    }

    public void setCordeY(int i, int cordeY) {
        this.cordeY[i] = cordeY;
    }

    public void setNome(int i,int nombre) {
        this.nome[i] = nombre;
    }

    public void setEnArbol(int i,int enArbol) {
        this.noGrafo[i] = enArbol;
    }
    public void crearEnArbol(int i){
       noGrafo = new int [i]; 
    }  
    
}
