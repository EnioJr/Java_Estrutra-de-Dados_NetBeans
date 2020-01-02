package ca_palindroma;

public class Palindroma {
    Pilha p = new Pilha();
    
    public void verificaPalindroma(String frase) {
        //frase = frase.replace(" ","").replace("\t",""); //replace espaços e tabs
        for (int i = 0; i< frase.length(); i++) { //passa por toda a expressão
            p.push(frase.charAt(i)); //empilha cada caractere da expressão (transforma a string em um array).
        }
        String reverseString = "";
        while (!p.pilhaVazia()) {           // pilha nao esta vazia.
            reverseString = reverseString + p.pop();                
        }
        
        if (frase.equals(reverseString)) {
            System.out.println("A expressão '" + frase + "' é palindroma");
        } else {
            System.out.println("A expressão '" + frase + "' não é palindroma");
        }
    }
}   