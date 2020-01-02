
package arvorebin_buscaext2;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBin {
    private NohArvore raiz;
    
    public boolean isEmpty(){
        return raiz == null;
    }
   
    public void insere(int dado){
        insere(raiz, dado);
    }
    
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
    
    public void imprimeArvore(){
        if (isEmpty()) {
            System.out.println("Vazia!");
        } else
            imprimeArvore(raiz);
    }
    
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
    
    
    //-------------------------------------------------------------------------
    
    
    //Letra (a)
    public void percorreExtensao() {
        Queue<NohArvore> filaArvore = new LinkedList<>();
        filaArvore.add(raiz);
        
        if(isEmpty()) System.out.println("Arvore vazia");
        
        else percorreExtensao(filaArvore);
    }
    
    private void percorreExtensao(Queue<NohArvore> filaArvore) {
        if (raiz == null) {
            return;
        }

        NohArvore node = filaArvore.remove();

        System.out.print(node.getDado() + " ");

        if (node.getNohEsquerdo() != null) {
            filaArvore.add(node.getNohEsquerdo());
        }

        if (node.getNohDireito() != null) {
            filaArvore.add(node.getNohDireito());
        }
        
        if(!filaArvore.isEmpty()) this.percorreExtensao(filaArvore);
        else System.out.println();
    }
    
    //Letra (b)
    public int altura() {
        return altura(raiz);
    }

    private int altura(NohArvore node) {
        if (node == null) {
            return 0;
        } else {
            int profundidadeEsq = altura(node.getNohEsquerdo());
            int profundidadeDir = altura(node.getNohDireito());
            if (profundidadeEsq > profundidadeDir) {
                return (profundidadeEsq + 1);
            } else {
                return (profundidadeDir + 1);
            }
        }
    }

    //Letra (c)
    public int nohs(){
        return nohs(raiz);
    }
    private int nohs(NohArvore node) {
        if(node == null){
            return 0;
        }
        return 1 + nohs(node.getNohEsquerdo()) + nohs(node.getNohDireito());
    }
    
    //Letra (d)
    public int folhas() {
        return folhas(raiz);
    }

    private int folhas(NohArvore node) {
        if (node == null) {
            return 0;
        }
        if (node.getNohEsquerdo() == null && node.getNohDireito() == null) {
            return 1;
        } else {
            return folhas(node.getNohEsquerdo()) + folhas(node.getNohDireito());
        }
    }
    
}
