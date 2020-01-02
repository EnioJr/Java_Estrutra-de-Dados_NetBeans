package teste;

public class lista {

    private NohLista inicio;
    private NohLista fim;
    private int qtdeElementos;

    public lista() {
        inicio = fim = null;
        qtdeElementos = 0;
    }

    public boolean listaVazia() {
        return inicio == null;
    }

    public void insereInicio(int e) {
        NohLista novo = new NohLista(e);
        if (listaVazia()) {
            inicio = fim = null;
        } else {
            inicio.setAnterior(novo);
            novo.setProximo(inicio);
            inicio = novo;
        }
        qtdeElementos++;
    }

    public void insereFim(int e) {
        NohLista novo = new NohLista(e);
        if (listaVazia()) {
            inicio = fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
        qtdeElementos++;
    }

    public void imprimiDireita() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
        } else {
            NohLista corrente = inicio;
            while (corrente != null) {
                System.out.print(corrente.getDado() + " ");
                corrente = corrente.getProximo();
            }
        }
        System.out.println();
    }

    public void imprimiEsquerda() {
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
        } else {
            NohLista corrente = fim;
            while (corrente != null) {
                System.out.print(corrente.getDado() + " ");
                corrente = corrente.getAnterior();
            }
        }
        System.out.println();
    }

    public int getQtdeElementos() {
        System.out.println("A lista tem " + qtdeElementos + " Elementos");
        return qtdeElementos;
    }
}
