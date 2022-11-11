package it.unibas.playlist.vista;

import it.unibas.playlist.modello.Brano;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaBrano extends AbstractTableModel {

    private List<Brano> listaBrani = new ArrayList<>();

    public void setBrano(List<Brano> listaBrani) {
        this.listaBrani = listaBrani;
    }

    public List<Brano> getListaBrani() {
        return this.listaBrani;
    }

    @Override
    public int getRowCount() {
        return this.listaBrani.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Brano brano = this.listaBrani.get(rowIndex);
        if (columnIndex == 0) {
            return brano.getNomeBrano();
        } else if (columnIndex == 1) {
            return brano.getNomeArtista();
        } else if (columnIndex == 2) {
            return brano.getCategoria();
        } else if (columnIndex == 3) {
            return brano.getDurataInMinuti();
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
            return "Nome brano";
        } else if (column == 1) {
            return "Artista";
        } else if (column == 2) {
            return "Categoria";
        } else if (column == 3) {
            return "Durata in minuti";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }

}
