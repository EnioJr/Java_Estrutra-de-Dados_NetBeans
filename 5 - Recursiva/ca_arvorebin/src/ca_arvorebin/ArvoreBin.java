package ca_arvorebin;

public class ArvoreBin {
    private NohArvore root;
    
    public boolean ArvoreVazia(){
        if(root == null){
            return true;
        }
        return false;
    }
        
    public void inserir(int valor){
        inserir(this.root , valor);
    }
    
    public void inserir(NohArvore node , int valor){
        if(this.root == null){ // a arvore esta vazia?
            this.root = new NohArvore(valor);
        } else {
            if(valor < node.getDado()) { // insere a esquerda
                if(node.getNohEsquerdo() != null){
                    inserir(node.getNohEsquerdo() , valor);
                } else{
                    // Se nodo esquerdo vazio insere o novo no aqui
                    node.setNohEsquerdo(new NohArvore(valor));
                }
                //Verifica se o valor a ser inserido e maior que o no corrente 
                //da arvore , se sim vai para subarvore direita
            } else if(valor >  node.getDado()) {
                //Se tiver elemento no nó direito continua a busc
                if(node.getNohDireito() != null) {
                    inserir(node.getNohDireito() , valor);
                } else {
                    // Se nodo direito vazio insere o novo no aqui
                    node.setNohDireito(new NohArvore(valor));
                }
            }
        }
    }
    
    public void imprimi(){
        if(this.root == null)
            System.out.println("Arvore Vazia");
        else
            imprimi(this.root);
    }    
    
    private void imprimi(NohArvore node){
        if(node.getNohEsquerdo() != null){
            imprimi(node.getNohEsquerdo());            
        }
        System.out.println("No:" + node.getDado());
        
        if(node.getNohDireito() != null){
            imprimi(node.getNohDireito());
        }
        System.out.println("No:" + node.getDado());
    }    
}
