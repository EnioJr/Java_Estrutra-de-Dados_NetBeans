
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julia
 */
public class TFDijkstra extends javax.swing.JFrame {
    
    mxGraph grafo = new mxGraph();
    mxGraphComponent componenteGrafo;
    Dijkstra d = new Dijkstra();

    /**
     * Creates new form TFDijkstra
     */
    public TFDijkstra() {
        initComponents();
        criaGrafo();
    }
    
    private void criaGrafo() {
        Object parent = grafo.getDefaultParent();
        Set<Vertice> vertices = d.getGrafo().getVertices();
        Integer[] posicoesX = {30, 250, 400, 380, 200, 10, 150, 300};
        Integer[] posicoesY = {60, 20, 80, 250, 300, 180, 110, 180};
        
        grafo.getModel().beginUpdate();
        
        try {
            int WIDTH = 100, HEIGHT = 50;
            String style="strokeColor=blue;fillColor=#66d9ff";
            
            int i = 0;
            for (Vertice v : vertices) {
                // seta a ID do vértice como sendo o nome do bloco e exibe o nome do bloco no grafo
                grafo.insertVertex(parent, v.getBloco(), v.getBloco(), posicoesX[i], posicoesY[i], WIDTH, HEIGHT, style);
                i++;
            }
            
            Object[] verticesInseridos = grafo.getChildCells(parent);
            for (Vertice v : vertices) {
                Object origem = null, destino = null;
                
                for (Vertice a : v.getVerticesAdjascentes().keySet()) {
                    String id = v.getBloco() + "-" + a.getBloco();
                    String dist = v.getVerticesAdjascentes().get(a).toString();
                    
                    for (Object c : verticesInseridos) {
                        mxCell cell = (mxCell)c;
                        
                        if (cell.getId().equals(v.getBloco())) {
                            origem = cell;
                        }
                        
                        if (cell.getId().equals(a.getBloco())) {
                            destino = cell;
                        }
                    }
                    
                    // insere arestas com o id B1-B2 e mostra a distância como nome da aresta                   
                    grafo.insertEdge(parent, id, dist, origem, destino, style);
                }
            }
        } finally {
            grafo.getModel().endUpdate();
        }
        
        // insere grafo na tela
        componenteGrafo = new mxGraphComponent(grafo);
        componenteGrafo.setSize(550, 380);
        panelGrafo.add(componenteGrafo);
    }
    
    private void atualizaGrafo(Vertice origem, Vertice destino, List<Vertice> caminho) {
        Object parent = grafo.getDefaultParent();
        Object[] cells = grafo.getChildCells(parent);
        List<String> blocosCaminho = new LinkedList<>();
        List<String> arestasCaminho = new LinkedList<>();
        
        // gera a lista de blocos que indicam o caminho e devem ficar vermelhos
        if (!caminho.contains(origem)) { blocosCaminho.add(origem.getBloco()); }
        for (Vertice v : caminho) {
            blocosCaminho.add(v.getBloco());
        }
        if (!caminho.contains(destino)) { blocosCaminho.add(destino.getBloco()); }
        
        // gera a lista de arestas que indicam o caminho e devem ficar vermelhas
        String idAresta = origem.getBloco();
        for (String b : blocosCaminho) {
            idAresta += "-" + b;
            arestasCaminho.add(idAresta);
            // Comente a linha seguinte se quiser fazer o caminho ficar vermelho
            // apenas na direção origem->destino
            // atual bidirecional: origem->destino e destino->origem (para melhor visualização)
            arestasCaminho.add(idAresta.split("-")[1]+"-"+idAresta.split("-")[0]);
            idAresta = b;
        }
        
        grafo.getModel().beginUpdate();
        
        for (Object c : cells) {
            mxCell cell = (mxCell)c;
            
            // reseta cada item do grafo para a cor original
            cell.setStyle("strokeColor=blue;fillColor=#66d9ff");

            // seta para vermelho a cor do item que está no caminho
            if (cell.isVertex() && blocosCaminho.contains(cell.getId())) {
                cell.setStyle("strokeColor=red;fillColor=#ff6666");
            }
            
            if (cell.isEdge() && arestasCaminho.contains(cell.getId())) {
                cell.setStyle("strokeColor=red;fillColor=#ff6666");
            }
        }
        
        grafo.getModel().endUpdate();
        componenteGrafo.refresh();
    }
    
    private void atualizaDistancia(Integer distancia) {
        lblDistancia.setText(distancia.toString());
    }
    
    private void mostraRotaMaisCurta(Vertice origem, Vertice destino) {
        Grafo g;
        List<Vertice> caminhoMaisCurto;
        
        // calcula os caminhos baseados na nova origem
        g = d.run(origem);
        caminhoMaisCurto = destino.getCaminhoMaisCurto();
        
        atualizaGrafo(origem, destino, caminhoMaisCurto);
        atualizaDistancia(destino.getDistancia());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        panelOrigem = new javax.swing.JPanel();
        lblOrigem = new javax.swing.JLabel();
        rbOrigem3Q = new javax.swing.JRadioButton();
        rbOrigem1E = new javax.swing.JRadioButton();
        rbOrigem1C = new javax.swing.JRadioButton();
        rbOrigem3M = new javax.swing.JRadioButton();
        rbOrigem5R = new javax.swing.JRadioButton();
        rbOrigem1N = new javax.swing.JRadioButton();
        rbOrigem1U = new javax.swing.JRadioButton();
        rbOrigem1F = new javax.swing.JRadioButton();
        panelDestino = new javax.swing.JPanel();
        lblDestino = new javax.swing.JLabel();
        rbDestino3Q = new javax.swing.JRadioButton();
        rbDestino1E = new javax.swing.JRadioButton();
        rbDestino1C = new javax.swing.JRadioButton();
        rbDestino3M = new javax.swing.JRadioButton();
        rbDestino5R = new javax.swing.JRadioButton();
        rbDestino1N = new javax.swing.JRadioButton();
        rbDestino1U = new javax.swing.JRadioButton();
        rbDestino1F = new javax.swing.JRadioButton();
        btnCalcular = new javax.swing.JButton();
        panelGrafo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDistancia = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blocos UFU - Dijkstra");

        panelOrigem.setPreferredSize(new java.awt.Dimension(200, 45));

        lblOrigem.setText("Escolha o bloco de origem");
        lblOrigem.setName("lblOrigem"); // NOI18N

        buttonGroup1.add(rbOrigem3Q);
        rbOrigem3Q.setText("3Q");
        rbOrigem3Q.setName("btnOrigem3Q"); // NOI18N

        buttonGroup1.add(rbOrigem1E);
        rbOrigem1E.setText("1E");
        rbOrigem1E.setName("btnOrigem1E"); // NOI18N

        buttonGroup1.add(rbOrigem1C);
        rbOrigem1C.setText("1C");
        rbOrigem1C.setName("btnOrigem1C"); // NOI18N

        buttonGroup1.add(rbOrigem3M);
        rbOrigem3M.setText("3M");
        rbOrigem3M.setName("btnOrigem3M"); // NOI18N

        buttonGroup1.add(rbOrigem5R);
        rbOrigem5R.setText("5R");

        buttonGroup1.add(rbOrigem1N);
        rbOrigem1N.setText("1N");

        buttonGroup1.add(rbOrigem1U);
        rbOrigem1U.setText("1U");

        buttonGroup1.add(rbOrigem1F);
        rbOrigem1F.setText("1F");

        javax.swing.GroupLayout panelOrigemLayout = new javax.swing.GroupLayout(panelOrigem);
        panelOrigem.setLayout(panelOrigemLayout);
        panelOrigemLayout.setHorizontalGroup(
            panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrigemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrigem)
                    .addGroup(panelOrigemLayout.createSequentialGroup()
                        .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOrigemLayout.createSequentialGroup()
                                .addComponent(rbOrigem3Q)
                                .addGap(24, 24, 24)
                                .addComponent(rbOrigem1E))
                            .addGroup(panelOrigemLayout.createSequentialGroup()
                                .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbOrigem3M)
                                    .addComponent(rbOrigem1U))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbOrigem1F)
                                    .addComponent(rbOrigem5R))))
                        .addGap(18, 18, 18)
                        .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbOrigem1C)
                            .addComponent(rbOrigem1N))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelOrigemLayout.setVerticalGroup(
            panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrigemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOrigem)
                .addGap(18, 18, 18)
                .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOrigem3Q)
                    .addComponent(rbOrigem1E)
                    .addComponent(rbOrigem1C))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOrigem3M)
                    .addComponent(rbOrigem5R)
                    .addComponent(rbOrigem1N))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOrigemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOrigem1U)
                    .addComponent(rbOrigem1F))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        panelDestino.setPreferredSize(new java.awt.Dimension(200, 45));

        lblDestino.setText("Escolha o bloco de destino");
        lblDestino.setName("lblOrigem"); // NOI18N

        buttonGroup2.add(rbDestino3Q);
        rbDestino3Q.setText("3Q");
        rbDestino3Q.setName("btnOrigem3Q"); // NOI18N

        buttonGroup2.add(rbDestino1E);
        rbDestino1E.setText("1E");
        rbDestino1E.setName("btnOrigem1E"); // NOI18N

        buttonGroup2.add(rbDestino1C);
        rbDestino1C.setText("1C");
        rbDestino1C.setName("btnOrigem1C"); // NOI18N

        buttonGroup2.add(rbDestino3M);
        rbDestino3M.setText("3M");
        rbDestino3M.setName("btnOrigem3M"); // NOI18N

        buttonGroup2.add(rbDestino5R);
        rbDestino5R.setText("5R");

        buttonGroup2.add(rbDestino1N);
        rbDestino1N.setText("1N");

        buttonGroup2.add(rbDestino1U);
        rbDestino1U.setText("1U");

        buttonGroup2.add(rbDestino1F);
        rbDestino1F.setText("1F");

        javax.swing.GroupLayout panelDestinoLayout = new javax.swing.GroupLayout(panelDestino);
        panelDestino.setLayout(panelDestinoLayout);
        panelDestinoLayout.setHorizontalGroup(
            panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDestino)
                    .addGroup(panelDestinoLayout.createSequentialGroup()
                        .addGroup(panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelDestinoLayout.createSequentialGroup()
                                .addComponent(rbDestino1U)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbDestino1F))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDestinoLayout.createSequentialGroup()
                                .addComponent(rbDestino3M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbDestino5R))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDestinoLayout.createSequentialGroup()
                                .addComponent(rbDestino3Q)
                                .addGap(24, 24, 24)
                                .addComponent(rbDestino1E)))
                        .addGap(18, 18, 18)
                        .addGroup(panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDestino1C)
                            .addComponent(rbDestino1N))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelDestinoLayout.setVerticalGroup(
            panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDestino)
                .addGap(18, 18, 18)
                .addGroup(panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDestino3Q)
                    .addComponent(rbDestino1E)
                    .addComponent(rbDestino1C))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDestino3M)
                    .addComponent(rbDestino5R)
                    .addComponent(rbDestino1N))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDestino1U)
                    .addComponent(rbDestino1F))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnCalcular.setText("Calcular Menor Rota");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        panelGrafo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout panelGrafoLayout = new javax.swing.GroupLayout(panelGrafo);
        panelGrafo.setLayout(panelGrafoLayout);
        panelGrafoLayout.setHorizontalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        panelGrafoLayout.setVerticalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Menor distância:");

        lblDistancia.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDistancia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCalcular)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDistancia))
                .addGap(0, 12, Short.MAX_VALUE))
            .addComponent(panelGrafo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setActionCommandsToRadioButtons() {
        rbOrigem3Q.setActionCommand("3Q");
        rbOrigem1C.setActionCommand("1C");
        rbOrigem1E.setActionCommand("1E");
        rbOrigem1N.setActionCommand("1N");
        rbOrigem1U.setActionCommand("1U");
        rbOrigem3M.setActionCommand("3M");
        rbOrigem5R.setActionCommand("5R");
        rbOrigem1F.setActionCommand("1F");
        
        rbDestino3Q.setActionCommand("3Q");
        rbDestino1C.setActionCommand("1C");
        rbDestino1E.setActionCommand("1E");
        rbDestino1N.setActionCommand("1N");
        rbDestino1U.setActionCommand("1U");
        rbDestino3M.setActionCommand("3M");
        rbDestino5R.setActionCommand("5R");
        rbDestino1F.setActionCommand("1F");
    }
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        setActionCommandsToRadioButtons();
        
        // identifica a origem e o destino selecionados para calcular o caminho
        String origemSelecionada = buttonGroup1.getSelection().getActionCommand();
        String destinoSelecionado = buttonGroup2.getSelection().getActionCommand();
        
        Vertice origem = d.getBloco(origemSelecionada);
        Vertice destino = d.getBloco(destinoSelecionado);
        
        mostraRotaMaisCurta(origem, destino);
    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TFDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TFDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TFDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TFDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TFDijkstra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDistancia;
    private javax.swing.JLabel lblOrigem;
    private javax.swing.JPanel panelDestino;
    private javax.swing.JPanel panelGrafo;
    private javax.swing.JPanel panelOrigem;
    private javax.swing.JRadioButton rbDestino1C;
    private javax.swing.JRadioButton rbDestino1E;
    private javax.swing.JRadioButton rbDestino1F;
    private javax.swing.JRadioButton rbDestino1N;
    private javax.swing.JRadioButton rbDestino1U;
    private javax.swing.JRadioButton rbDestino3M;
    private javax.swing.JRadioButton rbDestino3Q;
    private javax.swing.JRadioButton rbDestino5R;
    private javax.swing.JRadioButton rbOrigem1C;
    private javax.swing.JRadioButton rbOrigem1E;
    private javax.swing.JRadioButton rbOrigem1F;
    private javax.swing.JRadioButton rbOrigem1N;
    private javax.swing.JRadioButton rbOrigem1U;
    private javax.swing.JRadioButton rbOrigem3M;
    private javax.swing.JRadioButton rbOrigem3Q;
    private javax.swing.JRadioButton rbOrigem5R;
    // End of variables declaration//GEN-END:variables
}
