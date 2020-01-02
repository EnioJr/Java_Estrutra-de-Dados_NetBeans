package ca_fila;

public class Ca_Fila {

    public static void main(String[] args) {
        Fila f = new Fila();
        
        f.insere(1);
        f.insere(2);
        f.insere(3);
        f.insere(4);
        
        f.imprime();
        
        System.out.println();
        System.out.println("Elemento removido: " + f.remove());
        System.out.println("Elemento removido: " + f.remove() + "\n");        
        
        f.imprime();
    }
    
}
