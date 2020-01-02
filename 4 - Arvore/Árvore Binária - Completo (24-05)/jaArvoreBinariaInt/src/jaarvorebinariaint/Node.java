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
public class Node {
    // atributos
    private Integer valor;
    private Node    noEsquerda;
    private Node    noDireita;  
    
    // métodos
    public Node() { }

    public Node(Integer _valor) {
        this.valor = _valor;
        noEsquerda = null;
        noDireita = null; 
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Node getNoEsquerda() {
        return noEsquerda;
    }

    public void setNoEsquerda(Node noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    public Node getNoDireita() {
        return noDireita;
    }

    public void setNoDireita(Node noDireita) {
        this.noDireita = noDireita;
    }

    @Override
    public String toString() {
        return "Node [valor=" + valor + "]";
    }    
    
} // fim da classe Node
