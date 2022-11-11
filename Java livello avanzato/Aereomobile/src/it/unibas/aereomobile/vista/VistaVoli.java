package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Costanti;
import java.text.DateFormat;

public class VistaVoli extends javax.swing.JDialog {
    
    public VistaVoli(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    
    public void inizializza() {
        this.initComponents();
        this.aggiornaComponenti();
        this.inizializzaAzioni();
    }
    
    public void visualizza() {
        this.aggiornaTabella();
        this.pack();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }
    
    private void aggiornaComponenti() {
        this.tabellaVoli.setModel(new ModelloTabellaVoli());
    }
    
    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getIstance().getControlloVoli().getAzioneAggiungi());
    }
    
    public void aggiornaTabella() {
        Aereomobile aereomobileSelezionato = (Aereomobile) Applicazione.getIstance().getModello().getBean(Costanti.AEREOMOBILE_SELEZIONATO);
        this.labelCodice.setText(aereomobileSelezionato.getCodice());
        this.labelTipologia.setText(aereomobileSelezionato.getTipologia());
        this.labelNumeroPasseggeri.setText(aereomobileSelezionato.getNumeroPasseggeri() + "");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String ultimaManutenzione = df.format(aereomobileSelezionato.getDataUltimaManutenzione().getTime());
        this.labelUltimaManutenzione.setText(ultimaManutenzione);
        ModelloTabellaVoli modello = (ModelloTabellaVoli) this.tabellaVoli.getModel();
        modello.setListaVoli(aereomobileSelezionato.getListaVoli());
        modello.inizializza();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        labelCodice = new javax.swing.JLabel();
        labelNumeroPasseggeri = new javax.swing.JLabel();
        labelTipologia = new javax.swing.JLabel();
        labelUltimaManutenzione = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaVoli = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        campoMinuti = new javax.swing.JTextField();
        campoGiorno = new javax.swing.JTextField();
        campoMese = new javax.swing.JTextField();
        campoAnno = new javax.swing.JTextField();
        campoOre = new javax.swing.JTextField();
        javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoPartenza = new javax.swing.JTextField();
        campoArrivo = new javax.swing.JTextField();
        campoDurataVolo = new javax.swing.JTextField();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Voli");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aereomobile selezionato"));

        jLabel1.setText("Codice:");

        jLabel2.setText("Tipologia:");

        jLabel3.setText("Numero passeggeri:");

        jLabel4.setText("Data ultima manutenzione:");

        labelCodice.setText("jLabel5");

        labelNumeroPasseggeri.setText("jLabel6");

        labelTipologia.setText("jLabel7");

        labelUltimaManutenzione.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCodice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNumeroPasseggeri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTipologia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUltimaManutenzione)
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
                    .addComponent(jLabel4)
                    .addComponent(labelCodice)
                    .addComponent(labelNumeroPasseggeri)
                    .addComponent(labelTipologia)
                    .addComponent(labelUltimaManutenzione))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaVoli.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaVoli);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo volo"));

        jLabel9.setText("Data e ora partenza:");

        jLabel10.setText("Giorno:");

        jLabel11.setText("Mese:");

        jLabel12.setText("Anno:");

        jLabel13.setText("Ore:");

        jLabel14.setText("Minuti:");

        jLabel5.setText("Partenza:");

        jLabel6.setText("Arrivo:");

        jLabel7.setText("Durata del volo:");

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoGiorno)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMese)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoAnno)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoOre)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMinuti)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPartenza)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoArrivo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(campoDurataVolo)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneAggiungi)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(campoMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoOre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(campoPartenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoArrivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDurataVolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneAggiungi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getCampoAnno() {
        return this.campoAnno.getText();
    }
    
    public String getCampoMese() {
        return this.campoMese.getText();
    }
    
    public String getCampoGiorno() {
        return this.campoGiorno.getText();
    }
    
    public String getCampoOre() {
        return this.campoOre.getText();
    }
    
    public String getCampoMinuti() {
        return this.campoMinuti.getText();
    }
    
    public String getCampoPartenza() {
        return this.campoPartenza.getText();
    }
    
    public String getCampoArrivo() {
        return this.campoArrivo.getText();
    }
    
    public String getDurataVolo() {
        return this.campoDurataVolo.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoArrivo;
    private javax.swing.JTextField campoDurataVolo;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMese;
    private javax.swing.JTextField campoMinuti;
    private javax.swing.JTextField campoOre;
    private javax.swing.JTextField campoPartenza;
    private javax.swing.JLabel labelCodice;
    private javax.swing.JLabel labelNumeroPasseggeri;
    private javax.swing.JLabel labelTipologia;
    private javax.swing.JLabel labelUltimaManutenzione;
    private javax.swing.JTable tabellaVoli;
    // End of variables declaration//GEN-END:variables
}
