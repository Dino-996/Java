package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCercaAereomobili.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneVisualizza.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza());
        this.campoNumeroPasseggeri.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
    }

    private void inizializzaComponenti() {
        this.tabellaAereomobili.setModel(new ModelloTabellaAereomobili());
    }

    public void aggiornaTabella() {
        List<Aereomobile> listaFiltrata = (List<Aereomobile>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaAereomobili modello = (ModelloTabellaAereomobili) this.tabellaAereomobili.getModel();
        modello.setListaAereomobili(listaFiltrata);
        modello.inizializza();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup bottoniOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        radioNumeroPostiCrescente = new javax.swing.JRadioButton();
        radioNumeroPostiDecrescente = new javax.swing.JRadioButton();
        radioTipologiaPostiCrescente = new javax.swing.JRadioButton();
        campoNumeroPasseggeri = new javax.swing.JTextField();
        bottoneCercaAereomobili = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAereomobili = new javax.swing.JTable();
        bottoneVisualizza = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca aereomobili"));

        jLabel1.setText("Numero passeggeri:");

        jLabel2.setText("Criterio ordinamento:");

        bottoniOrdinamento.add(radioNumeroPostiCrescente);
        radioNumeroPostiCrescente.setSelected(true);
        radioNumeroPostiCrescente.setText("Posti crescente");
        radioNumeroPostiCrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumeroPostiCrescenteActionPerformed(evt);
            }
        });

        bottoniOrdinamento.add(radioNumeroPostiDecrescente);
        radioNumeroPostiDecrescente.setText("Posti decrescente");
        radioNumeroPostiDecrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNumeroPostiDecrescenteActionPerformed(evt);
            }
        });

        bottoniOrdinamento.add(radioTipologiaPostiCrescente);
        radioTipologiaPostiCrescente.setText("Tipologia crescente");
        radioTipologiaPostiCrescente.setActionCommand("Tipologia crescente");
        radioTipologiaPostiCrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTipologiaPostiCrescenteActionPerformed(evt);
            }
        });

        bottoneCercaAereomobili.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoNumeroPasseggeri)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneCercaAereomobili))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioNumeroPostiCrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioNumeroPostiDecrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioTipologiaPostiCrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNumeroPasseggeri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCercaAereomobili))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioNumeroPostiCrescente)
                    .addComponent(radioNumeroPostiDecrescente)
                    .addComponent(radioTipologiaPostiCrescente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaAereomobili.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAereomobili);

        bottoneVisualizza.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneVisualizza)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneVisualizza)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioNumeroPostiCrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumeroPostiCrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNumeroPostiCrescenteActionPerformed

    private void radioNumeroPostiDecrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNumeroPostiDecrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNumeroPostiDecrescenteActionPerformed

    private void radioTipologiaPostiCrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTipologiaPostiCrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioTipologiaPostiCrescenteActionPerformed

    public String getNumeroPasseggeri() {
        return this.campoNumeroPasseggeri.getText();
    }

    public int getRigaSelezionata() {
        return this.tabellaAereomobili.getSelectedRow();
    }

    public boolean isPostiCrescente() {
        return this.radioNumeroPostiCrescente.isSelected();
    }

    public boolean isPostiDecrescente() {
        return this.radioNumeroPostiDecrescente.isSelected();
    }

    public boolean isTipologiaCrescente() {
        return this.radioTipologiaPostiCrescente.isSelected();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaAereomobili;
    private javax.swing.JButton bottoneVisualizza;
    private javax.swing.JTextField campoNumeroPasseggeri;
    private javax.swing.JRadioButton radioNumeroPostiCrescente;
    private javax.swing.JRadioButton radioNumeroPostiDecrescente;
    private javax.swing.JRadioButton radioTipologiaPostiCrescente;
    private javax.swing.JTable tabellaAereomobili;
    // End of variables declaration//GEN-END:variables
}
