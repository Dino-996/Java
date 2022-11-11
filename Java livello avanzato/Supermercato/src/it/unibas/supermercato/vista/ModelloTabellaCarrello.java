package it.unibas.supermercato.vista;

import it.unibas.supermercato.modello.Prodotto;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaCarrello extends AbstractTableModel {

    private List<Prodotto> listaProdotti = new ArrayList<>();

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    @Override
    public int getRowCount() {
        if (listaProdotti == null) {
            return 2;
        }
        return this.listaProdotti.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prodotto prodotto = listaProdotti.get(rowIndex);
        if (columnIndex == 0) {
            return prodotto.getNome();
        }
        if (columnIndex == 1) {
            Locale locale = Locale.ITALY;
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
            String euro = numberFormat.format(prodotto.getPrezzo());
            return euro;
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
            return "Prodotto";
        }
        if (column == 1) {
            return "Prezzo";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
}
