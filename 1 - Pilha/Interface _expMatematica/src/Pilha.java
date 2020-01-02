public class Pilha<T> extends Object{
    
    NohPilha topo;

    public Pilha(){
        topo = null;
    }
    
    public boolean pilhaVazia(){
        return topo == null;
    }
    
    public void push(T valor){
        NohPilha novo = new NohPilha();
        novo.setDado(valor);
        novo.setProx(topo);
        topo = novo ;        
    }
    
    public T pop(){
        T temp = (T) topo.getDado();
        topo = topo.getProx();       
        return temp;
    }
    
    public void imprime(){
        if(pilhaVazia()){
            System.out.println("Pilha Vazia!");
        }else{
            NohPilha n = topo;
            while(n != null) {
                System.out.println(n.getDado().toString());
                n = n.getProx();
            }
        }
    }
}
