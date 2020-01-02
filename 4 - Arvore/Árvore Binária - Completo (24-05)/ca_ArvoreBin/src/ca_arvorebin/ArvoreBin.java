package ca_arvorebin;

public class ArvoreBin {
    private NohArvore raiz;
    
    public boolean isEmpty(){
        return raiz == null;
    }
    
    // insere um novo Noh na árvore
    public void insere(int dado){
        insere(raiz, dado);
    }
    
    //insere os nós de forma recursiva
    public void insere(NohArvore node, int dado
    ){
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
    
    public NohArvore remove(int dado){
        return remove(raiz, dado);
    }
    
    private NohArvore remove(NohArvore node, int dado) {
        if(isEmpty()){
            System.out.println("Árvore vazia!");
            return null; 
        } else {            
            if(dado < node.getDado()){
                node.setNohEsquerdo(remove(node.getNohEsquerdo(), dado));
            } else if(dado > node.getDado()){
                node.setNohDireito(remove(node.getNohDireito(), dado));
            } else if (node.getNohEsquerdo() != null && node.getNohDireito() != null) {
                /*2 filhos*/  
                node.setDado(encontraMinimo(node.getNohDireito()).getDado());
                node.setNohDireito(removeMinimo(node.getNohDireito()));
                System.out.println("  Removeu No " + node.getDado());
            } else { /* 0 ou 1 filho */
                if (node.getNohEsquerdo() != null)
                    node = node.getNohEsquerdo();
                else
                    node = node.getNohDireito();
                System.out.println("Removeu No " + node.getDado());
            }  
            return node;
        }
    }
    
    private NohArvore removeMinimo(NohArvore node) {  
        if (node == null) {  
            System.out.println("Erro: Nó não existe!");  
        } else if (node.getNohEsquerdo() != null) {  
            node.setNohEsquerdo(removeMinimo(node.getNohEsquerdo()));  
            return node;  
        } else {  
            return node.getNohDireito();  
        }  
        return null;  
    }  
  
    private NohArvore encontraMinimo(NohArvore node) {  
        if (node != null) {  
            while (node.getNohEsquerdo() != null) {  
                node = node.getNohEsquerdo();  
            }  
        }  
        return node;  
    }
}