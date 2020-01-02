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
import java.util.ArrayList;
// now we must create graph object and implement dijkstra algorithm

public class Graph {

    private UIDijkstra tfd;
    private int bloco;
    public String nroVertices;
    public String nroArestas;
    public String resultado;

    public void setBloco(int bloco) {
        this.bloco = bloco;
    }

    public void setTfd(UIDijkstra tfd) {
        this.tfd = tfd;
    }
    
    private Node[] nodes;
    private int numeroNodes;
    private Arestas[] arestas;
    private int numeroArestas;

    public Graph(Arestas[] arestas) {
        this.arestas = arestas;
        // create all nodes ready to be updated with the edges
        this.numeroNodes = calculaNumerodeNos(arestas);
        this.nodes = new Node[this.numeroNodes];
        for (int n = 0; n < this.numeroNodes; n++) {
            this.nodes[n] = new Node();
        }
        // add all the edges to the nodes, each edge added to two nodes (to and from)
        
        //add todas as arestas aos nós , cada nó adicionado para 2 nó , 1 de saida e o outro de chegada.
        this.numeroArestas = arestas.length;
        for (int arestaToAdd = 0; arestaToAdd < this.numeroArestas; arestaToAdd++) {
            this.nodes[arestas[arestaToAdd].getIndexNoSaida()].getArestas().add(arestas[arestaToAdd]);
            this.nodes[arestas[arestaToAdd].getIndexNoChegada()].getArestas().add(arestas[arestaToAdd]);
        }
    }

    private int calculaNumerodeNos(Arestas[] edges) {
        int numeroDeNos = 0;
        for (Arestas e : edges) {
            if (e.getIndexNoChegada() > numeroDeNos) {
                numeroDeNos = e.getIndexNoChegada();
            }
            if (e.getIndexNoSaida() > numeroDeNos) {
                numeroDeNos = e.getIndexNoChegada();
            }
        }
        numeroDeNos++;
        return numeroDeNos;
    }
    // next video to implement the Dijkstra algorithm !!!

    public void calculaMenorDistancia() {
        // node 0 as source
        this.nodes[0].setDistanciaPeloInicio(0);
        int nextNode = 0;
        // visit every node
        for (int i = 0; i < this.nodes.length; i++) {
            // loop around the edges of current node
            ArrayList<Arestas> currentNodeArestas = this.nodes[nextNode].getArestas();
            for (int aresta = 0; aresta < currentNodeArestas.size(); aresta++) {
                int VizinhoIndex = currentNodeArestas.get(aresta).getIndexVizinho(nextNode);
                // only if not visited
                if (!this.nodes[VizinhoIndex].isVisited()) {
                    int tentative = this.nodes[nextNode].getDistanciaPeloInicio() + currentNodeArestas.get(aresta).getLength();
                    if (tentative < nodes[VizinhoIndex].getDistanciaPeloInicio()) {
                        nodes[VizinhoIndex].setDistanciaPeloInicio(tentative);
                        
                    }
                }
                
            }
            // all neighbours checked so node visited
            nodes[nextNode].setVisited(true);
            // next node must be with shortest distance
            nextNode = getNoMenorDistancia();
            
        }
    }
    // now we're going to implement this method in next part !

    private int getNoMenorDistancia() {
        int indexNoAArmazenado = 0;
        int distanciaArmazenada = Integer.MAX_VALUE;
        for (int i = 0; i < this.nodes.length; i++) {
            int currentDist = this.nodes[i].getDistanciaPeloInicio();
            if (!this.nodes[i].isVisited() && currentDist < distanciaArmazenada) {
                distanciaArmazenada = currentDist;
                indexNoAArmazenado = i;
            }
        }
        return indexNoAArmazenado;
    }
    // display result

    public void printResult() {
        String strNroVertices = "Numeros de vertices = " + this.numeroNodes;
        String strNroArestas = "Numero de Arestas = " + this.numeroArestas;
        String strResultado;
        String strSoma;
//        for (int i = 0; i < this.nodes.length; i++) {
//            output += ("\nA menor distância do vertice " + tfd.nohsIdx.get(0) + " ao vertice " + tfd.nohsIdx.get(i) + " é " + nodes[i].getDistanciaPeloInicio());
//        }
        strSoma = "A menor distância do vertice " + tfd.nohsIdx.get(0) + " ao vertice " + tfd.nohsIdx.get(bloco) + " é " + nodes[bloco].getDistanciaPeloInicio();
        strResultado = tfd.nohsIdx.get(0) + " a " + tfd.nohsIdx.get(bloco) + " = " + nodes[bloco].getDistanciaPeloInicio();
        
        nroVertices = strNroVertices;
        nroArestas = strNroArestas;
        resultado = strResultado;
        
        System.out.println(strSoma);
    }

    public Node[] getNodes() {
        return nodes;
    }

    public int getNoOfNodes() {
        return numeroNodes;
    }

    public Arestas[] getEdges() {
        return arestas;
    }

    public int getNoOfEdges() {
        return numeroArestas;
    }
}
