package p1_q1;

public class Pilha<T> extends Object {

    NohPilha topo;

    public Pilha() {
        topo = null;
    }

    public boolean pilhaVazia() {
        return topo == null;
    }

    public void push(T valor) {
        NohPilha novo = new NohPilha();
        novo.setDado(valor);
        novo.setProx(topo);
        topo = novo;
    }

    public T pop() {
        T desempilhado;
        if (pilhaVazia()) {
            System.out.println("Pilha Vazia!");
            desempilhado = null;
        } else {
            desempilhado = (T) topo.getDado();
            topo = topo.getProx();
        }
        return desempilhado;
    }

    public void imprime() {
        if (pilhaVazia()) {
            System.out.println("A pilha esta vazia!");
        } else {
            NohPilha p = topo;
            while (p != null) {
                System.out.println(p.getDado().toString());
                p = p.getProx();
            }
        }
    }

    public int size() {
        NohPilha p = topo;
        int cont = 0;
        while (p != null) {
            p = p.getProx();
            cont++;
        }
        return cont;
    }

    // Trocar peça
    public void trocaPeca(T pecaVelha, T pecaNova) { //poderia passar a posição da velha tbm
        Pilha<T> caixaPecas = new Pilha(); //nova pilha para guardar as peças que serão retiradas até a peça estragada

        while (!this.topo.getDado().equals(pecaVelha)) { //enquanto o dado do topo da pilha do ventilador (this -> atual) não for igual a peça a ser trocada
            caixaPecas.push(this.pop()); //push na pilha de peças e pop na pilha do ventilador
        }
        this.pop(); //descarta peça defeituosa
        caixaPecas.push(pecaNova); //substitui pela nova peça
        //topo.setDado(pecaNova); //em vez das duas linhas acima, pode ser assim tbm
        while (!caixaPecas.pilhaVazia()) { //após trocar a peça, esvaziar a pilha de peças
            this.push(caixaPecas.pop()); //reinsere as peças restantes no ventilador
        }
        System.out.println(pecaVelha + " substituída por " + pecaNova);
    }

}
