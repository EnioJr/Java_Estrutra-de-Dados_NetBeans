package undoredo;

public class Comando {
    
    private static int contador = 0;
    private int indice;
    
    public Comando(){
        contador++;
        indice = contador; 
}    
    public String toString(){
        return String.format("Comando %d", indice);
    }    
    public void executar(){
        System.out.println("Comando " +indice + " executado com sucesso!");
    }
    public void desfazer(){
        System.out.println("Comando " +indice + " desfeito com sucesso!");
    }
}
