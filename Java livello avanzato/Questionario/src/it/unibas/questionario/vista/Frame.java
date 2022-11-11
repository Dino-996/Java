package it.unibas.questionario.vista;

import it.unibas.questionario.Applicazione;
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
        this.menuCaricaArchivio.setAction(Applicazione.getIstance().getControlloMenu().getAzioneCarica());
        this.menuCercaQuestionario.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCerca());
        this.menuVerificaArchivio.setAction(Applicazione.getIstance().getControlloMenu().getAzioneVerifica());
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
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCaricaArchivio = new javax.swing.JMenuItem();
        menuCercaQuestionario = new javax.swing.JMenuItem();
        menuVerificaArchivio = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Questionari");

        jMenu1.setText("File");

        menuCaricaArchivio.setText("jMenuItem2");
        jMenu1.add(menuCaricaArchivio);

        menuCercaQuestionario.setText("jMenuItem1");
        jMenu1.add(menuCercaQuestionario);

        menuVerificaArchivio.setText("jMenuItem4");
        jMenu1.add(menuVerificaArchivio);

        menuEsci.setText("jMenuItem1");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCaricaArchivio;
    private javax.swing.JMenuItem menuCercaQuestionario;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuVerificaArchivio;
    // End of variables declaration//GEN-END:variables
}
