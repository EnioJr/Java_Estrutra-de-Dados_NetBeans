
package p1_q1;

public class P1_Q1 {

    public static void main(String[] args) {
        Pilha<String> ventilador = new Pilha();
        
        //Montar produto
        ventilador.push("Cúpula de vidro");
        ventilador.push("Lâmpada");
        ventilador.push("Hélice 1");
        ventilador.push("Hélice 2");
        ventilador.push("Hélice 3");
        ventilador.push("Suporte");
        
        System.out.println("PRODUTO MONTADO:");
        ventilador.imprime();
        
        //Trocar a Hélice 2 por Hélice 2 NOVA
        System.out.println("\nSUBSTITUIR PARTE DEFEITUOSA:");
        ventilador.trocaPeca("Hélice 2", "Hélice 2 NOVA");
        
        // imprime a pilha do robo
        System.out.println("\nPRODUTO CONSERTADO:");
        ventilador.imprime();
    }
    
}
