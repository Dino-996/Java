package it.unibas.pagina.vista;

import it.unibas.pagina.modello.FormattaData;
import it.unibas.pagina.modello.PaginaWeb;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPagine extends AbstractTableModel {

    private List<PaginaWeb> listaPagine = new ArrayList<>();

    public List<PaginaWeb> getListaPagine() {
        return listaPagine;
    }

    public void setListaPagine(List<PaginaWeb> listaPagine) {
        this.listaPagine = listaPagine;
    }

    @Override
    public int getRowCount() {
        return this.listaPagine.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaginaWeb pagina = listaPagine.get(rowIndex);
        if (columnIndex == 0) {
            return pagina.getIndirizzoUnivoco();
        }
        if (columnIndex == 1) {
            return pagina.getTitolo();
        }
        if (columnIndex == 2) {
            return FormattaData.formattaDataOra(pagina.getDataOraUltimoAggiornamento().getTime());
        }
        if (columnIndex == 3) {
            return pagina.getNumeroParole() + " parole";
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
            return "Indirizzo";
        }
        if (column == 1) {
            return "Titolo";
        }
        if (column == 2) {
            return "Data ultimo aggiornamento";
        }
        if (column == 3) {
            return "Numero parole";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
