package it.unibas.cesti.vista;

import it.unibas.cesti.modello.Cesto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaCesti extends AbstractTableModel {

    private List<Cesto> listaCesti = new ArrayList<>();

    public void setListaCesti(List<Cesto> listaCesti) {
        this.listaCesti = listaCesti;
    }

    @Override
    public int getRowCount() {
        return this.listaCesti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cesto cesto = this.listaCesti.get(rowIndex);
        if (columnIndex == 0) {
            return cesto.getNome();
        }
        if (columnIndex == 1) {
            return cesto.getPrezzo();
        }
        if (columnIndex == 2) {
            return cesto.getTipologia();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome";
        }
        if (column == 1) {
            return "Prezzo";
        }
        if (column == 2) {
            return "Tipologia";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }

}
