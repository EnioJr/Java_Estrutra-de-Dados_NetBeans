package pilha;

import java.util.Scanner;

public class Pilha {
    ED_Pilha p = new ED_Pilha();
    Scanner s = new Scanner(System.in);
    int opcao;

    void menu(){
        System.out.println("---------PILHA---------");
        System.out.println("[1]-Inserir um inteiro");
        System.out.println("[2]-Remover um elemento");
        System.out.println("[3]-Imprimir a pilha");
        System.out.println("[4]-Sair");
        
        opcoes();
    }
    
    void opcoes(){
        opcao = s.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite um número a ser inserido: ");
                p.push(s.nextInt());
                System.out.println("Número inserido na pilha!");
                menu();
                break;
            case 2:
                p.pop();
                System.out.println("Número removido da pilha");
                menu();
                break;
            case 3:
                System.out.println("O tamanho da pilha é: " + p.tamanhoPilha() + "\n");
                System.out.println("A pilha é:");
                p.imprime();
                menu();
                break;
            case 4:
                break;
        }
    }
    
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.menu();
    }    
}
