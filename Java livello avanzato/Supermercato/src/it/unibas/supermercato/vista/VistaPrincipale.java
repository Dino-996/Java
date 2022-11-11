package it.unibas.supermercato.vista;

import it.unibas.supermercato.Applicazione;
import it.unibas.supermercato.modello.Costanti;
import it.unibas.supermercato.modello.Supermercato;
import java.awt.Font;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.inizializzaComponenti();
        this.inizializzaAzioni();
    }

    private void inizializzaComponenti() {
        this.comboCitta.removeAllItems();
        this.comboCitta.addItem("");
        this.comboCitta.addItem(Costanti.CITTA_POTENZA);
        this.comboCitta.addItem(Costanti.CITTA_MATERA);
        this.comboCittaInserimento.removeAllItems();
        this.comboCittaInserimento.addItem("");
        this.comboCittaInserimento.addItem(Costanti.CITTA_POTENZA);
        this.comboCittaInserimento.addItem(Costanti.CITTA_MATERA);
        this.comboSupermercatoInserimento.removeAllItems();
        this.comboSupermercatoInserimento.addItem("");
        this.comboSupermercatoInserimento.addItem(Costanti.SUPERMERCATO_CONAD);
        this.comboSupermercatoInserimento.addItem(Costanti.SUPERMERCATO_COOP);
        this.comboSupermercatoInserimento.addItem(Costanti.SUPERMERCATO_IPERFUTURA);
        this.comboSupermercatoInserimento.addItem(Costanti.SUPERMERCATO_MD);
        this.comboSupermercatoInserimento.addItem(Costanti.SUPERMERCATO_QUI_DISCOUNT);
        this.tabellaSupermercati.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        this.tabellaSupermercati.setModel(new ModelloTabellaSupermercati());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.campoTestoIndirizzo.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.campoCivico.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneAggiungiSupermercato.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneAggiungi());
        this.CampoNomeIndirizzoInserimento.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneAggiungi());
        this.campoCivicoInserimento.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneAggiungi());  
        this.bottoneVisualizza.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza());
    }

    public void aggiornaTabella() {
        List<Supermercato> listaFiltrata = (List<Supermercato>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaSupermercati modello = (ModelloTabellaSupermercati) this.tabellaSupermercati.getModel();
        modello.setListaSupermercati(listaFiltrata);
        modello.inizializza();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup gruppoBottoniOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        campoTestoIndirizzo = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        comboCitta = new javax.swing.JComboBox<>();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        radioNomeCrescente = new javax.swing.JRadioButton();
        radioNomeDecrescente = new javax.swing.JRadioButton();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        radioProdottiDecrescente = new javax.swing.JRadioButton();
        radioProdottiCrescente = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        campoCivico = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaSupermercati = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        bottoneAggiungiSupermercato = new javax.swing.JButton();
        campoCivicoInserimento = new javax.swing.JTextField();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        CampoNomeIndirizzoInserimento = new javax.swing.JTextField();
        comboCittaInserimento = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        comboSupermercatoInserimento = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel15 = new javax.swing.JLabel();
        bottoneVisualizza = new javax.swing.JButton();
        javax.swing.JSeparator jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Il bello e' prenderci gusto");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Ordina dai tuoi supermercati preferiti");

        campoTestoIndirizzo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        campoTestoIndirizzo.setForeground(new java.awt.Color(51, 51, 51));
        campoTestoIndirizzo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoTestoIndirizzo.setToolTipText("Indirizzo di consegna");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel4.setText("Citta:");

        comboCitta.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        comboCitta.setForeground(new java.awt.Color(51, 51, 51));
        comboCitta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel5.setText("Filtra per:");

        gruppoBottoniOrdinamento.add(radioNomeCrescente);
        radioNomeCrescente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        radioNomeCrescente.setSelected(true);
        radioNomeCrescente.setText("Nome crescente");
        radioNomeCrescente.setToolTipText("");

        gruppoBottoniOrdinamento.add(radioNomeDecrescente);
        radioNomeDecrescente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        radioNomeDecrescente.setText("Nome decrescente");

        bottoneCerca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        bottoneCerca.setText("jButton1");

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 36)); // NOI18N
        jLabel10.setText("GOSuper");

        gruppoBottoniOrdinamento.add(radioProdottiDecrescente);
        radioProdottiDecrescente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        radioProdottiDecrescente.setText("Prodotti decrescenti");
        radioProdottiDecrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioProdottiDecrescenteActionPerformed(evt);
            }
        });

        gruppoBottoniOrdinamento.add(radioProdottiCrescente);
        radioProdottiCrescente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        radioProdottiCrescente.setText("Prodotti crescenti");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel11.setText("Indirizzo di consegna:");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel12.setText("Civico:");

        campoCivico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        campoCivico.setForeground(new java.awt.Color(51, 51, 51));
        campoCivico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCivico.setToolTipText("Indirizzo di consegna");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioNomeCrescente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioNomeDecrescente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioProdottiCrescente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioProdottiDecrescente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                .addComponent(bottoneCerca)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoTestoIndirizzo)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCivico, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTestoIndirizzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(campoCivico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioNomeCrescente)
                    .addComponent(radioNomeDecrescente)
                    .addComponent(bottoneCerca)
                    .addComponent(radioProdottiDecrescente)
                    .addComponent(radioProdottiCrescente))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabellaSupermercati.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tabellaSupermercati.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tabellaSupermercati.setModel(new javax.swing.table.DefaultTableModel(
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
        tabellaSupermercati.setSelectionBackground(new java.awt.Color(51, 153, 255));
        tabellaSupermercati.setShowGrid(true);
        jScrollPane1.setViewportView(tabellaSupermercati);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Non trovi nessun supermercato nella tua area?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 13))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setText("Compila il forum qui sotto e ti aggiorneremo su disponibilita' future");

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel8.setText("Citta':");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel9.setText("Indirizzo:");

        bottoneAggiungiSupermercato.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        bottoneAggiungiSupermercato.setText("jButton1");

        campoCivicoInserimento.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        campoCivicoInserimento.setForeground(new java.awt.Color(51, 51, 51));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel13.setText("Civico:");

        CampoNomeIndirizzoInserimento.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        CampoNomeIndirizzoInserimento.setForeground(new java.awt.Color(51, 51, 51));

        comboCittaInserimento.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        comboCittaInserimento.setForeground(new java.awt.Color(51, 51, 51));
        comboCittaInserimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel14.setText("Supermercato:");

        comboSupermercatoInserimento.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        comboSupermercatoInserimento.setForeground(new java.awt.Color(51, 51, 51));
        comboSupermercatoInserimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCittaInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSupermercatoInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoNomeIndirizzoInserimento)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(campoCivicoInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneAggiungiSupermercato)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bottoneAggiungiSupermercato)
                        .addComponent(campoCivicoInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(CampoNomeIndirizzoInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(comboCittaInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(comboSupermercatoInserimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel15.setText("Seleziona un supermercato dalla lista e clicca su \"visualizza prodotti\" per proseguire con i tuoi acquisti:");

        bottoneVisualizza.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        bottoneVisualizza.setText("jButton1");

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottoneVisualizza)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(bottoneVisualizza))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioProdottiDecrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioProdottiDecrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioProdottiDecrescenteActionPerformed

    //GET DI AZIONE CARICA
    public String getComboCitta() {
        return (String) this.comboCitta.getSelectedItem();
    }

    public String getCampoIndirizzo() {
        return this.campoTestoIndirizzo.getText().toUpperCase().trim();
    }

    public String getCivico() {
        return this.campoCivico.getText().trim();
    }

    public boolean isNomeCrescente() {
        return this.radioNomeCrescente.isSelected();
    }

    public boolean isNomeDecrescente() {
        return this.radioNomeDecrescente.isSelected();
    }

    public boolean isProdottiCrescente() {
        return this.radioProdottiCrescente.isSelected();
    }

    public boolean isProdottiDecerescente() {
        return this.radioProdottiDecrescente.isSelected();
    }

    //GET DI AZIONE AGGIUNGI
    public String getCampoIndirizzoInserimento() {
        return this.CampoNomeIndirizzoInserimento.getText().trim();
    }

    public String getComboCittaInserimento() {
        return (String) this.comboCittaInserimento.getSelectedItem();
    }

    public String getCampoCivicoInserimento() {
        return this.campoCivicoInserimento.getText().trim();
    }

    public String getComboSupermercatoInserimento() {
        return (String) this.comboSupermercatoInserimento.getSelectedItem();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaSupermercati.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoNomeIndirizzoInserimento;
    private javax.swing.JButton bottoneAggiungiSupermercato;
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneVisualizza;
    private javax.swing.JTextField campoCivico;
    private javax.swing.JTextField campoCivicoInserimento;
    private javax.swing.JTextField campoTestoIndirizzo;
    private javax.swing.JComboBox<String> comboCitta;
    private javax.swing.JComboBox<String> comboCittaInserimento;
    private javax.swing.JComboBox<String> comboSupermercatoInserimento;
    private javax.swing.JRadioButton radioNomeCrescente;
    private javax.swing.JRadioButton radioNomeDecrescente;
    private javax.swing.JRadioButton radioProdottiCrescente;
    private javax.swing.JRadioButton radioProdottiDecrescente;
    private javax.swing.JTable tabellaSupermercati;
    // End of variables declaration//GEN-END:variables
}
