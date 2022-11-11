package it.unibas.file.vista;

import it.unibas.file.Applicazione;
import it.unibas.file.modello.Cartella;
import it.unibas.file.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaComponenti() {
        this.tabellaCartelle.setModel(new ModelloTabellaPrincipale());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneVisualizza.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneSeleziona());
        this.campoTestoUtente.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.campoTestoNumeroFile.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
    }

    public void aggiornaTabella() {
        List<Cartella> listaFiltrata = (List<Cartella>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaPrincipale modello = (ModelloTabellaPrincipale) this.tabellaCartelle.getModel();
        modello.setListaCartelle(listaFiltrata);
        modello.inizializza();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        campoTestoUtente = new javax.swing.JTextField();
        campoTestoNumeroFile = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaCartelle = new javax.swing.JTable();
        bottoneVisualizza = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca cartella"));

        jLabel1.setText("Utente:");

        jLabel2.setText("Numero file:");

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(campoTestoUtente)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(campoTestoNumeroFile)
                .addGap(26, 26, 26)
                .addComponent(bottoneCerca)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(campoTestoUtente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTestoNumeroFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        tabellaCartelle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaCartelle);

        bottoneVisualizza.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneVisualizza)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getNumeroFile() {
        return this.campoTestoNumeroFile.getText();
    }

    public String getNomeUtente() {
        return this.campoTestoUtente.getText();
    }

    public int getRigaSelezionata() {
        return this.tabellaCartelle.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneVisualizza;
    private javax.swing.JTextField campoTestoNumeroFile;
    private javax.swing.JTextField campoTestoUtente;
    private javax.swing.JTable tabellaCartelle;
    // End of variables declaration//GEN-END:variables

}
