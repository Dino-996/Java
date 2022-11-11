package it.unibas.playlist.vista;

import it.unibas.playlist.Applicazione;
import it.unibas.playlist.modello.Costanti;
import it.unibas.playlist.modello.Playlist;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {
    public void inizializza() {
        initComponents();
        ModelloTabellaPlaylist modelloTabellaPlaylist = new ModelloTabellaPlaylist();
        this.tabellaPlaylist.setModel(modelloTabellaPlaylist);
        this.bottoneCaricaPlaylist.setAction(Applicazione.getIstance().getControlloMenu().getAzioneCarica());
        this.bottoneCercaBrani.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneCaricaPlaylist());
        this.bottoneFormPlaylist.setAction(Applicazione.getIstance().getControlloPrincipale().getAzioneAggiungiPlaylist());
    }
    
    public void aggiornaTabella() {
        List<Playlist> playlist = (List<Playlist>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaPlaylist modelloTabella = (ModelloTabellaPlaylist) this.tabellaPlaylist.getModel();
        modelloTabella.setListaVuota(playlist);
        modelloTabella.aggiornaContenuti();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaPlaylist.getSelectedRow();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPlaylist = new javax.swing.JTable();
        bottoneCaricaPlaylist = new javax.swing.JButton();
        bottoneCercaBrani = new javax.swing.JButton();
        bottoneFormPlaylist = new javax.swing.JButton();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();

        tabellaPlaylist.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaPlaylist);

        bottoneCaricaPlaylist.setText("Carica playlist");

        bottoneCercaBrani.setText("Cerca brani");

        bottoneFormPlaylist.setText("Nuova playlist");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bottoneCercaBrani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bottoneFormPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bottoneCaricaPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bottoneCaricaPlaylist)
                        .addComponent(bottoneCercaBrani)
                        .addComponent(bottoneFormPlaylist))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCaricaPlaylist;
    private javax.swing.JButton bottoneCercaBrani;
    private javax.swing.JButton bottoneFormPlaylist;
    private javax.swing.JTable tabellaPlaylist;
    // End of variables declaration//GEN-END:variables
}
