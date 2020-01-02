/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.tfdjkstra;

/**
 *
 * @author enioj
 */
public class Arestas {

    private int indexNoSaida;
    private int indexNoChegada;
    private int length;

    public Arestas(int indexNoSaida, int indexNoChegada, int length) {
        this.indexNoSaida = indexNoSaida;
        this.indexNoChegada = indexNoChegada;
        this.length = length;
    }

    public int getIndexNoSaida() {
        return indexNoSaida;
    }

    public int getIndexNoChegada() {
        return indexNoChegada;
    }


    public int getLength() {
        return length;
    }
    // determines the neighbouring node of a supplied node, based on the two nodes connected by this edge

    // determina os nós proximo a ele , apartir dos nos conectados a ele(nó) pela aresta
    public int getIndexVizinho(int nodeIndex) {
        if (this.indexNoSaida == nodeIndex) {
            return this.indexNoChegada;
        } else {
            return this.indexNoSaida;
        }
    }

}
