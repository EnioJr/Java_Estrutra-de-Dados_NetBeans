package listaordenada;

public class ListaOrdenada {

    public static void main(String[] args) {
        int[] x = new int[10];

        for (int i = 0; i < 10; i++) {
            x[i] = i + 1;
        }

        System.out.println(getIndex(x, 1));
        System.out.println(getIndex(x, 2));

    }

    public static int getIndex(int[] a, int n) {
        for (int i = 0; i < 10; i++) {
            if (a[i] == n) {
                return i;
            }
        }
        // faltando o retorno do vetor.
    }
}
