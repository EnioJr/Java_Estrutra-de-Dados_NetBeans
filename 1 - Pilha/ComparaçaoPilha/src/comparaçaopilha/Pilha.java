package comparaçaopilha;

import java.util.Arrays;


public class Pilha<TAD> extends Object{
    
    public TAD[] pilha;
    public int topo;
    
    public Pilha(int tam){
        topo =-1;
        pilha = (TAD[]) new Object[tam];
}    
    public boolean pilhaVazia(){
        return topo == -1;
    }    
    public void push(TAD valor){
        if (topo == pilha.length) {
            System.out.println("Pilha cheia!");
        }
       pilha[++topo] = valor;
        
    }
    
    public TAD pop(){
        if (pilhaVazia()) {
            System.out.println("Pilha Vazia!");
            return null;
        } else{
            return pilha[topo--];
        }
    }
    
    public void imprime(){
        if (pilhaVazia()) {
            System.out.println("Pilha Vazia!");
        } else{
        for (int i = topo; i >= 0; i--) {
            System.out.println(pilha[i]);
        }
    }
}

    void imprime(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
