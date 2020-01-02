package ca_filacircular;

public class NohFila {

    private int dado;
    private NohFila proximo;

    public NohFila() {
        dado = 0;
        this.proximo = null;
    }

    public NohFila(int dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public NohFila getProximo() {
        return proximo;
    }

    public void setProximo(NohFila proximo) {
        this.proximo = proximo;
    }

}
