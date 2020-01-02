public class NohPilha<T> extends Object {
    NohPilha prox;
    T dado;
    
    public NohPilha(){
        prox = null;
    }

    public NohPilha getProx() {
        return prox;
    }

    public void setProx(NohPilha prox) {
        this.prox = prox;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }
    
    
}
