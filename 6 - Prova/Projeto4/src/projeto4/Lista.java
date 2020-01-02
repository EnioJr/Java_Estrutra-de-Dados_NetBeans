package projeto4;

public class Lista<T> extends Object {

    private NohLista inicio, fim;
    private int tamMax, buffer;

    public Lista(int tamMax) {
        inicio = fim = null;
        this.tamMax = tamMax;
        buffer = 0;
    }

    public boolean listaVazia() {
        return inicio == null;
    }

    public void insere(T e) {
        // Como fazer para colocar valores em 10 nós?
        // Coloco valor em apenas 1 nó.       
        NohLista novo = new NohLista(e);

        if (listaVazia()) {
            inicio = fim = novo;
            novo.setProximo(novo);
            novo.setAnterior(novo);
            buffer = 1;
        } else {
            if (buffer >= tamMax) {
                fim.setProximo(novo);
                novo.setAnterior(novo);
                fim = novo;
                inicio = inicio.getProximo();
                fim.setProximo(inicio);
                inicio.setAnterior(fim);
            } else {
                fim.setProximo(novo);
                inicio.setAnterior(novo);
                novo.setProximo(inicio);
                novo.setAnterior(fim);
                fim = novo;
                buffer++;
            }
        }
    }

    public T remove(int x) {
        NohLista corrente = inicio;
        if (x == 0) {
            T dado = (T) corrente.getDado();
            corrente.getAnterior().setProximo(corrente.getProximo());
            corrente.getProximo().setAnterior(corrente.getAnterior());
            inicio = corrente.getProximo();
            buffer--;
            return dado;
        } else {
            T dado = (T) corrente.getDado();
            corrente.getAnterior().setProximo(corrente.getProximo());
            corrente.getProximo().setAnterior(corrente.getAnterior());
            buffer--;
            return dado;
        }            
    }

    public T removeSoldado(int valor) {
        NohLista corrente = inicio;       
        if (valor == 0) {             
            return remove(valor);            
        } else if (valor > 0) {
            for (int i = 1; i <= valor; i++) {
                corrente = corrente.getProximo();
            }
            if (!listaVazia()) {                
                return remove(valor);
                
            } else {
                System.out.println("Lista Vazia");
                return null;
            }
        } else {
            for (int i = -1; i >= valor; i--) {
                corrente = corrente.getAnterior();
            }
            if (!listaVazia()) {                
                return remove(valor);
            } else {
                System.out.println("Lista Vazia.");
                return null;
            }
        }
    }

    public int qtdeElementos() {
        return buffer;
    }

    public NohLista pegaInicio() {
        return inicio;
    }

    public void imprime() {
        int index = 0;
        if (listaVazia()) {
            System.out.println("Lista Vazia!");
        } else {
            NohLista temp = inicio;
            do {
                System.out.print(temp.getDado() + " ");
                temp = temp.getProximo();
            } while (temp != inicio);
            System.out.println();
        }
    }
}
