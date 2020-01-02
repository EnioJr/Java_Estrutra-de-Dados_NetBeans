package buscadearvore;

import java.util.Random;
import java.util.Scanner;

public class BuscaDeArvore {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        BuscaArvore arvore = new BuscaArvore();

        int valor;
        Random nroRandom = new Random();

        System.out.println("Inserindo valores: ");
        // insere 10 inteiros de 0 a 99
        for (int i = 1; i <= 10; i++) {
            valor = nroRandom.nextInt(100);
            System.out.print(valor + " ");
            arvore.insere(valor);
        }

        System.out.println();
        System.out.println("Imprimindo na ordem: ");
        arvore.imprimeArvore();
        System.out.println();

        System.out.println("(a) Caminho por extensao:");  // FALTA COLOCAR OS METODOS PARA ACHAR OS RESPECTIVOS CARACTERIS....
        System.out.println("(b) Altura:");
        System.out.println("(c) Numero de nos: ");
        System.out.println("(d) Numero de Folhas: ");
        
    }

}
