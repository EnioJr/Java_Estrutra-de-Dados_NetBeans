package ca_arvorebin;

public class ArvoreBin {

    private NohArvore raiz;

    public boolean isEmpty() {
        return raiz == null;
    }

    // insere um novo Noh na árvore
    public void insere(int dado) {
        insere(raiz, dado);
    }

    //insere os nós de forma recursiva
    public void insere(NohArvore node, int dado) {
        if (isEmpty()) {
            raiz = new NohArvore(dado);
        } else {
            if (dado < node.getDado()) {
                if (node.getNohEsquerdo() != null) {
                    insere(node.getNohEsquerdo(), dado);
                } else {
                    node.setNohEsquerdo(new NohArvore(dado));
                }
            } else if (dado > node.getDado()) {
                if (node.getNohDireito() != null) {
                    insere(node.getNohDireito(), dado);
                } else {
                    node.setNohDireito(new NohArvore(dado));
                }
            }
        }
    }

    // imprime a arvore na ordem
    public void printInOrder() {
        if (isEmpty()) {
            System.out.println("Vazia!");
        } else {
            printInOrder(raiz);
        }
    }

    // método recursivo para realizar percurso na ordem
    private void printInOrder(NohArvore node) {
        if (node != null) {
            printInOrder(node.getNohEsquerdo());
            System.out.print(node.getDado() + " ");
            printInOrder(node.getNohDireito());
        }
    }

    public void printPreOrder() {
        if (isEmpty()) {
            System.out.println("Vazia!");
        } else {
            printPreOrder(raiz);
        }
    }

    private void printPreOrder(NohArvore node) {
        if (node != null) {
            printPreOrder(node.getNohDireito());
            System.out.print(node.getDado() + " ");
            printPreOrder(node.getNohEsquerdo());
        }
    }

    public void printPostOrder() {
        if (isEmpty()) {
            System.out.println("Vazia!");
        } else {
            printPreOrder(raiz);
        }
    }

    private void printPostOrder(NohArvore node) {
        if (node != null) {
            printPostOrder(node.getNohEsquerdo());         
            System.out.print(node.getDado() + " ");
        }
    }

}
