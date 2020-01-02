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
public class JaArvoreBinariaInt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree arvoreBin = new BinaryTree();
        
        arvoreBin.inserir(25);
        arvoreBin.inserir(20);
        arvoreBin.inserir(30);
        arvoreBin.inserir(36);
        arvoreBin.inserir(18);
        arvoreBin.inserir(10);
        arvoreBin.inserir(23);
        arvoreBin.inserir(40);
        arvoreBin.imprimirArvore();
        arvoreBin.remover(25);
        arvoreBin.imprimirArvore(); 
        //arvoreBin.remover(23);
        //arvoreBin.imprimirArvore();
    } 
}
