package ca_filacircular;

import java.util.Scanner;

public class Ca_FilaCircular {

    public static void main(String[] args) {
        Fila f = new Fila(5);
        
        Scanner s = new Scanner(System.in);
        int opcao = 0;
        int elemento = 0;
        
        while (opcao != 3) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("[1] Inserir na fila de impressão (insere)");
            System.out.println("[2] Enviar para a impressora (remove)");
            System.out.println("[3] Sair.");
            
                opcao = s.nextInt();
            
            switch (opcao) {
                case 1:
                    f.insere(elemento++);
                    System.out.print("\nFila atual: ");
                    f.imprime();
                    break;
                case 2:
                    System.out.println("Elemento " + f.remove() + " removido com sucesso!");
                    System.out.print("\nFila atual: ");
                    f.imprime();
                    break;
                case 3:
                    break;
            }
        }
        
    }
    
}
