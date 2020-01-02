/*
    Nome: Enio Rodrigues B. Junior
    LAB 6
 */
package Arvore_BuscaEmLargura;

public class Arvore_BuscaEmLargura {

    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.insere(8);
        arvore.insere(4);
        arvore.insere(2);
        arvore.insere(6);
        arvore.insere(5);
        arvore.insere(1);
        arvore.insere(14);
        arvore.insere(3);
        arvore.insere(7);        
        arvore.insere(12);
        arvore.insere(10);
        arvore.insere(11);
        arvore.insere(13);
        arvore.insere(9);
        arvore.insere(15);

        //              8
        //           /     \
        //         4         12
        //       /   \      /   \ 
        //      2     6    10    14            
        //     / \   / \   / \   / \
        //    1   3 5   7 9  11 13 15
        System.out.print("(a) Caminho por extensão: ");
        arvore.Extensao();
        System.out.println("(b) Altura: " + arvore.altura());
        System.out.println("(c) Numero de nós: " + arvore.nohs());
        System.out.println("(d) Numero de folhas: " + arvore.folhas());

    }
}
