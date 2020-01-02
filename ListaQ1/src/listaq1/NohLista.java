
package listaq1;

public class NohLista {
    private NohLista anterior;
    private int dado;
    private NohLista proximo;    
    
    public NohLista(int dado){
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
    
    public NohLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NohLista anterior) {
        this.anterior = anterior;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public NohLista getProximo() {
        return proximo;
    }

    public void setProximo(NohLista proximo) {
        this.proximo = proximo;
    }
    
}
