package pilhadinamica;

public class PilhaDinamica {
    
    public static void main(String[] args) {
        Pilha<Integer> p = new Pilha();
        
        
        p.push(1);
        p.push(2);
        p.push(3);
        
        System.out.println("Antes");
        p.imprime();
        
        System.out.println("");
        System.out.println(p.pop());
        System.out.println("Depois");
        p.imprime();
    }
    
}
