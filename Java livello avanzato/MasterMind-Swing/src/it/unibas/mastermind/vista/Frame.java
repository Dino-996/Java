package it.unibas.mastermind.vista;

import it.unibas.mastermind.Applicazione;
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
        this.menuEsci.setAction(Applicazione.getIstance().getControlloMenu().getAzioneEsci());
        this.menuNuovaPartita.setAction(Applicazione.getIstance().getControlloMenu().getAzioneIniziaPartita());
        this.menuInterrompiPartita.setAction(Applicazione.getIstance().getControlloMenu().getAzioneInterrompiPartita());
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
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuNuovaPartita = new javax.swing.JMenuItem();
        menuInterrompiPartita = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MasterMind");

        jMenu1.setText("File");

        menuNuovaPartita.setText("Nuova partita");
        jMenu1.add(menuNuovaPartita);

        menuInterrompiPartita.setText("Interrompi partita");
        jMenu1.add(menuInterrompiPartita);

        menuEsci.setText("Esci");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuInterrompiPartita;
    private javax.swing.JMenuItem menuNuovaPartita;
    // End of variables declaration//GEN-END:variables
}
