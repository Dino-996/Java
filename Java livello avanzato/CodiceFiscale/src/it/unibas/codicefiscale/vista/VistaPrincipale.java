package it.unibas.codicefiscale.vista;

import it.unibas.codicefiscale.Applicazione;
import it.unibas.codicefiscale.modello.Costanti;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }
    
    private void inizializzaComponenti() {
        this.comboSesso.removeAllItems();
        this.comboSesso.addItem("");
        this.comboSesso.addItem(Costanti.SESSO_MASCHIO);
        this.comboSesso.addItem(Costanti.SESSO_FEMMINA);
    }

    public void inizializzaAzioni() {
        this.bottoneCalcola.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCalcolaCodiceFiscale());
        this.campoNome.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCalcolaCodiceFiscale());
        this.campoCognome.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCalcolaCodiceFiscale());
        this.campoAnno.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCalcolaCodiceFiscale());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        campoCognome = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoAnno = new javax.swing.JTextField();
        comboSesso = new javax.swing.JComboBox<>();
        bottoneCalcola = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        campoRisultato = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoCognome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCognomeActionPerformed(evt);
            }
        });

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        campoAnno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAnnoActionPerformed(evt);
            }
        });

        comboSesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCalcola.setText("jButton1");

        jLabel1.setText("Nome:");

        jLabel2.setText("Cognome:");

        jLabel3.setText("Anno di nascita:");

        jLabel4.setText("Sesso:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCognome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoAnno, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSesso, 0, 101, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bottoneCalcola)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCalcola)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoRisultato.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        campoRisultato.setForeground(new java.awt.Color(255, 255, 255));
        campoRisultato.setText("------------------------------------------------------------------------------------------------------------------");
        campoRisultato.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        campoRisultato.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        campoRisultato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(campoRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(campoRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoCognomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCognomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCognomeActionPerformed

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void campoAnnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAnnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAnnoActionPerformed

    public String getCampoAnno() {
        return this.campoAnno.getText();
    }

    public String getCampoNome() {
        return this.campoNome.getText();
    }

    public String getCampoCognome() {
        return this.campoCognome.getText();
    }

    public void setCampoRisultato(String risultato) {
        this.campoRisultato.setText(risultato);
    }

    public String getComboSesso() {
        return (String) this.comboSesso.getSelectedItem();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCalcola;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel campoRisultato;
    private javax.swing.JComboBox<String> comboSesso;
    // End of variables declaration//GEN-END:variables
}
