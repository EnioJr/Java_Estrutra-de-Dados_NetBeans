package undoredo;

import java.util.Scanner;

// Programa que compara 2 Pilhas e ver se o resultado delas no array estao iguais.

public class UndoRedo {

    Scanner valor = new Scanner(System.in);

    Pilha undo;
    Pilha redo;

    public UndoRedo() {
        undo = new Pilha();
        redo = new Pilha();
    }

    public void executarEmpilhar() {
        Comando c = new Comando();       
        c.executar();                   
        undo.push(c);                   
    }

    public void desfazerDesempilhar() {
        Comando c = undo.pop();          
        c.desfazer();                    
        redo.push(c);                    
    }

    public void refazerEmpilhar() {
        Comando c = redo.pop();         
        c.executar();                   
        undo.push(c);                   
    }

    public static void main(String[] args) {
        UndoRedo x = new UndoRedo();
        
        while (true) { 
            System.out.println("\nDigite 1 para Empilhar.");
            System.out.println("Digite 2 para desfazer o empilhamento.");
            System.out.println("Digite 3 para refazer o empilhamento.");
            System.out.println("Digite 4 para imprimir as Pilhas.");
            System.out.println("Digite 5 para sair.\n");
            int opcao = x.valor.nextInt();
            switch (opcao) {
                case 1:
                    x.executarEmpilhar();
                    break;
                case 2:
                    x.desfazerDesempilhar();
                    break;
                case 3:
                    x.refazerEmpilhar();
                    break;
                case 4:
                    System.out.println("Pilha Undo: ");
                    x.undo.imprime();
                    System.out.println("Pilha Redo: ");
                    x.redo.imprime();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opçao Invalida!");
                    break;

            }

        }
    }
}
