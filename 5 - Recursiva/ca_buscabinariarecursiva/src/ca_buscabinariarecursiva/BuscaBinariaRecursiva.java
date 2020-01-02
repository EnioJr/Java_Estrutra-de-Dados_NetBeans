package ca_buscabinariarecursiva;

public class BuscaBinariaRecursiva {

    public int buscaBinaria(int[] vetor, int n) {
        return binarySearch(vetor, n, 0, vetor.length - 1);
    }

    private int binarySearch(int[] vetor, int n, int inicio, int fim) {
        int meio = (inicio + fim) / 2;

        if (inicio > fim) {
            return -1;
        }

        if (vetor[meio] < n) {
            return binarySearch(vetor, n, meio + 1, fim);
        } else if (vetor[meio] > n) {
            return binarySearch(vetor, n, inicio, meio - 1);
        } else {
            return meio;
        }
    }
}
