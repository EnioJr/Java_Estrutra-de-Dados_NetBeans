package Arvore_BuscaEmLargura;

import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
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
  
    //___________________________________________________________________________
    
    
    //letra (a)
    public void Extensao() {
        Queue<NohArvore> filaArvore = new LinkedList<>();
        filaArvore.add(raiz);
        
        if(isEmpty()) System.out.println("Arvore vazia");
        
        else percorreExtensao(filaArvore);
    }
    
    private void percorreExtensao(Queue<NohArvore> fila) {
        if (raiz == null) {
            return;
        }

        NohArvore raiz = fila.remove();

        System.out.print(raiz.getDado() + " ");

        if (raiz.getNohEsquerdo() != null) {
            fila.add(raiz.getNohEsquerdo());
        }

        if (raiz.getNohDireito() != null) {
            fila.add(raiz.getNohDireito());
        }
        
        if(!fila.isEmpty()) this.percorreExtensao(fila);
        else System.out.println();
    }
    
    //letra (b)
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

    //letra (c)
    public int nohs(){
        return nohs(raiz);
    }
    private int nohs(NohArvore node) {
        if(node == null){
            return 0;
        }
        return 1 + nohs(node.getNohEsquerdo()) + nohs(node.getNohDireito());
    }
    
    //letra (d)
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
