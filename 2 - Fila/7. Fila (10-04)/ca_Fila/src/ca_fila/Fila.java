package ca_fila;

public class Fila {
    private NohFila inicio;
    private NohFila fim;

    public Fila() {
        inicio = null;
        fim = null;
    }
        
//    public Fila(NohFila inicio, NohFila fim) {
//        this.inicio = inicio;
//        this.fim = fim;
//    }

    public boolean filaVazia(){
        return inicio == null && fim == null;
    }
    
    public void insere(int dado){
        NohFila novo = new NohFila(dado);
        if (filaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
    }
    
    public int remove(){
        if (filaVazia()) {
            System.out.println("Fila Vazia!");
            return 0;
        } else {
            int removido = inicio.getDado();
            inicio = inicio.getProximo();
            return removido;
            //System.out.println("Elemento removido: " + removido); //sendo o método void
        }
    }
    
    public void imprime(){
        if (filaVazia()) {
            System.out.println("Fila Vazia!");
        } else {
            NohFila temp = inicio;
            System.out.print("[ ");
            while(temp != null) {
                System.out.print(temp.getDado() + " ");
                temp = temp.getProximo();
            }
            System.out.print("]");
        }
    }
}