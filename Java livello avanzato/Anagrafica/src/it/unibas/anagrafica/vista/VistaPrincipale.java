package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.campoTestoCitta.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneSeleziona.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona());
    }

    private void inizializzaComponenti() {
        this.tabellaAziende.setModel(new ModelloTabellaAzienda());
    }

    public void aggiornaTabella() {
        List<Azienda> listaFiltrata = (List<Azienda>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaAzienda modello = (ModelloTabellaAzienda) this.tabellaAziende.getModel();
        modello.setListaAziende(listaFiltrata);
        modello.inizializza();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoTestoCitta = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAziende = new javax.swing.JTable();
        bottoneSeleziona = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca azienda"));

        jLabel1.setText("Citta':");

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTestoCitta, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bottoneCerca))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTestoCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaAziende.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAziende);

        bottoneSeleziona.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneSeleziona)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(bottoneSeleziona)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getCitta() {
        return this.campoTestoCitta.getText();
    }

    public int getRigaSelezionata() {
        return this.tabellaAziende.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneSeleziona;
    private javax.swing.JTextField campoTestoCitta;
    private javax.swing.JTable tabellaAziende;
    // End of variables declaration//GEN-END:variables
}
