package it.unibas.concorsi.vista;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {
    
    public void inizializza() {
        this.initComponents();
        this.tabellaConcorsi.setModel(new ModelloTabellaConcorsi());
        this.inizializzaAzioni();
    }
    
    public void aggiornaTabella() {
        List<Concorso> listaFiltrata = (List<Concorso>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaConcorsi modello = (ModelloTabellaConcorsi) this.tabellaConcorsi.getModel();
        modello.setListaConcorsi(listaFiltrata);
        modello.inizializzaTabella();
    }
    
    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.campoTestoRegione.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneVisualizzaDomanda.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizzaDomande());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup bottoniCriterioOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoTestoRegione = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        radioCriterioDataCrescente = new javax.swing.JRadioButton();
        radioCriterioPostiDecrescente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaConcorsi = new javax.swing.JTable();
        bottoneVisualizzaDomanda = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca concorso"));

        jLabel1.setText("Cerca concorso per regione:");

        bottoneCerca.setText("jButton1");

        bottoniCriterioOrdinamento.add(radioCriterioDataCrescente);
        radioCriterioDataCrescente.setText("Cerca per data crescente");
        radioCriterioDataCrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCriterioDataCrescenteActionPerformed(evt);
            }
        });

        bottoniCriterioOrdinamento.add(radioCriterioPostiDecrescente);
        radioCriterioPostiDecrescente.setSelected(true);
        radioCriterioPostiDecrescente.setText("Cerca per numero di posti decrescente");
        radioCriterioPostiDecrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCriterioPostiDecrescenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radioCriterioPostiDecrescente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioCriterioDataCrescente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoTestoRegione)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneCerca))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTestoRegione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCriterioDataCrescente)
                    .addComponent(radioCriterioPostiDecrescente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaConcorsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabellaConcorsi);

        bottoneVisualizzaDomanda.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottoneVisualizzaDomanda)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneVisualizzaDomanda)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioCriterioPostiDecrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCriterioPostiDecrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCriterioPostiDecrescenteActionPerformed

    private void radioCriterioDataCrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCriterioDataCrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCriterioDataCrescenteActionPerformed
    
    public String getCampoRegione() {
        return this.campoTestoRegione.getText();
    }
    
    public boolean getDataCrescente() {
        return this.radioCriterioDataCrescente.isSelected();
    }
    
    public boolean getNumeroPostiDecrescente() {
        return this.radioCriterioPostiDecrescente.isSelected();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaConcorsi.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneVisualizzaDomanda;
    private javax.swing.JTextField campoTestoRegione;
    private javax.swing.JRadioButton radioCriterioDataCrescente;
    private javax.swing.JRadioButton radioCriterioPostiDecrescente;
    private javax.swing.JTable tabellaConcorsi;
    // End of variables declaration//GEN-END:variables
}
