/*
Nome : Enio Jr
    Fala Gabriel , 
*/

package projeto4;

import java.util.Scanner;

public class Projeto4 {

    public static void main(String[] args) {
        Lista lista = new Lista(10);

        Scanner s = new Scanner(System.in);

        int valor = 0;

        lista.insere("Josephus");
        lista.insere("Muriel");
        lista.insere("Gabriel");
        lista.insere("AnyWay");
        lista.insere("SomeThing");
        lista.insere("Stone");
        lista.insere("Seila");
        lista.insere("Ideias");
        lista.insere("Aleatorios");
        lista.insere("Escritas");
        System.out.println("Soldados: ");
        lista.imprime();

        while(lista.qtdeElementos() >1){
            System.out.println("Escreva um numero de -9 a 9:");
            System.out.println("O solado removido foi:" + lista.removeSoldado(s.nextInt()));
            System.out.println("Soldados restantes:");
            lista.imprime();
        }
        System.out.println("\nO solados sobrevivente foi: " + lista.pegaInicio().getDado());
    }
}
