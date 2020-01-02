
public class Dijkstra {
    
    // Cria todos os vértices
    private Grafo grafo = new Grafo();
    private Vertice Bloco3Q = new Vertice("3Q");
    private Vertice Bloco1E = new Vertice("1E");
    private Vertice Bloco3M = new Vertice("3M");
    private Vertice Bloco1C = new Vertice("1C");
    private Vertice Bloco5R = new Vertice("5R");
    private Vertice Bloco1N = new Vertice("1N");
    private Vertice Bloco1U = new Vertice("1U");
    private Vertice Bloco1F = new Vertice("1F");
    private Vertice[] blocos = {
        Bloco3Q, Bloco1E, Bloco3M, Bloco1C,
        Bloco5R, Bloco1N, Bloco1U, Bloco1F
    };
    
    public Dijkstra() {
        // Liga os vértices uns aos outros
        // Liga nos dois sentidos (B1 -> B2 e B2 -> B1)
        Bloco3Q.addDestino(Bloco1E, 39);
        Bloco3Q.addDestino(Bloco1F, 98);
        Bloco3Q.addDestino(Bloco3M, 42);
        
        Bloco1E.addDestino(Bloco3Q, 39);
        Bloco1E.addDestino(Bloco5R, 80);
        
        Bloco1F.addDestino(Bloco3Q, 98);
        Bloco1F.addDestino(Bloco3M, 25);
        Bloco1F.addDestino(Bloco1N, 50);
        
        Bloco3M.addDestino(Bloco3Q, 42);
        Bloco3M.addDestino(Bloco1C, 15);
        Bloco3M.addDestino(Bloco1N, 35);
        Bloco3M.addDestino(Bloco1F, 25);
        
        Bloco1C.addDestino(Bloco3M, 15);
        Bloco1C.addDestino(Bloco5R, 15);
        
        Bloco5R.addDestino(Bloco1E, 80);
        Bloco5R.addDestino(Bloco1C, 15);
        Bloco5R.addDestino(Bloco1U, 15);
        Bloco5R.addDestino(Bloco1N, 15);
        
        Bloco1U.addDestino(Bloco5R, 15);
        Bloco1U.addDestino(Bloco1N, 35);
        
        Bloco1N.addDestino(Bloco1F, 50);
        Bloco1N.addDestino(Bloco3M, 35);
        Bloco1N.addDestino(Bloco5R, 15);
        Bloco1N.addDestino(Bloco1U, 35);
        
        grafo.addVertice(Bloco3Q);
        grafo.addVertice(Bloco1E);
        grafo.addVertice(Bloco3M);
        grafo.addVertice(Bloco1C);
        grafo.addVertice(Bloco5R);
        grafo.addVertice(Bloco1N);
        grafo.addVertice(Bloco1U);
        grafo.addVertice(Bloco1F);
    }
    
    public Grafo run(Vertice origem) {
        // Inicia um novo grafo e recalcula as distâncias baseadas na nova origem
        for (Vertice v : blocos) {
            v.resetaVertice();
        }
        
        grafo = Grafo.calculaCaminhoMaisCurto(grafo, origem);
        
        return grafo;
    }
    
    public Vertice getBloco(String nome) {
        for (Vertice bloco : blocos) {
            if (bloco.getBloco() == nome) {
                return bloco;
            }
        }
        
        return null;
    }
    
    public Grafo getGrafo() {
        return grafo;
    }
}