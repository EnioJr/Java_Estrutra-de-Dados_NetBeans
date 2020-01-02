package listade_josephus;

public class Lista<T> extends Object {

    private NohLista inicio, fim;
    private int buffer, maxSize;

    public Lista(int _maxSize) {
        inicio = fim = null;
        buffer = 0;
        maxSize = _maxSize;
    }
    
    public boolean listaVazia() {
        return inicio == null;
    }

    public void imprime() {
        int index = 0;
        if (listaVazia()) {
            System.out.println("Lista vazia!");
        } else {
            NohLista temp = inicio;
            do {
                System.out.print(temp.getDado() + " ");
                temp = temp.getProximo();
                index++;
            } while (index < buffer);
            System.out.println();
        }
    }

    public int contaElementos() {
//        System.out.println("A lista tem " + buffer + " elementos.");
        return buffer;
    }
    
    public NohLista getInicio() {
        return inicio;
    }

    public void insereSoldado(T e) {
        NohLista novo = new NohLista(e);
        if (listaVazia()) {
            inicio = fim = novo;
            novo.setProximo(novo);
            novo.setAnterior(novo);
            buffer = 1;
        } else {
            if (buffer >= maxSize) {
                fim.setProximo(novo);
                fim.setAnterior(novo);
                fim = novo;
                inicio = inicio.getProximo();
                novo.setProximo(inicio);
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
    
    public T removeSoldado(String sorteado, int N) {
        NohLista corrente = encontraSoldado(sorteado);
        if (N == 0) {
            T dado = (T) corrente.getDado();
            corrente.getAnterior().setProximo(corrente.getProximo());
            corrente.getProximo().setAnterior(corrente.getAnterior());
            inicio = corrente.getProximo();
            buffer--;
            return dado;
        } else if (N > 0) {
            for (int i = 1; i <= N; i++) {
                corrente = corrente.getProximo();
            }
            if (!listaVazia()) {
                T t = (T) corrente.getDado();
                corrente.getAnterior().setProximo(corrente.getProximo());
                corrente.getProximo().setAnterior(corrente.getAnterior());
                buffer--;
                return t;
            } else {
                System.out.println("Lista Vazia!");
                return null;
            }
        } else {
            for (int i = -1; i >= N; i--) {
                corrente = corrente.getAnterior();
            }
            if (!listaVazia()) {
                T t = (T) corrente.getDado();
                corrente.getAnterior().setProximo(corrente.getProximo());
                corrente.getProximo().setAnterior(corrente.getAnterior());
                buffer--;
                return t;
            } else {
                System.out.println("Lista Vazia!");
                return null;
            }
        }
    }
    
    public NohLista encontraSoldado(String e){
        int aux = 0;
        NohLista encontrar = inicio;
        
        while(aux != contaElementos() && !encontrar.getDado().equals(e))
        {
            aux++;
            encontrar = encontrar.getProximo();
        }
        
        return encontrar;
    }
}
    
