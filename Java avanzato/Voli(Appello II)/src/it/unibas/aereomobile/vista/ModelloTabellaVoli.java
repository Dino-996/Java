package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.modello.GestoreDate;
import it.unibas.aereomobile.modello.Volo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaVoli extends AbstractTableModel {

    private List<Volo> listaVoli = new ArrayList<>();

    public List<Volo> getListaVoli() {
        return listaVoli;
    }

    public void setListaVoli(List<Volo> listaVoli) {
        this.listaVoli = listaVoli;
    }

    @Override
    public int getRowCount() {
        return this.listaVoli.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Volo volo = this.listaVoli.get(rowIndex);
        if (columnIndex == 0) {
            return GestoreDate.getDataOraFormattata(volo.getDataOraPartenza().getTime());
        }
        if (columnIndex == 1) {
            return volo.getAereoportoPartenza();
        }
        if (columnIndex == 2) {
            return volo.getAereoportoDestinazione();
        }
        if (columnIndex == 3) {
            return volo.getDurataInMinuti() + " minuti";
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
            return "Data e ora partenza";
        }
        if (column == 1) {
            return "Aereoporto di partenza";
        }
        if (column == 2) {
            return "Aereoporto di destinazione";
        }
        if (column == 3) {
            return "Durata volo in minuti";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
