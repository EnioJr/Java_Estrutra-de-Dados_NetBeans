
package ca_buscabinariarecursiva;

public class Ca_BuscaBinariaRecursiva {

    public static void main(String[] args) {
        BuscaBinariaRecursiva b = new BuscaBinariaRecursiva();
        
        int tam = 8;
        int procurado = 10;
        int[] vet = new int[tam];
        
        vet[0] = 1;
        vet[1] = 3;
        vet[2] = 4;
        vet[3] = 5;
        vet[4] = 17;
        vet[5] = 18;
        vet[6] = 31;
        vet[7] = 33;
        
        int i = b.buscaBinaria(vet, procurado);
        if (i != -1) {
            System.out.println(procurado + " encontrado na posição " + i);
        } else {
            System.out.println("Não encontrado");
        }
        
    }
    
}
