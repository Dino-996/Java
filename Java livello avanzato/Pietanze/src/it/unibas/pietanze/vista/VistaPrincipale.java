package it.unibas.pietanze.vista;

import it.unibas.pietanze.Applicazione;
import it.unibas.pietanze.modello.Costanti;
import it.unibas.pietanze.modello.Pietanza;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.tabellaPietanze.setModel(new ModelloTabellaPietanze());
        this.aggiornaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
    }

    private void aggiornaComponenti() {
        this.comboCategorie.removeAllItems();
        this.comboCategorie.addItem("");
        this.comboCategorie.addItem(Costanti.CATEGORIA_ANTIPASTO);
        this.comboCategorie.addItem(Costanti.CATEGORIA_PRIMO);
        this.comboCategorie.addItem(Costanti.CATEGORIA_SECONDO);
        this.comboCategorie.addItem(Costanti.CATEGORIA_DESSERT);
    }

    public void aggiornaTabella() {
        List<Pietanza> listaFiltrata = (List<Pietanza>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaPietanze modello = (ModelloTabellaPietanze) this.tabellaPietanze.getModel();
        modello.setListaPietanze(listaFiltrata);
        modello.inizializzaTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboCategorie = new javax.swing.JComboBox<>();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPietanze = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cerca pietanza"));

        jLabel1.setText("Categoria:");

        comboCategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(comboCategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneCerca)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaPietanze.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaPietanze);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getComboCategoria() {
        return (String) this.comboCategorie.getSelectedItem();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaPietanze.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JComboBox<String> comboCategorie;
    private javax.swing.JTable tabellaPietanze;
    // End of variables declaration//GEN-END:variables
}
