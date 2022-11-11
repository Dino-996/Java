package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.modello.Azienda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAzienda extends AbstractTableModel {

    private List<Azienda> listaAziende = new ArrayList<>();

    public void setListaAziende(List<Azienda> listaAziende) {
        this.listaAziende = listaAziende;
    }

    @Override
    public int getRowCount() {
        return this.listaAziende.size();
    }

    @Override
    public int getColumnCount() {

        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Azienda azienda = this.listaAziende.get(rowIndex);
        if (columnIndex == 0) {
            return azienda.getPartitaIVA();
        }
        if (columnIndex == 1) {
            return azienda.getDenominazione();
        }
        if (columnIndex == 2) {
            return azienda.getSedeSociale();
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
            return "PartitaIVA";
        }
        if (column == 1) {
            return "Denominazione";
        }
        if (column == 2) {
            return "Sede sociale";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
}
