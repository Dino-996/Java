package it.unibas.cesti.vista;

import it.unibas.cesti.Applicazione;
import it.unibas.cesti.modello.Cesto;
import it.unibas.cesti.modello.Costanti;

public class VistaProdotto extends javax.swing.JDialog {

    public VistaProdotto(java.awt.Frame parent, boolean modal) {
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

    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getIstance().getControlloProdotto().getAzioneAggiungi());
    }

    private void aggiornaComponenti() {
        this.comboTipologia.removeAllItems();
        this.comboTipologia.addItem("");
        this.comboTipologia.addItem(Costanti.SALUMI);
        this.comboTipologia.addItem(Costanti.DOLCI);
        this.comboTipologia.addItem(Costanti.PASTA);
        this.comboTipologia.addItem(Costanti.BEVANDA);
        this.tabellaProdotti.setModel(new ModelloTabellaProdotti());
    }

    public void aggiornaTabella() {
        Cesto cestoSelezionato = (Cesto) Applicazione.getIstance().getModello().getBean(Costanti.CESTO_SELEZIONATO);
        this.labelNomeCesto.setText(cestoSelezionato.getNome());
        this.labelPrezzoCesto.setText(cestoSelezionato.getPrezzo() + "");
        this.labelTipologiaCesto.setText(cestoSelezionato.getTipologia());
        ModelloTabellaProdotti modello = (ModelloTabellaProdotti) this.tabellaProdotti.getModel();
        modello.setListaProdotti(cestoSelezionato.getListaProdotti());
        modello.inizializza();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        labelNomeCesto = new javax.swing.JLabel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        labelTipologiaCesto = new javax.swing.JLabel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        labelPrezzoCesto = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaProdotti = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        comboTipologia = new javax.swing.JComboBox<>();
        campoPeso = new javax.swing.JTextField();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoGiorno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        campoMese = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoAnno = new javax.swing.JTextField();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cesto selezionato"));

        jLabel8.setText("Nome:");

        labelNomeCesto.setText("jLabel9");

        jLabel9.setText("Tipologia:");

        labelTipologiaCesto.setText("jLabel10");

        jLabel10.setText("Prezzo:");

        labelPrezzoCesto.setText("jLabel11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(labelNomeCesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(labelTipologiaCesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(labelPrezzoCesto)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelNomeCesto)
                    .addComponent(jLabel9)
                    .addComponent(labelTipologiaCesto)
                    .addComponent(jLabel10)
                    .addComponent(labelPrezzoCesto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaProdotti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaProdotti);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipologia:");

        jLabel3.setText("Data scadenza");

        jLabel4.setText("Peso:");

        comboTipologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Giorno:");

        jLabel6.setText("Mese:");

        jLabel7.setText("Anno:");

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipologia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPeso))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoGiorno, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(campoMese, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(campoAnno, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneAggiungi)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneAggiungi))
                .addContainerGap())
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

    public String getComboTipologia() {
        return (String) this.comboTipologia.getSelectedItem();
    }

    public String getCampoPeso() {
        return this.campoPeso.getText();
    }

    public String getCampoNome() {
        return this.campoNome.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMese;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPeso;
    private javax.swing.JComboBox<String> comboTipologia;
    private javax.swing.JLabel labelNomeCesto;
    private javax.swing.JLabel labelPrezzoCesto;
    private javax.swing.JLabel labelTipologiaCesto;
    private javax.swing.JTable tabellaProdotti;
    // End of variables declaration//GEN-END:variables
}
