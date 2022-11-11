package it.unibas.mastermind.vista;

import it.unibas.mastermind.Applicazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.Partita;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        numeroUno.setModel(new javax.swing.SpinnerNumberModel(1, 1, Costanti.CIFRA_MASSIMA, 1));
        numeroDue.setModel(new javax.swing.SpinnerNumberModel(1, 1, Costanti.CIFRA_MASSIMA, 1));
        numeroTre.setModel(new javax.swing.SpinnerNumberModel(1, 1, Costanti.CIFRA_MASSIMA, 1));
        numeroQuattro.setModel(new javax.swing.SpinnerNumberModel(1, 1, Costanti.CIFRA_MASSIMA, 1));
        ModelloTabellaRisposte risposte = new ModelloTabellaRisposte();
        this.tabellaRisultati.setModel(risposte);
        this.inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneTentativo.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneTentativo());
    }
    
    public void aggioranDati() {
    Partita partita = (Partita) Applicazione.getIstance().getModello().getBean(Costanti.PARTITA);
    ModelloTabellaRisposte modello = (ModelloTabellaRisposte) this.tabellaRisultati.getModel();
    modello.setRisposta(partita.getListaRisposte());
    modello.inizializzaTabella();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        numeroUno = new javax.swing.JSpinner();
        numeroDue = new javax.swing.JSpinner();
        numeroTre = new javax.swing.JSpinner();
        numeroQuattro = new javax.swing.JSpinner();
        bottoneTentativo = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaRisultati = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tentativo"));

        numeroUno.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        numeroDue.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        numeroTre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        numeroQuattro.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        bottoneTentativo.setText("Tentativo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numeroUno)
                .addGap(18, 18, 18)
                .addComponent(numeroDue)
                .addGap(18, 18, 18)
                .addComponent(numeroTre)
                .addGap(18, 18, 18)
                .addComponent(numeroQuattro)
                .addGap(18, 18, 18)
                .addComponent(bottoneTentativo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroTre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroQuattro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneTentativo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabellaRisultati.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaRisultati);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public Integer getCifraUno() {
        return (Integer) this.numeroUno.getValue();
    }
    
    public Integer getCifraDue() {
        return (Integer) this.numeroDue.getValue();
    }
    
    public Integer getCifraTre() {
        return (Integer) this.numeroTre.getValue();
    }
    
    public Integer getCifraQuattro() {
        return (Integer) this.numeroQuattro.getValue();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneTentativo;
    private javax.swing.JSpinner numeroDue;
    private javax.swing.JSpinner numeroQuattro;
    private javax.swing.JSpinner numeroTre;
    private javax.swing.JSpinner numeroUno;
    private javax.swing.JTable tabellaRisultati;
    // End of variables declaration//GEN-END:variables
}
