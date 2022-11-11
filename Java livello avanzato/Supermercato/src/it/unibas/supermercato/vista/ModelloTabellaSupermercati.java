package it.unibas.supermercato.vista;

import it.unibas.supermercato.modello.Supermercato;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaSupermercati extends AbstractTableModel {

    private List<Supermercato> listaSupermercati = new ArrayList<>();

    public void setListaSupermercati(List<Supermercato> listaSupermercati) {
        this.listaSupermercati = listaSupermercati;
    }

    @Override
    public int getRowCount() {
        return this.listaSupermercati.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Supermercato supermercato = this.listaSupermercati.get(rowIndex);
        if (columnIndex == 0) {
            return supermercato.getNome();
        }
        if (columnIndex == 1) {
            return supermercato.getCitta();
        }
        if (columnIndex == 2) {
            return "Via " + supermercato.getVia();
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(supermercato.getDataAggiornamentoProdotti().getTime());
        }
        if (columnIndex == 4) {
            return supermercato.getListaProdotti().size();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome supermercato";
        }
        if (column == 1) {
            return "Citta'";
        }
        if (column == 2) {
            return "Indirizzo";
        }
        if (column == 3) {
            return "Data di inserimento ultimo prodotto";
        }
        if (column == 4) {
            return "Prodotti disponibili";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
}
