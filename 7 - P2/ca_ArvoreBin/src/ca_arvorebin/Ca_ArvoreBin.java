package ca_arvorebin;

// Lista GABRIEL MANDO PELO EMAIL ESSE PROGRAMA.
public class Ca_ArvoreBin {

    public static void main(String[] args) {
        
        ArvoreBin arvore = new ArvoreBin();        
        
        arvore.insere(25);
        arvore.insere(31);
        arvore.insere(19);
        arvore.insere(18);
        arvore.insere(0);
        arvore.insere(22);
        arvore.insere(24);
        arvore.insere(8);
        arvore.insere(43);
        arvore.insere(1);
        arvore.insere(17);
        arvore.insere(26);
        
        System.out.println("Em Ordem crescente:");
        arvore.printInOrder();
        System.out.println();       
        
        System.out.println("Em OrdemPre:");
        arvore.printPreOrder();
        System.out.println();
        
        System.out.println("Em OrdemPost:");
        arvore.printPostOrder();
        System.out.println();
        
        
//        System.out.println("Remover: ");
//        arvore.remove(12);
//        arvore.printInOrder();
        
        
    }
}
