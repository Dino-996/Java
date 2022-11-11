package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.modello.Volo;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaVoli extends AbstractTableModel {

    private List<Volo> listaVoli = new ArrayList<>();

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
            return volo.getAereoportoPartenza();
        }
        if (columnIndex == 1) {
            return volo.getAereoportoDestinazione();
        }
        if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            String dataFormattata = df.format(volo.getDataOraPartenza().getTime());
            return dataFormattata;
        }
        if (columnIndex == 3) {
            return volo.getDurataVoloMinuti() + " minuti";
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
            return "Aereoporto di partenza";
        }
        if (column == 1) {
            return "Aereoporto di destinazione";
        }
        if (column == 2) {
            return "Data e ora partenza";
        }
        if (column == 3) {
            return "Durata del volo";
        }
        return "";
    }
    
    public void inizializza() {
        this.fireTableDataChanged();
    }
}
