package projeto4;

public class NohLista <T> extends Object{

    private NohLista anterior;
    private T dado;
    private NohLista proximo;

    public NohLista(T dado) {
        this.dado = dado;
        anterior = null;
        proximo = null;
    }

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
