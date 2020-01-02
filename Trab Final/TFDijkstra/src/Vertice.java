/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author julia
 */
public class Vertice {
 
    private String bloco;
    private List<Vertice> caminhoMaisCurto = new LinkedList<>();
    private Integer distancia = Integer.MAX_VALUE;
    
    Map<Vertice, Integer> verticesAdjascentes = new HashMap<>();
    
    public Vertice(String bloco) {
        this.bloco = bloco;
    }
    
    public void addDestino(Vertice destino, int distancia) {
        verticesAdjascentes.put(destino, distancia);
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public List<Vertice> getCaminhoMaisCurto() {
        return caminhoMaisCurto;
    }

    public void setCaminhoMaisCurto(List<Vertice> caminhoMaisCurto) {
        this.caminhoMaisCurto = caminhoMaisCurto;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Map<Vertice, Integer> getVerticesAdjascentes() {
        return verticesAdjascentes;
    }

    public void setVerticesAdjascentes(Map<Vertice, Integer> verticesAdjascentes) {
        this.verticesAdjascentes = verticesAdjascentes;
    }
    
    public void resetaVertice() {
        caminhoMaisCurto = new LinkedList<>();
        distancia = Integer.MAX_VALUE;
    }
}
