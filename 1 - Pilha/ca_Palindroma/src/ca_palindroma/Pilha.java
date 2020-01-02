
package ca_palindroma;

public class Pilha {
    public char[] pilha;
    
    public int posicaoPilha; //topo
    
    public Pilha(){
        posicaoPilha = -1;
        pilha = new char[10];
    }
    
    public boolean pilhaVazia(){
        return posicaoPilha == -1;
    }
    
    public int tamanhoPilha(){
        if (pilhaVazia()) {
            System.out.println("Pilha Vazia!");
            return posicaoPilha;
            //return 0;
        }
        return posicaoPilha + 1;
    }
    
    public void push(char c){
        if (posicaoPilha < pilha.length - 1) {
            pilha[++posicaoPilha] = c;
//            posicaoPilha++;
//            pilha[posicaoPilha] = c;
        } else {
            System.out.println("Pilha Cheia!");
        }
    }
    
    public char pop(){
        if (pilhaVazia()) {
            System.out.println("Pilha Vazia!");
            return 0;
        } else {
            return pilha[posicaoPilha--];
        }
    }
    
    public void imprime(){
        int temp = posicaoPilha;
        while (temp >= 0) {
            System.out.println(pilha[temp--]);
        }
        
//        while(!pilhaVazia()){
//            System.out.println(pop());
//        }
//        for (int i = 0; i <= posicaoPilha; i++) {
//            System.out.println(pilha[i]);
//        }
    }
}
