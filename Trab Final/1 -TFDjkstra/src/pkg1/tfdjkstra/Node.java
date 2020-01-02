/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.tfdjkstra;

import java.util.ArrayList;

/**
 *
 * @author enioj
 */
public class Node {

    private int distanciaPeloInicio = Integer.MAX_VALUE;
    private boolean visitado;
    private ArrayList<Arestas> arestas = new ArrayList<Arestas>(); // Cria arestas

    public int getDistanciaPeloInicio() {
        return distanciaPeloInicio;
    }

    public void setDistanciaPeloInicio(int distanciaPeloInicio) {
        this.distanciaPeloInicio = distanciaPeloInicio;
    }

    public boolean isVisited() {
        return visitado;
    }

    public void setVisited(boolean visited) {
        this.visitado = visited;
    }

    public ArrayList<Arestas> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Arestas> arestas) {
        this.arestas = arestas;
    }

}
