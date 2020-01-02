package duaspilhas;

public class PilhaDupla {
    
    private final int SIZE = 10;
    
    public final int[] A = new int[SIZE];
    private int topoSuperior = 10;
    private int topoInferior = -1;
    
    //                  Pilha 1     Pilha 2
    public enum Pilha { SUPERIOR , INFERIOR };
    
    void empilha(Pilha p , int e ) throws Exception{
        if(topoInferior >= topoSuperior - 1){
            throw new Exception("Pilha Cheia!");
        }
        if(p == Pilha.SUPERIOR){
            topoSuperior--;
            A[topoSuperior] = e;
        }
        else{
            topoInferior++;
            A[topoInferior] = e;
        }
    }
    
    int desempilha(Pilha p) throws Exception {
        if(p == Pilha.SUPERIOR){
            if(topoSuperior >= SIZE) {
                throw new Exception("Pilha vazia!");
            }
            int elemento = A[topoSuperior];
            topoSuperior++;
            return elemento;
        }
        else {
            if(topoInferior < 0) {
                throw new Exception("Pilha vazia!");
            }
            int elemento = A[topoInferior];
            topoInferior--;
            return elemento;
        }
    }
}
