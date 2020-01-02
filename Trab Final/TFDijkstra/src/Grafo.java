import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author julia
 */
public class Grafo {
    
    private Set<Vertice> vertices = new HashSet<>();
    
    public Set<Vertice> getVertices() {
        return vertices;
    }
    
    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }
    
    public static Grafo calculaCaminhoMaisCurto(Grafo grafo, Vertice origem) {
        origem.setDistancia(0);
        
        Set<Vertice> verticesVisitados = new HashSet<>();
        Set<Vertice> verticesNaoVisitados = new HashSet<>();
        
        verticesNaoVisitados.add(origem);
        
        while (verticesNaoVisitados.size() != 0) {
            Vertice verticeAtual = encontraVerticeMenorDistancia(verticesNaoVisitados);
            
            verticesNaoVisitados.remove(verticeAtual);
            for (Map.Entry<Vertice, Integer> parAdjascente : verticeAtual.getVerticesAdjascentes().entrySet()) {
                Vertice verticeAdjascente = parAdjascente.getKey();
                Integer distanciaAresta = parAdjascente.getValue();
                if (!verticesVisitados.contains(verticeAdjascente)) {
                    calculaDistanciaMinima(verticeAdjascente, distanciaAresta, verticeAtual);
                    verticesNaoVisitados.add(verticeAdjascente);
                }
            }
            
            verticesVisitados.add(verticeAtual);
        }
        
        return grafo;
    }
    
    public static Vertice encontraVerticeMenorDistancia(Set<Vertice> verticesNaoVisitados) {
        Vertice verticeMenorDistancia = null;
        int menorDistancia = Integer.MAX_VALUE;
        
        for (Vertice vertice : verticesNaoVisitados) {
            int distanciaVertice = vertice.getDistancia();
            if (distanciaVertice < menorDistancia) {
                menorDistancia = distanciaVertice;
                verticeMenorDistancia = vertice;
            }
        }
        
        return verticeMenorDistancia;
    }
    
    private static void calculaDistanciaMinima(Vertice verticeAnalisado, Integer distanciaAresta, Vertice origem) {
        Integer distanciaOrigem = origem.getDistancia();
        
        if (distanciaOrigem + distanciaAresta < verticeAnalisado.getDistancia()) {
            verticeAnalisado.setDistancia(distanciaOrigem + distanciaAresta);
            LinkedList<Vertice> caminhoMaisCurto = new LinkedList<>(origem.getCaminhoMaisCurto());
            caminhoMaisCurto.add(origem);
            verticeAnalisado.setCaminhoMaisCurto(caminhoMaisCurto);
        }
    }
}
