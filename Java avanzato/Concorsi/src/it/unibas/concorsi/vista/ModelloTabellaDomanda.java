package it.unibas.concorsi.vista;

import it.unibas.concorsi.modello.Domanda;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDomanda extends AbstractTableModel {

    private List<Domanda> listaDomande = new ArrayList<>();

    public void setListaDomande(List<Domanda> listaDomande) {
        this.listaDomande = listaDomande;
    }

    @Override
    public int getRowCount() {
        return this.listaDomande.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Domanda domanda = this.listaDomande.get(rowIndex);
        if (columnIndex == 0) {
            return domanda.getCodiceFiscale();
        }
        if (columnIndex == 1) {
            return domanda.getSesso();
        }
        if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(domanda.getDataDomanda().getTime());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice fiscale";
        }
        if (column == 1) {
            return "Sesso";
        }
        if (column == 2) {
            return "Data presentazione domanda";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
