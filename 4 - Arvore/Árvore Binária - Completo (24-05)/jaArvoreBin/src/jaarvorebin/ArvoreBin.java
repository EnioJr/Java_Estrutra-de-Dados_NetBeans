/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jaarvorebin;

/**
 *
 * @author EDGARD LAMOUNIER
 */
public class ArvoreBin< T extends Comparable< T >> {
    private NohArvore< T >  RAIZ;
    
    public ArvoreBin() {
        RAIZ = null;
    }
    
    // insere um novo Noh na árvore
    public void insereNoh( T valor ) {
      if( RAIZ == null )
          RAIZ = new NohArvore<>( valor ); // cria o nó raiz
      else
          RAIZ.insere(valor); 
    } // fim do metodo insereNoh
    
    // imprime a arvore na ordem 
    public void inorderTraversal() {
       inorderHelper( RAIZ ); 
    } // fim do metodo inorderTraversal
    
    // método recursivo para realizar percurso na ordem
    private void inorderHelper( NohArvore< T > noh) {
       if( noh == null )
           return;
       
        inorderHelper(noh.getNohEsquerdo());
        System.out.printf( "%s ", noh.getData());
        inorderHelper(noh.getNohDireito());
    } // fim do metodo inorderHelper 
} // fim da classe ArvoreBin
