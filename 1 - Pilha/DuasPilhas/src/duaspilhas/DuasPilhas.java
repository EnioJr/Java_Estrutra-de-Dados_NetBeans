package duaspilhas;

import java.util.Arrays;

// Duas Pilhas com tamanho 10 e sao colocadas em 1 array de 10 posiçoes. Onde pode ser feito o empilhamento das 2.
// Se uma estiver mais cheia que a outra será dado um aviso.

public class DuasPilhas {    
  
    public static void main(String[] args) throws Exception {       
       PilhaDupla p = new PilhaDupla();
       
       p.empilha(PilhaDupla.Pilha.INFERIOR, 1);
       p.empilha(PilhaDupla.Pilha.INFERIOR, 1);
       p.empilha(PilhaDupla.Pilha.SUPERIOR, 2);
       System.out.println(Arrays.toString(p.A));
       System.out.println(p.desempilha(PilhaDupla.Pilha.INFERIOR));
       System.out.println(Arrays.toString(p.A));
    }    
}
