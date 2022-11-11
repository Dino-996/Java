package it.unibas.banca.vista;

import it.unibas.banca.Applicazione;
import it.unibas.banca.modello.Conto;
import it.unibas.banca.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.aggiornaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneVisualizza.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneVisualizza());
    }

    public void aggiornaTabella() {
        List<Conto> listaFiltrata = (List<Conto>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaConto modello = (ModelloTabellaConto) this.tabellaConti.getModel();
        modello.setListaConti(listaFiltrata);
        modello.inizializza();
    }

    private void aggiornaComponenti() {
        this.tabellaConti.setModel(new ModelloTabellaConto());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottoniCriterioOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        radioNomeCrescente = new javax.swing.JRadioButton();
        radioDataCrescente = new javax.swing.JRadioButton();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaConti = new javax.swing.JTable();
        bottoneVisualizza = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca conti correnti"));

        bottoniCriterioOrdinamento.add(radioNomeCrescente);
        radioNomeCrescente.setSelected(true);
        radioNomeCrescente.setText("Cerca per nome crescente");

        bottoniCriterioOrdinamento.add(radioDataCrescente);
        radioDataCrescente.setText("Cerca per data crescente");
        radioDataCrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDataCrescenteActionPerformed(evt);
            }
        });

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(radioNomeCrescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(radioDataCrescente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottoneCerca)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNomeCrescente)
                    .addComponent(radioDataCrescente)
                    .addComponent(bottoneCerca)))
        );

        tabellaConti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaConti);

        bottoneVisualizza.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottoneVisualizza)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(bottoneVisualizza)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioDataCrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDataCrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDataCrescenteActionPerformed

    public boolean isRadioDataCrescente() {
        return this.radioDataCrescente.isSelected();
    }

    public boolean isRadioNomeCrescente() {
        return this.radioNomeCrescente.isSelected();
    }

    public int getRigaSelezionata() {
        return this.tabellaConti.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneVisualizza;
    private javax.swing.ButtonGroup bottoniCriterioOrdinamento;
    private javax.swing.JRadioButton radioDataCrescente;
    private javax.swing.JRadioButton radioNomeCrescente;
    private javax.swing.JTable tabellaConti;
    // End of variables declaration//GEN-END:variables
}
