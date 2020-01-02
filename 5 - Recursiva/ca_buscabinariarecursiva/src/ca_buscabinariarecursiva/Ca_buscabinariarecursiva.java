package ca_buscabinariarecursiva;

public class Ca_buscabinariarecursiva {

    public static void main(String[] args) {
        BuscaBinariaRecursiva b = new BuscaBinariaRecursiva();
        
        int tam = 8 , procurado = 18;
        int[] vetor = new int [tam];
        
        vetor[0] = 1;
        vetor[1] = 3;
        vetor[2] = 4;
        vetor[3] = 5;
        vetor[4] = 17;
        vetor[5] = 18;
        vetor[6] = 31;
        vetor[7] = 33;
        
        int i = b.buscaBinaria(vetor, procurado);
        if(i != -1){
        System.out.println(procurado + " Encontrado na posiçao " + i);
        } else {
            System.out.println("Não encontrado.");
        }
    }                                                           
}