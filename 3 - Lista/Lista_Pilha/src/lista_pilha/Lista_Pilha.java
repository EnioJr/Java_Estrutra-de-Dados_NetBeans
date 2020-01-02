package lista_pilha;

import java.util.Scanner;

public class Lista_Pilha {

    public static void main(String[] args) {
        Lista f = new Lista();

        Scanner s = new Scanner(System.in);

        int opcao = 0, valor = 0, dado = 0;

        while (opcao != 8) {
            System.out.println("\nEscolha uma opção.");
            System.out.println("[1] Inserir no Inicio da Lista.");
            System.out.println("[2] Inserir no Fim da Lista.");
            System.out.println("[3] Inserir Antes do elemento da Lista.");
            System.out.println("[4] Inserir Depois do elemento da Lista.");
            System.out.println("[5] Remove Elemento da Lista.");
            System.out.println("[6] Quantidade de Elementos na Lista.");
            System.out.println("[7] Imprimir Lista.");
            System.out.println("[8] Sair.");

            opcao = s.nextInt();

            System.out.println("");
            switch (opcao) {
                case 1:
                    System.out.println("Escreva o valor que voce quer inserir no inicio: ");
                    f.insereInicio(valor = s.nextInt());
                    break;
                case 2:
                    System.out.println("Escreva o valor que você quer inserir no fim:");
                    f.insereFim(valor = s.nextInt());
                    break;
                case 3:
                    System.out.println("Escreve o valor que voce quer inserir");
                    System.out.println("E o Elemento da Lista onde voce quer adicionar o valor anterior.");
                    f.insereAntes(valor = s.nextInt(), dado = s.nextInt());
                    break;
                case 4:
                    System.out.println("Escreve o valor que voce quer inserir");
                    System.out.println("E o Elemento da Lista onde voce quer adicionar o valor posterior.");
                    f.insereDepois(valor = s.nextInt(), dado = s.nextInt());
                    break;
                case 5:
                    System.out.println("Escreva o elemento que você quer remover: ");
                    f.remove(valor = s.nextInt());    // PROBLEMA COMO PEGAR SO O VALOR INICIO AO INVEZ DE ESCREVER O VALOR.                                       ;
                    break;
                case 6:
                    f.QtdeElementos();
                    break;
                case 7:
                    System.out.println("Lista atual pela Direita: ");
                    f.imprimiDireita();
                    break;
                case 8:
                    break;
            }
        }
    }
}
