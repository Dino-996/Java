package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.modello.Aereomobile;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAereomobili extends AbstractTableModel {

    private List<Aereomobile> listaAereomobili = new ArrayList<>();

    public void setListaAereomobili(List<Aereomobile> listaAereomobili) {
        this.listaAereomobili = listaAereomobili;
    }

    @Override
    public int getRowCount() {
        return this.listaAereomobili.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aereomobile a = this.listaAereomobili.get(rowIndex);
        if (columnIndex == 0) {
            return a.getCodice();
        }
        if (columnIndex == 1) {
            return a.getTipologia();
        }
        if (columnIndex == 2) {
            return a.getNumeroPasseggeri();
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            String dataFormattata = df.format(a.getDataUltimaManutenzione().getTime());
            return dataFormattata;
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
            return "Tipologia";
        }
        if (column == 2) {
            return "Numero passeggeri";
        }
        if (column == 3) {
            return "Data ultima manutenzione";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }

}
