package it.unibas.autostrada.vista;

import it.unibas.autostrada.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame extends javax.swing.JFrame {
    
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }
    
    public void inizializza() {
        this.initComponents();
        VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vista));
        this.inizializzaAzioni();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void inizializzaAzioni() {
        this.menuCarica.setAction(Applicazione.getIstance().getControlloMenu().getAzioneCarica());
        this.menuCerca.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.menuVerificaCaselli.setAction(Applicazione.getIstance().getControlloMenu().getAzioneVerifica());
        this.menuVerificaAccessi.setAction(Applicazione.getIstance().getControlloMenu().getAzioneVerificaAccessi());
        this.menuEsci.setAction(Applicazione.getIstance().getControlloMenu().getAzioneEsci());
    }
    
    public void getMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, this.getTitle() + " - Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void getErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, this.getTitle() + " - Errore", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu2 = new javax.swing.JMenu();
        menuCarica = new javax.swing.JMenuItem();
        menuCerca = new javax.swing.JMenuItem();
        menuVerificaCaselli = new javax.swing.JMenuItem();
        menuVerificaAccessi = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caselli");

        jMenu2.setText("File");

        menuCarica.setText("jMenuItem2");
        jMenu2.add(menuCarica);

        menuCerca.setText("jMenuItem1");
        jMenu2.add(menuCerca);

        menuVerificaCaselli.setText("jMenuItem3");
        jMenu2.add(menuVerificaCaselli);

        menuVerificaAccessi.setText("jMenuItem1");
        jMenu2.add(menuVerificaAccessi);

        menuEsci.setText("jMenuItem4");
        menuEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEsciActionPerformed(evt);
            }
        });
        jMenu2.add(menuEsci);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEsciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEsciActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuCerca;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuVerificaAccessi;
    private javax.swing.JMenuItem menuVerificaCaselli;
    // End of variables declaration//GEN-END:variables
}
