package ca_arvorebin;

import java.util.Random;
import java.util.Scanner;



// TEM UMA FUNÇAO REMOVE ERRADA , N FOI A QUE O GABRIEL ME MANDOU
public class Ca_ArvoreBin {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        ArvoreBin arvore = new ArvoreBin();
        
        int valor;
        Random nroRandom = new Random();
        
        System.out.println("Inserindo valores: ");
        // insere 10 inteiros de 0 a 99
        for(int i = 1; i <= 10; i++) {
            valor = nroRandom.nextInt(100);
            System.out.print(valor + " ");
            arvore.insere(valor);
        }
        
        System.out.println();
        System.out.println("Imprimindo na ordem: ");
        arvore.imprimeArvore();
        System.out.println();
        
        System.out.println("Remover: ");
        arvore.remove(s.nextInt());
        arvore.imprimeArvore();
    }
    
}
