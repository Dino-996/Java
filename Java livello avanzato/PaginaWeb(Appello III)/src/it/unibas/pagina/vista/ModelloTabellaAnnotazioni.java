package it.unibas.pagina.vista;

import it.unibas.pagina.modello.Annotazione;
import it.unibas.pagina.modello.FormattaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAnnotazioni extends AbstractTableModel {

    private List<Annotazione> listaAnnotazioni = new ArrayList<>();

    public List<Annotazione> getListaAnnotazioni() {
        return listaAnnotazioni;
    }

    public void setListaAnnotazioni(List<Annotazione> listaAnnotazioni) {
        this.listaAnnotazioni = listaAnnotazioni;
    }

    @Override
    public int getRowCount() {
        return listaAnnotazioni.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Annotazione a = this.listaAnnotazioni.get(rowIndex);
        if (columnIndex == 0) {
            return "parola numero: " + a.getIndiceParolaIniziale();
        }
        if (columnIndex == 1) {
            return "parola numero: " + a.getIndiceParolaFinale();
        }
        if (columnIndex == 2) {
            return a.getColore();
        }
        if (columnIndex == 3) {
            return FormattaData.formattaDataOra(a.getDataOraAnnotazione().getTime());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1 || columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Inizio";
        }
        if (column == 1) {
            return "Fine";
        }
        if (column == 2) {
            return "Colore";
        }
        if (column == 3) {
            return "Data ultimo aggiornamento";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
}
