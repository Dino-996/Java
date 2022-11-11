package it.unibas.pietanze.vista;

import it.unibas.pietanze.modello.Pietanza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPietanze extends AbstractTableModel {

    private List<Pietanza> listaPietanze = new ArrayList<>();

    public void setListaPietanze(List<Pietanza> listaPietanze) {
        this.listaPietanze = listaPietanze;
    }

    @Override
    public int getRowCount() {
        return this.listaPietanze.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pietanza pietanza = this.listaPietanze.get(rowIndex);
        if (columnIndex == 0) {
            return pietanza.getNome();
        }
        if (columnIndex == 1) {
            return pietanza.getNumeroIngredienti();
        }
        if (columnIndex == 2) {
            return pietanza.isContieneAllergene();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Integer.class;
        }
        if (columnIndex == 2) {
            return Boolean.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Pietanza";
        }
        if (column == 1) {
            return "Ingredienti";
        }
        if (column == 2) {
            return "Allergeni";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
