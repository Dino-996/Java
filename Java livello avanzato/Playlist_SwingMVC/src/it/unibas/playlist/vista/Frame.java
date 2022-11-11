package it.unibas.playlist.vista;

import it.unibas.playlist.Applicazione;
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
        initComponents();
        VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
        setContentPane(new JScrollPane(vistaPrincipale));
        setLocationRelativeTo(null);
        inizializzaAzioni();
        pack();
        setVisible(true);
    }
    
    private void inizializzaAzioni() {
        this.menuEsci.setAction(Applicazione.getIstance().getControlloMenu().getAzioneEsci());
        this.menuCarica.setAction(Applicazione.getIstance().getControlloMenu().getAzioneCarica());
        
    }
    
    public void getMessaggioInformativo(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, this.getTitle() + " - Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void getMessaggioErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, this.getTitle() + " - Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCarica = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Playlist");

        jMenu1.setText("File");

        menuCarica.setText("Carica");
        menuCarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCaricaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCarica);

        menuEsci.setText("Esci");
        menuEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEsciActionPerformed(evt);
            }
        });
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCaricaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCaricaActionPerformed

    private void menuEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEsciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuEsciActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables
}
