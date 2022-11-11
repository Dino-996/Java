package it.unibas.autostrada.vista;

import it.unibas.autostrada.modello.Casello;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaCaselli extends AbstractTableModel {

    private List<Casello> listaCaselli = new ArrayList<>();

    public void setListaCaselli(List<Casello> listaCaselli) {
        this.listaCaselli = listaCaselli;
    }

    @Override
    public int getRowCount() {
        return this.listaCaselli.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Casello casello = this.listaCaselli.get(rowIndex);
        if (columnIndex == 0) {
            return casello.getCodiceUnivoco();
        }
        if (columnIndex == 1) {
            return "Autostrada " + casello.getNomeAutostrada();
        }
        if (columnIndex == 2) {
            return casello.getPosizioneInKm() + " Km";
        }
        if (columnIndex == 3) {
            return casello.getListaAccessi().size();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
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
            return "Nome autostrada";
        }
        if (column == 2) {
            return "Posizione in Km";
        }
        if (column == 3) {
            return "Numero accessi";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
