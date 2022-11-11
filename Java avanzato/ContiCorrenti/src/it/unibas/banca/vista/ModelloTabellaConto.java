package it.unibas.banca.vista;

import it.unibas.banca.modello.Conto;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaConto extends AbstractTableModel {

    private List<Conto> listaConti = new ArrayList<>();

    public void setListaConti(List<Conto> listaConti) {
        this.listaConti = listaConti;
    }

    @Override
    public int getRowCount() {
        return listaConti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Conto conto = this.listaConti.get(rowIndex);
        if (columnIndex == 0) {
            return conto.getIntestatario();
        }
        if (columnIndex == 1) {
            return conto.getIBAN();
        }
        if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(conto.getDataApertura().getTime());
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
            return "Intestatario";
        }
        if (column == 1) {
            return "IBAN";
        }
        if (column == 2) {
            return "Data apertura conto";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
}
