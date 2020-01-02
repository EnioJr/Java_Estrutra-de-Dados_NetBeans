package simuladoprova01;

import java.util.Scanner;

public class SimuladoProva01 {  

    public void avaliaExpressao(String expr){
        Pilha<Character> pInicio = new Pilha(); //Pilha para armazenar o início da str até o C
        Pilha<Character> pFinal = new Pilha(); //Pilha para armazenar o fim da str depois do C
        
        for(int i = 0; expr.charAt(i) != 'C'; i++){ //Percorre cada caractere da expr até encontrar um 'C' (->abbCbba)
            pInicio.push(expr.charAt(i)); //Enquanto não encontrar o 'C' faz o push na pInicio de cada caractere da expr
        }
        
        for(int j = expr.length() - 1; expr.charAt(j) != 'C'; j--){ //Percorre partindo do último caractere da expr até encontrar um 'C' (abbCbba<-)
            pFinal.push(expr.charAt(j)); //Enquanto não encontrar o 'C' faz o push na pFinal de cada caractere da expr (a sequência dessa pilha ficará invertida)
        }
        
        while(!pInicio.pilhaVazia() && !pFinal.pilhaVazia()){ //Laço para desempilhar e comparar até esvaziar as pilhas
            if (pInicio.pop() != pFinal.pop()) { //Vai desempilhando as duas e comparando o valor desempilhado
                System.out.println("String incorreta!"); //Como a segunda pilha está invertida, caso algum valor da primeira não for igual a um da segunda é pq digitou errado
                System.exit(0); //Para o while e sai do programa
            }
        }
        System.out.println("String correta!"); //Se chegou até aqui é pq as pilhas estavam iguais e saiu do while
    }
    
    public static void main(String[] args) {
        SimuladoProva01 simu = new SimuladoProva01();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Insira a string: ");
        String str = s.nextLine();
        simu.avaliaExpressao(str);
    }
    
}
