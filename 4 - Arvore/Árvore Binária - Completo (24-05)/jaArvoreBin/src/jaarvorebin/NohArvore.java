/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jaarvorebin;

/**
 *
 * @author EDGARD
 * @param <T>
 */
public class NohArvore<T extends Comparable< T >> {
    private NohArvore< T >  nohEsquerdo;
    private T data;
    private NohArvore< T >  nohDireito;
    
    public NohArvore( T dataNoh ){
       data = dataNoh;
       nohEsquerdo = nohDireito = null; 
    } // fim do construtor
    
    // localiza ponto de inserção e insere novo Noh;
    // ignora os valores duplicados
    public void insere( T valor ){
       // insere na subarvore esquerda
        if( valor.compareTo( data ) < 0 ) {
           // insere novo NohArvore
            if (nohEsquerdo == null)
                nohEsquerdo = new NohArvore< T >(valor);
            else // continua percorrendo SAE recursivamente
                nohEsquerdo.insere(valor);
        } // fim do if 
        
        // insere na subarvore direita
        else if ( valor.compareTo( data ) > 0) {
           // insere novo NohArvore
            if( nohDireito == null )
                nohDireito = new NohArvore< T >(valor);
            else // continua percorrendo SAD recursivamente
                nohDireito.insere(valor);
        } // fim do else if 
    } // fim do metodo insert 
            
    
    public NohArvore<T> getNohEsquerdo() {
        return nohEsquerdo;
    }

    public void setNohEsquerdo(NohArvore<T> nohEsquerdo) {
        this.nohEsquerdo = nohEsquerdo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NohArvore<T> getNohDireito() {
        return nohDireito;
    }

    public void setNohDireito(NohArvore<T> nohDireito) {
        this.nohDireito = nohDireito;
    }
    
    
} // fim da classe NohArvore
