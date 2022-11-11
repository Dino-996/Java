package it.unibas.supermercato.vista;

import it.unibas.supermercato.modello.Prodotto;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaProdotti extends AbstractTableModel {

    private List<Prodotto> listaProdotti = new ArrayList<>();

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    @Override
    public int getRowCount() {
        return this.listaProdotti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prodotto prodotto = this.listaProdotti.get(rowIndex);
        if (columnIndex == 0) {
            return prodotto.getNome();
        }
        if (columnIndex == 1) {
            return prodotto.getDescrizione();
        }
        if (columnIndex == 2) {
            Locale locale = Locale.ITALY;
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
            return numberFormat.format(prodotto.getPrezzo());
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(prodotto.getDataInserimentoProdotto().getTime());
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
            return "Prodotto";
        }
        if (column == 1) {
            return "Descrizione";
        }
        if (column == 2) {
            return "Prezzo";
        }
        if (column == 3) {
            return "Data inserimento";
        }
        return "";
    }
    
    public void inizializza() {
        this.fireTableDataChanged();
    }
}
