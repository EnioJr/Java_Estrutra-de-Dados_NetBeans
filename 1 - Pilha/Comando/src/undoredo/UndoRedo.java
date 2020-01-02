package undoredo;

import java.util.Scanner;

// Programa que compara 2 Pilhas e ver se o resultado delas no array estao iguais.

public class UndoRedo {

    Scanner s = new Scanner(System.in);

    Pilha undo;
    Pilha redo;

    public UndoRedo() {
        undo = new Pilha();
        redo = new Pilha();
    }

    public void executarEmpilhar() {
        Comando c = new Comando();       // criaçao da instancia (objeto) chamada c.  
        c.executar();                    // chamagem do metodo executa , escrita.
        undo.push(c);                   // alocar o c dentro da 1 pilha.
    }

    public void desfazerDesempilhar() {
        Comando c = undo.pop();          // pega da 1 pilha e aloca no c.
        c.desfazer();                    // chamando o metodo desfazer q esta na classe comando, dentro do desfazer esta escrito desfazer.
        redo.push(c);                    // alocando o c dentro da pilha 2(redo).
    }

    public void refazerEmpilhar() {
        Comando c = redo.pop();         // pega da 2 e aloca no c.
        c.executar();                   // chama o metodo executar , que escreve , programa concluido.
        undo.push(c);                   // pega o c aloca na pilha 1.
    }

    public static void main(String[] args) {
        UndoRedo x = new UndoRedo();
        
        while (true) { 
            System.out.println("\nDigite 1 para Empilhar.");
            System.out.println("Digite 2 para desfazer o empilhamento.");
            System.out.println("Digite 3 para refazer o empilhamento.");
            System.out.println("Digite 4 para imprimir as Pilhas.");
            System.out.println("Digite 5 para sair.\n");
            int opcao = x.s.nextInt();
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
