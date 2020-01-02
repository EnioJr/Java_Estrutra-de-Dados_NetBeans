
package ca_palindroma;

import java.util.Scanner;

public class Ca_Palindroma {

    public static void main(String[] args) {
        Palindroma pa = new Palindroma();
        Scanner s = new Scanner(System.in);
        String expr = "";
        
        while (!expr.equals("sair")) {
            System.out.println("-----------------\nDigite uma expressão:");
            expr = s.nextLine();
            pa.verificaPalindroma(expr);
        }
    }
}
