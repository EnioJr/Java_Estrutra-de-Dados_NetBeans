
package japilhatemplate;

public class JaPilhaTemplate {
    
    public static void main(String[] args) {
        Pilha<Integer> pilhaInt = new Pilha(10);
        Pilha<String> pilhaStr = new Pilha(10);
        
        pilhaInt.push(1);
        pilhaInt.push(2);
        pilhaInt.push(3);
       
        
        pilhaStr.push("valor 1");
        pilhaStr.push("valor 2");
        pilhaStr.push("valor 3");
       
        pilhaStr.imprime();
        pilhaStr.pop();
       
        
        pilhaInt.imprime();
        pilhaStr.imprime();
    }
    
}
