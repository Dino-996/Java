package it.unibas.aereomobile.vista;

import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.GestoreDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPrincipale extends AbstractTableModel {

    private List<Aereomobile> listaAereomobili = new ArrayList<>();

    public List<Aereomobile> getListaFiltrata() {
        return listaAereomobili;
    }

    public void setListaFiltrata(List<Aereomobile> listaFiltrata) {
        this.listaAereomobili = listaFiltrata;
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
        Aereomobile aereomobile = this.listaAereomobili.get(rowIndex);
        if (columnIndex == 0) {
            return aereomobile.getCodice();
        }
        if (columnIndex == 1) {
            return aereomobile.getNumPasseggeri();
        }
        if (columnIndex == 2) {
            return aereomobile.getTipologia();
        }
        if (columnIndex == 3) {
            return GestoreDate.getDataFormattata(aereomobile.getDataUltimaManutenzione().getTime());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
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
            return "Passeggeri";
        }
        if (column == 2) {
            return "Tipologia";
        }
        if (column == 3) {
            return "Data ultima manutenzione";
        }
        return "";
    }

    public void inizalizzaTabella() {
        this.fireTableDataChanged();
    }
}
