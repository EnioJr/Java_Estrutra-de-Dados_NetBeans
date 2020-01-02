package p1_q2;

public class Pilha<T> extends Object {

    NohPilha topo;

    public Pilha() {
        topo = null;
    }

    public boolean pilhaVazia() {
        return topo == null;
    }

    //Letra (c)     Verfica para nao inserir o mesmo elemento na Pilha
    public void push(T valor) {
        NohPilha checagem = this.topo; //var que começa no topo da pilha atual
        
        while(checagem != null){ //enquanto a var faz a checagem não chegar no fim da pilha
            if(checagem.getDado() == valor){ //se o valor que está atualmente no nó atual for igual ao valor do push
                System.out.println("O item " + valor + " já existe na pilha!"); //fala que é igual, já existe
                return; //sai do método (um return mesmo em método void fala pro programa não continuar esse método e sair do mesmo)
            }
            checagem = checagem.getProx(); //incrementa se o valor não for igual
        }
        
        //faz o push normalmente:
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

    //Letra (b)
    public int tamanho() { //size()
        NohPilha p = topo;
        int cont = 0;
        while (p != null) { //enquanto não chegar no fim da pilha atual
            p = p.getProx(); //proximo da pilha
            cont++; //soma o contador
        }
        return cont;
    }
    //OBS.:
    //A letra (b) pedia um método para retornar o tamanho da pilha.
    //Alguns pegaram o projeto que eu havia enviado por email,
    //e nele já existia o método size() que eu havia criado para uma aula e não comentei com vcs.
    //Como foi erro meu, foi considerado tanto criar um novo método quanto simplesmente chamar o size().

    //Letra (a)
    public Pilha inverter() {
        Pilha<T> invertida = new Pilha(); //nova pilha
        NohPilha n = this.topo; //para não precisar criar uma pilha aux, basta percorrer a pilha atual começando pelo topo
        
        while(n != null){ //enquanto não chegar no fim da pilha atual
            invertida.push((T) n.getDado()); //pega o valor no nó atual e da o push na invertida
            n = n.getProx(); //próximo valor
        }
        
        return invertida;
    }
    //OBS.:
    //A letra (a) dizia: Inverter a posição dos elementos de uma pilha p e retornar essa mesma pilha, porém invertida.
    //O ideal seria retornar a mesma pilha na qual está trabalhando, e não uma nova pilha com valores invertidos.
    //Pois assim, caso chame o imprimir() no main, a pilha original não estará invertida, e o ideal seria que esta original
    //estivesse invertida. Porém, como não foi explicado direito, foram consideradas ambas as formas.
    
}


/* public void push(T valor) {                              Funçao que verifica se ja tem um elemento igual na Pilha.
        boolean existe = false;
        
        for (NohPilha n = topo; n != null; n = n.getProx()) {
            if (valor == n.getDado()) {
                System.out.println("Elemento já existente!");
                existe = true;
            }
        }
        
        if (!existe) {
            NohPilha novo = new NohPilha();
            novo.setDado(valor);
            novo.setProx(topo);
            topo = novo;
        }
    } */