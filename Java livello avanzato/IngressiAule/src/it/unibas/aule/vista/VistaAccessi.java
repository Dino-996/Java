package it.unibas.aule.vista;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;

public class VistaAccessi extends javax.swing.JDialog {
    
    public VistaAccessi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    
    public void inizializza() {
        this.initComponents();
        this.inizializzaAzioni();
        this.aggiornaComponenti();
    }
    
    public void visualizza() {
        this.pack();
        this.aggiornaTabella();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }
    
    public void aggiornaTabella() {
        Aula aulaSelezionata = (Aula) Applicazione.getIstance().getModello().getBeans(Costanti.AULA_SELEZIONATA);
        this.labelCodice.setText(aulaSelezionata.getCodice());
        this.labelNome.setText(aulaSelezionata.getNome());
        this.labelPiano.setText(aulaSelezionata.getPiano() + "");
        ModelloTabellaAccessi modello = (ModelloTabellaAccessi) this.tabellaAccessi.getModel();
        modello.setListaAccessi(aulaSelezionata.getListaAccessi());
        modello.inizializza();
    }
    
    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getIstance().getControlloAccessi().getAzioneAggiungi());
    }
    
    private void aggiornaComponenti() {
        this.comboCategoria.removeAllItems();
        this.comboCategoria.addItem("");
        this.comboCategoria.addItem(Costanti.ESAME);
        this.comboCategoria.addItem(Costanti.LEZIONE);
        this.comboCategoria.addItem(Costanti.RICEVIMENTO);
        this.tabellaAccessi.setModel(new ModelloTabellaAccessi());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelCodice = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelPiano = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAccessi = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoMatricola = new javax.swing.JTextField();
        campoNomeStudente = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoPermanenza = new javax.swing.JTextField();
        comboCategoria = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        campoGiorno = new javax.swing.JTextField();
        campoMese = new javax.swing.JTextField();
        campoAnno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        campoOre = new javax.swing.JTextField();
        campoMinuti = new javax.swing.JTextField();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Accessi");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aula selezionata"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Piano:");

        jLabel3.setText("Codice:");

        labelCodice.setText("jLabel4");

        labelNome.setText("jLabel4");

        labelPiano.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(labelCodice)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labelNome)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(labelPiano)
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
                    .addComponent(labelCodice)
                    .addComponent(labelNome)
                    .addComponent(labelPiano))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tabellaAccessi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAccessi);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aggiungi accesso"));

        jLabel4.setText("Matricola:");

        jLabel5.setText("Nome studente:");

        jLabel6.setText("Permanenza:");

        jLabel7.setText("Categoria:");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Data e ora");

        jLabel9.setText("Giorno:");

        jLabel10.setText("Mese:");

        jLabel11.setText("Anno:");

        jLabel12.setText("Ore:");

        jLabel13.setText("Minuti");

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMatricola)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(campoPermanenza)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeStudente)
                            .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoGiorno, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMese, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoAnno, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoOre)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(campoMinuti)
                                .addGap(18, 18, 18)
                                .addComponent(bottoneAggiungi)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(campoMatricola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNomeStudente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(campoPermanenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(campoOre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneAggiungi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getGiorno() {
        return this.campoGiorno.getText();
    }
    
    public String getMese() {
        return this.campoMese.getText();
    }
    
    public String getAnno() {
        return this.campoAnno.getText();
    }
    
    public String getOre() {
        return this.campoOre.getText();
    }
    
    public String getMinuti() {
        return this.campoMinuti.getText();
    }
    
    public String getCampoNome() {
        return this.campoNomeStudente.getText();
    }
    
    public String getPermanenza() {
        return this.campoPermanenza.getText();
    }
    
    public String getMatricola() {
        return this.campoMatricola.getText();
    }
    
    public String getComboCategoria() {
        return (String) this.comboCategoria.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMatricola;
    private javax.swing.JTextField campoMese;
    private javax.swing.JTextField campoMinuti;
    private javax.swing.JTextField campoNomeStudente;
    private javax.swing.JTextField campoOre;
    private javax.swing.JTextField campoPermanenza;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel labelCodice;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPiano;
    private javax.swing.JTable tabellaAccessi;
    // End of variables declaration//GEN-END:variables
}
