package it.unibas.file.vista;

import it.unibas.file.Applicazione;
import it.unibas.file.modello.Cartella;
import it.unibas.file.modello.Costanti;
import java.text.DateFormat;

public class VistaFile extends javax.swing.JDialog {

    public VistaFile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public void inizializza() {
        this.initComponents();
        this.aggiornaComponenti();
        this.inizializzaAzioni();
    }

    public void visualiazza() {
        this.aggiornaTabella();
        this.pack();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    public void aggiornaTabella() {
        Cartella cartellaSelezionata = (Cartella) Applicazione.getIstance().getModello().getBean(Costanti.CARTELLA_SELEZIONATA);
        this.labelNomeCreatore.setText(cartellaSelezionata.getNomeCreatore());
        this.labelPercorsoFile.setText(cartellaSelezionata.getPercorso());
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        this.labelDataCreazione.setText(df.format(cartellaSelezionata.getDataCreazione().getTime()));
        ModelloTabellaFile modello = (ModelloTabellaFile) this.tabellaFile.getModel();
        modello.setListaFile(cartellaSelezionata.getListaFile());
        modello.inizializza();
    }

    private void aggiornaComponenti() {
        this.tabellaFile.setModel(new ModelloTabellaFile());
    }

    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getIstance().getControlloFile().getAzioneAggiungi());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelPercorsoFile = new javax.swing.JLabel();
        labelNomeCreatore = new javax.swing.JLabel();
        labelDataCreazione = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaFile = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoNomeFile = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoEstensione = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoMese = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        campoGiorno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        campoAnno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        campoOre = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        campoMinuti = new javax.swing.JTextField();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cartella selezionata"));

        jLabel1.setText("Percorso file:");

        jLabel2.setText("Data creazione:");

        jLabel3.setText("Nome creatore:");

        labelPercorsoFile.setText("jLabel4");

        labelNomeCreatore.setText("jLabel5");

        labelDataCreazione.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPercorsoFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(labelNomeCreatore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(labelDataCreazione)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(labelPercorsoFile)
                    .addComponent(labelNomeCreatore)
                    .addComponent(labelDataCreazione))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tabellaFile.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaFile);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo file"));

        jLabel4.setText("Nome:");

        jLabel5.setText("Dimensione:");

        jLabel6.setText("Data creazione");

        jLabel7.setText("Giorno:");

        jLabel8.setText("Mese:");

        jLabel9.setText("Anno:");

        jLabel10.setText("Ore:");

        campoOre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoOreActionPerformed(evt);
            }
        });

        jLabel11.setText("Minuti:");

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(campoNomeFile)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(campoEstensione)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneAggiungi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoGiorno)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(campoMese)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(campoAnno)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(campoOre)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(campoMinuti)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoEstensione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(campoNomeFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(bottoneAggiungi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoOre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(campoMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoOreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoOreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoOreActionPerformed

    public String getNome() {
        return this.campoNomeFile.getText();
    }

    public String getEstensione() {
        return this.campoEstensione.getText();
    }

    public String getGiorno() {
        return this.campoGiorno.getText();
    }

    public String getMese() {
        return this.campoMese.getText();
    }

    public String getAnno() {
        return this.campoAnno.getText();
    }

    public String getOra() {
        return this.campoOre.getText();
    }

    public String getMinuti() {
        return this.campoMinuti.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoEstensione;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMese;
    private javax.swing.JTextField campoMinuti;
    private javax.swing.JTextField campoNomeFile;
    private javax.swing.JTextField campoOre;
    private javax.swing.JLabel labelDataCreazione;
    private javax.swing.JLabel labelNomeCreatore;
    private javax.swing.JLabel labelPercorsoFile;
    private javax.swing.JTable tabellaFile;
    // End of variables declaration//GEN-END:variables
}
