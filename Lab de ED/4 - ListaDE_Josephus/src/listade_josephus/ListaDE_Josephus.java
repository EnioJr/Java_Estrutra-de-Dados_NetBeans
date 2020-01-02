
package listade_josephus;

import java.util.Scanner;

public class ListaDE_Josephus {

    public static void main(String[] args) {
        Lista<String> soldados = new Lista(10);
        
        Scanner s = new Scanner(System.in);
        
        soldados.insereSoldado("A");
        soldados.insereSoldado("B");
        soldados.insereSoldado("C");
        soldados.insereSoldado("D");
        soldados.insereSoldado("E");
        soldados.insereSoldado("F");
        soldados.insereSoldado("G");
        soldados.insereSoldado("H");
        soldados.insereSoldado("I");
        soldados.insereSoldado("J");
        System.out.print("Soldados: ");
        soldados.imprime();
        while (soldados.contaElementos() > 1) {
            System.out.println("Insira um numero de -9 a 9:");
            System.out.println("O soldado removido foi: " + soldados.removeSoldado("A",s.nextInt()));
            System.out.print("Soldados restantes: ");
            soldados.imprime();
        }
        System.out.println("\nO soldado sobrevivente foi: " + soldados.getInicio().getDado());
    }
}
