package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.tabellaAereomobili.setModel(new ModelloTabellaPrincipale());
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }
    
    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneSeleziona.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona());
    }
    
    private void inizializzaComponenti() {
        this.radioNumeroDecrescente.setText("Ordina per passeggeri decrescente");
        this.radioNumeroCrescente.setText("Ordina per passeggeri crescente");
        this.radioTipologiaCrescente.setText("Ordina per tipologia crescente");
    }
    
    public void aggiornaTabella() {
        List<Aereomobile> listaFiltrata = (List<Aereomobile>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaPrincipale modelloTabellaPrincipale = (ModelloTabellaPrincipale) this.tabellaAereomobili.getModel();
        modelloTabellaPrincipale.setListaFiltrata(listaFiltrata);
        modelloTabellaPrincipale.inizalizzaTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoTesto = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        radioNumeroCrescente = new javax.swing.JRadioButton();
        radioNumeroDecrescente = new javax.swing.JRadioButton();
        radioTipologiaCrescente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAereomobili = new javax.swing.JTable();
        bottoneSeleziona = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca aereomobile"));

        jLabel1.setText("Numero minimo passeggeri:");

        bottoneCerca.setText("jButton1");

        jLabel2.setText("Criterio di ricerca:");

        buttonGroup1.add(radioNumeroCrescente);
        radioNumeroCrescente.setSelected(true);
        radioNumeroCrescente.setText("jRadioButton1");

        buttonGroup1.add(radioNumeroDecrescente);
        radioNumeroDecrescente.setText("jRadioButton2");

        buttonGroup1.add(radioTipologiaCrescente);
        radioTipologiaCrescente.setText("jRadioButton3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTesto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(radioNumeroCrescente)
                        .addGap(18, 18, 18)
                        .addComponent(radioNumeroDecrescente)
                        .addGap(18, 18, 18)
                        .addComponent(radioTipologiaCrescente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(bottoneCerca)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioNumeroCrescente)
                    .addComponent(radioNumeroDecrescente)
                    .addComponent(radioTipologiaCrescente)
                    .addComponent(bottoneCerca))
                .addContainerGap())
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

        bottoneSeleziona.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneSeleziona))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneSeleziona)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getPasseggeri() {
        return this.campoTesto.getText();
    }

    public boolean getPasseggeriCrescente() {
        return this.radioNumeroCrescente.isSelected();
    }

    public boolean getPasseggeriDecrescente() {
        return this.radioNumeroDecrescente.isSelected();
    }

    public boolean getTipologiaCrescente() {
        return this.radioTipologiaCrescente.isSelected();
    }

    public int getRigaSelezionata() {
        return this.tabellaAereomobili.getSelectedRow();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneSeleziona;
    private javax.swing.JTextField campoTesto;
    private javax.swing.JRadioButton radioNumeroCrescente;
    private javax.swing.JRadioButton radioNumeroDecrescente;
    private javax.swing.JRadioButton radioTipologiaCrescente;
    private javax.swing.JTable tabellaAereomobili;
    // End of variables declaration//GEN-END:variables
}
