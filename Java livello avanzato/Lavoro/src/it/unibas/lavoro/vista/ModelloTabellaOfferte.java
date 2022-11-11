package it.unibas.lavoro.vista;

import it.unibas.lavoro.modello.Offerta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaOfferte extends AbstractTableModel {

    private List<Offerta> listaOfferte = new ArrayList<>();

    public void setListaOfferte(List<Offerta> listaOfferte) {
        this.listaOfferte = listaOfferte;
    }
    
    @Override
    public int getRowCount() {
        return this.listaOfferte.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Offerta offerta = this.listaOfferte.get(rowIndex);
        if (columnIndex == 0) {
            return offerta.getCodiceUnivoco();
        }
        if (columnIndex == 1) {
            return offerta.getDescrizione();
        }
        if (columnIndex == 2) {
            return offerta.getRetribuzioneAnnua();
        }
        if (columnIndex == 3) {
            return offerta.getDomandeOverTrenta();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2 ||columnIndex == 3) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice univoco";
        }
        if (column == 1) {
            return "Descrizione";
        }
        if (column == 2) {
            return "Retribuzione annua";
        }
        if (column == 3) {
            return "Domande Over 30";
        }
        return "";
    }
    
    public void aggiornaDati() {
        this.fireTableDataChanged();
    }
}
