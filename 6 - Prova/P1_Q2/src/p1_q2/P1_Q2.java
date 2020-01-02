
package p1_q2;

public class P1_Q2 {

    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha();
        
        p.push(1);
        p.push(2);
        p.push(3);
        
        p.imprime();
        
        System.out.println("LETRA C - Tenta inserir 3:");
        p.push(3);
        
        p.imprime();
        
        System.out.println("LETRA A - Pilha invertida:");
        p.inverter().imprime();
        
        System.out.println("Pilha original:");
        p.imprime();
        
        System.out.println("LETRA B - Tamanho da pilha: " + p.tamanho());
        
        System.out.println("-----------------\npop");
        p.pop();
        p.imprime();
    }
    
}
