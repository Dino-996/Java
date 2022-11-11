package it.unibas.cesti.vista;

import it.unibas.cesti.Applicazione;
import it.unibas.cesti.modello.Cesto;
import it.unibas.cesti.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }
    
    private void inizializzaComponenti() {
        this.comboTipologia.removeAllItems();
        this.comboTipologia.addItem("");
        this.comboTipologia.addItem(Costanti.CESTO_GRANDE);
        this.comboTipologia.addItem(Costanti.CESTO_MEDIO);
        this.comboTipologia.addItem(Costanti.CESTO_PICCOLO);
        this.tabellaCesti.setModel(new ModelloTabellaCesti());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneSeleziona.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza());
    }
    
    public void inizializzaTabella() {
        List<Cesto> listaFiltrata = (List<Cesto>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaCesti modello = (ModelloTabellaCesti)this.tabellaCesti.getModel();
        modello.setListaCesti(listaFiltrata);
        modello.inizializza();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GruppoOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboTipologia = new javax.swing.JComboBox<>();
        bottoneCerca = new javax.swing.JButton();
        radioPrezzoCrescente = new javax.swing.JRadioButton();
        radioPrezzoDecrescente = new javax.swing.JRadioButton();
        radioNomeCrecsente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaCesti = new javax.swing.JTable();
        bottoneSeleziona = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca cesto"));

        jLabel1.setText("Tipologia:");

        comboTipologia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCerca.setText("jButton1");

        GruppoOrdinamento.add(radioPrezzoCrescente);
        radioPrezzoCrescente.setSelected(true);
        radioPrezzoCrescente.setText("Cerca per prezzo crescente");

        GruppoOrdinamento.add(radioPrezzoDecrescente);
        radioPrezzoDecrescente.setText("Cerca per prezzo decrescente");

        GruppoOrdinamento.add(radioNomeCrecsente);
        radioNomeCrecsente.setText("Cerca per nome crescente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(comboTipologia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bottoneCerca))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(radioPrezzoCrescente)
                .addGap(18, 27, Short.MAX_VALUE)
                .addComponent(radioPrezzoDecrescente)
                .addGap(18, 27, Short.MAX_VALUE)
                .addComponent(radioNomeCrecsente))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboTipologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPrezzoCrescente)
                    .addComponent(radioPrezzoDecrescente)
                    .addComponent(radioNomeCrecsente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaCesti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaCesti);

        bottoneSeleziona.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneSeleziona)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(bottoneSeleziona)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getRigaSelezionata() {
        return this.tabellaCesti.getSelectedRow();
    }

    public String getTipologia() {
        return (String) this.comboTipologia.getSelectedItem();
    }

    public boolean isPrezzoCrescente() {
        return this.radioPrezzoCrescente.isSelected();
    }

    public boolean isPrezzoDecrescente() {
        return this.radioPrezzoDecrescente.isSelected();
    }

    public boolean isNomeCrescente() {
        return this.radioNomeCrecsente.isSelected();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GruppoOrdinamento;
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneSeleziona;
    private javax.swing.JComboBox<String> comboTipologia;
    private javax.swing.JRadioButton radioNomeCrecsente;
    private javax.swing.JRadioButton radioPrezzoCrescente;
    private javax.swing.JRadioButton radioPrezzoDecrescente;
    private javax.swing.JTable tabellaCesti;
    // End of variables declaration//GEN-END:variables
}
