/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca_ListaDE;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author EnioJr
 */
public class Ca_ListaDE {

    static Lista s_Lista = new Lista();
    
    static void InserirValor() {
        System.out.println("-Insira um inteiro:");

        Scanner sc = new Scanner(System.in);
        int elm = sc.nextInt();
        if (!s_Lista.listaVazia()) {
            Ordenar(elm, s_Lista.getFim());
            return;
        }else
        s_Lista.insereFim(elm);
    }

    static void Ordenar(int val, NohLista noh) {
        if (val < noh.getDado()) {
            if (val >= noh.getAnterior().getDado()) {
                s_Lista.insereDepois(val, noh.getAnterior().getDado());
                return;
            }
            Ordenar(val, noh.getAnterior());
        }
    }

    static void RemoverValor() {
        if (s_Lista.listaVazia()) {
            System.err.println("Nada a ser removido");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        if (idx < 0 || idx > s_Lista.length()) {
            System.err.println("Indice " + idx + " esta fora do alcance");
        }
        s_Lista.remove(idx);
    }

    static void ImprimirLista() {
        s_Lista.imprimeDireita();
    }

    static void Sair() {
        System.err.println("Adeus");
    }

    public static void main(String[] args) {
        boolean Executar = true;
          
        while (Executar) {
            System.out.println("--------ARVORE----------------------------");
            System.out.println("[1] Inserir um elemento em ordem crescente");
            System.out.println("[2] Remover um elemento da posiÃ§Ã£o idx");
            System.out.println("[3] Imprimir a lista (esquerda para direita)");
            System.out.println("[4] Sair");

            Scanner sn = new Scanner(System.in);

            int Menu = sn.nextInt();

            switch (Menu) {
                case 1:
                    InserirValor();
                    break;
                case 2:
                    RemoverValor();
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
