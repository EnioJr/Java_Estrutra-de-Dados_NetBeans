/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jaarvorebinariaint;

/**
 *
 * @author EDGARD LAMOUNIER
 */
public class BinaryTree {
    private Node root;
    // private int nroNohs;

    public boolean isEmpty(){
        if(root == null)
            return true;
        else 
            return false;
    }
    
    public int getAltura(){
        return getAltura(this.root);
    }
    
    private int getAltura(Node root){
        if(root == null){
            return 0;
        }
        int altEsq = getAltura(root.getNoEsquerda());
        int altDir = getAltura(root.getNoDireita());
        if(altEsq > altDir){
            return altEsq + 1;
        } else {
            return altDir + 1;
        }
    }
    
    public int getQtdNode(){
        return getQtdNode(root);
    }
    
    private int getQtdNode(Node root){
        if(root == null){
            return 0;
        }
        int qtdNodeEsq = getQtdNode(root.getNoEsquerda());
        int qtdNodeDireita = getQtdNode(root.getNoDireita());
        return qtdNodeEsq + qtdNodeDireita + 1;
    }
    
    public void imprimirArvore(){
        if(this.root == null)
            System.out.println("Árvore vazia");
        else
            imprimirArvore(this.root);
    }
    
    private void imprimirArvore(Node node){
        if(node.getNoEsquerda() != null){
            imprimirArvore(node.getNoEsquerda());
        }
        
        System.out.println("Nó: " + node.getValor());
        
        if (node.getNoDireita() != null){
            imprimirArvore(node.getNoDireita());
        }
    }
    
    public void inserir(int valor){
        inserir(this.root, valor);
    }
    
    public void inserir(Node node, int valor) {
        if(isEmpty()){ // a árvore está vazia?
            this.root = new Node(valor);
        } else {
            if (valor < node.getValor()) { // insere à esquerda
                if (node.getNoEsquerda() != null) { 
                    inserir(node.getNoEsquerda(), valor); 
                } else { 
                    //Se nodo esquerdo vazio insere o novo no aqui 
                    node.setNoEsquerda(new Node(valor)); 
                } 
                //Verifica se o valor a ser inserido é maior que o no corrente 
                //da árvore, se sim vai para subarvore direita 
            } else if (valor > node.getValor()) { 
                //Se tiver elemento no no direito continua a busca 
                if (node.getNoDireita() != null) { 
                    inserir(node.getNoDireita(), valor); 
                } else {
                    //Se nodo direito vazio insere o novo no aqui 
                    node.setNoDireita(new Node(valor)); 
                } 
            } // fim do if para inserir à direita
        }
    } // fim do metodo inserir(Node node, int valor)
    
    public Node remover(int valor)  {
        return remover(this.root, valor);
    }
    
    private Node remover(Node node, int valor) {
        if(this.root == null){
            System.out.println("Árvore vazia");
            return null; 
        } else {            
            if(valor < node.getValor()){
                node.setNoEsquerda(remover(node.getNoEsquerda(), valor));
            } else if(valor > node.getValor()){
                node.setNoDireita(remover(node.getNoDireita(), valor));
            } else if (node.getNoEsquerda() != null && node.getNoDireita() != null) {
                /*2 filhos*/  
                System.out.println("  Removeu No " + node.getValor());
                node.setValor(encontraMinimo(node.getNoDireita()).getValor());
                node.setNoDireita(removeMinimo(node.getNoDireita()));
            } else { /* 0 ou 1 filho */ 
                System.out.println("  Removeu No " + node.getValor());  
                node = (node.getNoEsquerda() != null) ? node.getNoEsquerda() 
                                                      : node.getNoDireita();  
            }  
            return node;
        }
    }
    
    private Node removeMinimo(Node node) {  
        if (node == null) {  
            System.out.println("  ERRO ");  
        } else if (node.getNoEsquerda() != null) {  
            node.setNoEsquerda(removeMinimo(node.getNoEsquerda()));  
            return node;  
        } else {  
            return node.getNoDireita();  
        }  
        return null;  
    }  
  
    private Node encontraMinimo(Node node) {  
        if (node != null) {  
            while (node.getNoEsquerda() != null) {  
                node = node.getNoEsquerda();  
            }  
        }  
        return node;  
    } 
} // fim da classe BinaryTree
