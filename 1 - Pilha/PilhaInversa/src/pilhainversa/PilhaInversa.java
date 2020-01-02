package pilhainversa;

import java.util.Scanner;

public class PilhaInversa {        
          
    public static void main(String[] args) {
        Pilha<Character> p = new Pilha();
                        
        Scanner s = new Scanner(System.in);
        String expr = "";

        while (!expr.equals("sair")) {
            System.out.println("-----------------\nDigite uma expressão:");
            expr = s.nextLine();
            
            for (int i = 0; i< expr.length(); i++) {
            p.push(expr.charAt(i));                        
            }
            
            String reverseString = ""; 
            while (!p.pilhaVazia()) {           // pilha nao esta vazia.
            reverseString = reverseString + p.pop();                
        }
                System.out.println("A expressao inversa ficara a direita do C!");
                System.out.println(expr + "C" + reverseString);
                System.out.println("\nEscreva sair para sair do programa.");
      }        
    }    
}
