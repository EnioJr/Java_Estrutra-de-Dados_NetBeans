package ca_fila;

public class Fila {
    private NohFila inicio;
    private NohFila fim;
    
    public Fila(){
        inicio = null;
        fim = null;
    }
    
    public boolean filaVazia(){
        return inicio == null & fim == null;
    }
    
    public void insere(int dado){
        NohFila novoNo = new NohFila(dado);
        if (filaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        }else{
            fim.setProximo(novoNo);                     // seta a proxima posiçao
            fim = novoNo;                               // coloca o valor na posiçao nova. que seria essa proxima.
        }
    }    
    
    public void remove(){
        if (filaVazia()) {
            System.out.println("Fila Vazia!");
           // return -1;
        }else{
            int removido = inicio.getDado();
            inicio = inicio.getProximo();
            //return  removido; 
            System.out.println("Elmento removido: " + removido);
        }               
    }
    
    public void imprime(){
        if (filaVazia()) {
            System.out.println("Pilha Vazia!");
        }else{
            NohFila temp = inicio;
            while (temp != null) {                
                System.out.println(temp.getDado());
                temp = temp.getProximo();
            }
        }
    }
    
    
}
