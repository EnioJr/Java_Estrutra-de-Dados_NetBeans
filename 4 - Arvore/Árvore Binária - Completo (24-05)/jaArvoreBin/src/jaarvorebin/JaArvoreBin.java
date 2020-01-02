/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jaarvorebin;

import java.util.Random;

/**
 *
 * @author EDGARD LAMOUNIER
 */
public class JaArvoreBin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreBin< Integer > arvore = new ArvoreBin<>();
        
        int valor;
        Random nroRandom = new Random();
        
        System.out.println( "Inserindo valores: ");
        // insere 10 inteiros de 0 a 99
        for( int i = 1; i <= 10; i++) {
            valor = nroRandom.nextInt(100);
            System.out.printf("%d ", valor);
            arvore.insereNoh(valor);
        }
        
        System.out.println();
        System.out.println( "Imprimindo na ordem: ");
        arvore.inorderTraversal();
        System.out.println();
    }
    
}
