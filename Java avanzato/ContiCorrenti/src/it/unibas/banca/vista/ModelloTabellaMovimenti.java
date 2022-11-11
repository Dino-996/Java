package it.unibas.banca.vista;

import it.unibas.banca.modello.Movimento;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaMovimenti extends AbstractTableModel {

    private List<Movimento> listaMoviementi = new ArrayList<>();

    public void setListaMoviemnti(List<Movimento> listaMoviementi) {
        this.listaMoviementi = listaMoviementi;
    }

    @Override
    public int getRowCount() {
        return this.listaMoviementi.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movimento movimento = this.listaMoviementi.get(rowIndex);
        if (columnIndex == 0) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            return df.format(movimento.getDataOra().getTime());
        }
        if (columnIndex == 1) {
            return movimento.getImporto();
        }
        if (columnIndex == 2) {
            return movimento.getTipologia();
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
            return "Data movimento";
        }
        if (column == 1) {
            return "Importo";
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
