package buscadearvore;

public class BuscaArvore {
    private NohArvore raiz;
    
    public boolean isEmpty(){
        return raiz == null;
    }
    
    // insere um novo Noh na árvore
    public void insere(int dado){
        insere(raiz, dado);
    }
    
    //insere os nós de forma recursiva
    public void insere(NohArvore node, int dado){
        if (isEmpty()) {
            raiz = new NohArvore(dado);
        } else {
            if (dado < node.getDado()) {
                if (node.getNohEsquerdo() != null) {
                    insere(node.getNohEsquerdo(), dado);
                } else {
                    node.setNohEsquerdo(new NohArvore(dado));
                }
            } else if (dado > node.getDado()){
                if (node.getNohDireito() != null) {
                    insere(node.getNohDireito(), dado);
                } else {
                    node.setNohDireito(new NohArvore(dado));
                }
            }
        }
    }
    
    // imprime a arvore na ordem
    public void imprimeArvore(){
        if (isEmpty()) {
            System.out.println("Vazia!");
        } else
            imprimeArvore(raiz);
    }
    
    // método recursivo para realizar percurso na ordem
    public void imprimeArvore(NohArvore node){
        if(node.getNohEsquerdo() != null){
            imprimeArvore(node.getNohEsquerdo());
        }
        
        System.out.print(node.getDado() + " ");
        
        if (node.getNohDireito() != null){
            imprimeArvore(node.getNohDireito());
        }
    }
  
    public void extensao(){
        
    }
   
}
