//Lista duplamente encadeada
package ca_listade;

//Lista MINHA
public class Ca_ListaDE {

    public static void main(String[] args) {
        Lista li = new Lista();

        li.insereFim(1);
        li.insereFim(2);
        li.insereFim(3);   
        li.insereAntes(56, 3);   
        li.insereDepois(9723, 3);
        
        li.remove(2);
        
        li.imprimiDireita();        
        
        li.getQtdeElementos();

        li.insereInicio(10);
        li.insereInicio(20);
        li.insereInicio(30);
        
        li.imprimiDireita();
        li.getQtdeElementos();
        
       
    }
}