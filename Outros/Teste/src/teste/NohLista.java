package teste;

public class NohLista {

    private NohLista anterior;
    private NohLista proximo;
    private int dado;

    public NohLista(int dado) {
        this.dado = dado;
        anterior = proximo = null;
    }

    public NohLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NohLista anterior) {
        this.anterior = anterior;
    }

    public NohLista getProximo() {
        return proximo;
    }

    public void setProximo(NohLista proximo) {
        this.proximo = proximo;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

}
