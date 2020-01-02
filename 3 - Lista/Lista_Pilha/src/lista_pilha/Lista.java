package lista_pilha;

public class Lista {

    private NohLista inicio;
    private NohLista fim;
    private int qtdeElementos;

    public Lista() {
        inicio = fim = null;
        qtdeElementos = 0;
    }

    public boolean listaVazia() {
        return inicio == null;
    }

    public void insereInicio(int e) {
        NohLista novo = new NohLista(e);
        if (listaVazia()) {
            inicio = fim = novo;
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
    
    public void insereAntes(int e, int eLista) {    // eLista e o valor anterior.
        NohLista novo = new NohLista(e);
        if (inicio.getDado() == eLista) {
            inicio.setAnterior(novo);
            novo.setProximo(inicio);
            inicio = novo;
        } else {
            NohLista atual = inicio;
            while (atual.getDado() != eLista && atual != null) {
                atual = atual.getProximo();
            }
            if (atual == null) {
                System.out.println("Elmento nao encontrado");
            } else {
                novo.setProximo(atual);
                novo.setAnterior(atual.getAnterior());
                atual.setAnterior(novo);
                novo.getAnterior().setProximo(novo);
            }
        }
    }
    
    public void insereDepois(int e, int eLista) {    // eLista e o valor anterior.
        NohLista novo = new NohLista(e);
        if (fim.getDado() == eLista) {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        } else {
            NohLista atual = inicio;
            while (atual.getDado() != eLista && atual != null) {
                atual = atual.getProximo();
            }
            if (atual == null) {    
                System.out.println("Elmento nao encontrado");
            } else {
                novo.setProximo(atual.getProximo());
                novo.setAnterior(atual);
                atual.setProximo(novo);
                novo.getProximo().setAnterior(novo);
            }
        }
    }


    public void remove(int e) {
        if (listaVazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        if(qtdeElementos == 1){
            inicio = null;
            qtdeElementos--;
            return;
        }
        if (inicio.getDado() == e) {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
            System.out.println("Elemento do inicio removido. ");
            qtdeElementos--;
        } else if (fim.getDado() == e) {
            fim = fim.getAnterior();
            fim.setProximo(null);
            System.out.println("Elemento do fim removido.");
            qtdeElementos--;
        } else {  // elemento esta no meio da lista
            NohLista n = inicio;
            while (n != null && n.getDado() != e) {
                n = n.getProximo();
            }
            if (n == null) {
                System.out.println("Elmento nao encontrado");
            } else {
                n.getAnterior().setProximo(n.getProximo());
                n.getProximo().setAnterior(n.getAnterior());
                System.out.println("Elemento " + e +  " removido.");
                qtdeElementos--;
            }
        }
    }

    public void imprimiDireita() {
        if (listaVazia()) {
            System.out.println("Lista Vazia");
        } else {
            NohLista corrente = inicio;
            while (corrente != null) {
                System.out.print(corrente.getDado() + " ");
                corrente = corrente.getProximo();
            }
            System.out.println();
        }
    }

    public void imprimiEsquerda() {
        if (listaVazia()) {
            System.out.println("Lista Vazia");
        } else {
            NohLista corrente = fim;
            while (corrente != null) {
                System.out.print(corrente.getDado() + " ");
                corrente = corrente.getAnterior();
            }
            System.out.println();
        }
    }

    public int QtdeElementos() {
        System.out.println("A lista tem " + qtdeElementos + " Elementos.");
        return qtdeElementos;
    }
}
