package it.unibas.concorsi.vista;

import it.unibas.concorsi.modello.Concorso;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaConcorsi extends AbstractTableModel {

    private List<Concorso> listaConcorsi = new ArrayList<>();

    public void setListaConcorsi(List<Concorso> listaConcorsi) {
        this.listaConcorsi = listaConcorsi;
    }

    @Override
    public int getRowCount() {
        return this.listaConcorsi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Concorso concorso = this.listaConcorsi.get(rowIndex);
        if (columnIndex == 0) {
            return concorso.getCodice();
        }
        if (columnIndex == 1) {
            return concorso.getDescrizione();
        }
        if (columnIndex == 2) {
            return concorso.getNumeroPosti();
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            return df.format(concorso.getDataOraConcorso().getTime());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        }
        if (column == 1) {
            return "Descrizione";
        }
        if (column == 2) {
            return "Numero posti";
        }
        if (column == 3) {
            return "Data e ora concorso";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
