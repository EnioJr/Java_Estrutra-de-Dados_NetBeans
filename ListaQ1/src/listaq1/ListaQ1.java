package listaq1;

//Nome : Enio Rodrigues B Junior

import java.util.Scanner;

public class ListaQ1 {

    static Lista lista = new Lista();

    static void InserirElementos() {
        System.out.println("Digite um numero inteiro:");

        Scanner s = new Scanner(System.in);
        int dado = s.nextInt();
        if (!lista.listaVazia()) {
            Ordene(dado, lista.getFim());
        }else
        lista.insereFim(dado);
    }

    static void Ordene(int dado, NohLista node) {
        if (dado < node.getDado()) {
            if (dado >= node.getAnterior().getDado()) {
                lista.insereDepois(dado, node.getAnterior().getDado());
                return;
            }
            Ordene(dado, node.getAnterior());
        }
    }

    static void RemoverElemento() {
        if (lista.listaVazia()) {
            System.err.println("Nada a ser removido");
            return;
        }
        Scanner s = new Scanner(System.in);
        int dado = s.nextInt();
        if (dado < 0 || dado > lista.length()) {
            System.err.println("Indice " + dado + " esta fora do alcance");
        }
        lista.remove(dado);
    }

    static void ImprimirLista() {
        lista.imprimeDireita();
    }

    static void Sair() {
        System.err.println("ByeBye");
    }

    public static void main(String[] args) {
        boolean Executar = true;
          
        while (Executar) {
            System.out.println("[1] Inserir um elemento em ordem crescente");
            System.out.println("[2] Remover um elemento da posiçaoo idx");
            System.out.println("[3] Imprimir a lista (esquerda para direita)");
            System.out.println("[4] Sair");

            Scanner sn = new Scanner(System.in);

            int Menu = sn.nextInt();

            switch (Menu) {
                case 1:
                    InserirElementos();
                    break;
                case 2:
                    RemoverElemento();
                    break;
                case 3:
                    ImprimirLista();
                    break;
                case 4:
                    Sair();
                    Executar = false;
                    break;
            }
        }
    }

}
