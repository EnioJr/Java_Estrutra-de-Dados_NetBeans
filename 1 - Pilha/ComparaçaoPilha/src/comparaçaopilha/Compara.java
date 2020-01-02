package comparaçaopilha;
public class Compara {
   
    public void compara(Pilha pilha1,Pilha pilha2 ,Pilha x){
        
        for (int i = pilha1.topo; i >=0 ; i--) {
            if (pilha1.pilha[i] == pilha2.pilha[i]) {
                x.push(true);
            }else{
                x.push(false);
            }
        }        
    }    
}