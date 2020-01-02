
package listade_josephus;

public class NohLista <T> extends Object{
    private NohLista anterior;
    private T dado;
    private NohLista proximo;
    
//    public NohLista(){
//        anterior = null;
//        dado = 0;
//        proximo = null;
//    }
    
    public NohLista(T dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
    
//    public NohLista(int dado, NohLista proximo, NohLista anterior){
//        this.dado = dado;
//        this.anterior = anterior;
//        this.proximo = proximo;
//    }

    public NohLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NohLista anterior) {
        this.anterior = anterior;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NohLista getProximo() {
        return proximo;
    }

    public void setProximo(NohLista proximo) {
        this.proximo = proximo;
    }
    
}
