package it.unibas.playlist.vista;

import it.unibas.playlist.modello.Playlist;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPlaylist extends AbstractTableModel {

    private List<Playlist> listaVuota = new ArrayList<Playlist>();

    public List<Playlist> getListaVuota() {
        return listaVuota;
    }

    public void setListaVuota(List<Playlist> listaVuota) {
        this.listaVuota = listaVuota;
    }
    
    @Override
    public int getRowCount() {
        if (listaVuota == null) {
            return 0;
        }
        return this.listaVuota.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Playlist playlist = this.listaVuota.get(rowIndex);
        if (columnIndex == 0) {
            return playlist.getNomeBrano();
        } else if (columnIndex == 1) {
            return playlist.getNomeProprietario();
        } else if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            return df.format(playlist.getDataCreazione().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Playlist";
        } else if (column == 1) {
            return "Proprietario";
        } else if (column == 2) {
            return "Data";
        }
        return "";
    }    
    
    public void aggiornaContenuti() {
        this.fireTableDataChanged();
    }
}
