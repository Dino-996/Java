package it.unibas.file.vista;

import it.unibas.file.modello.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaFile extends AbstractTableModel {

    private List<File> listaFile = new ArrayList<>();

    public void setListaFile(List<File> listaFile) {
        this.listaFile = listaFile;
    }

    @Override
    public int getRowCount() {
        return this.listaFile.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        File file = this.listaFile.get(rowIndex);
        if (columnIndex == 0) {
            return file.getNome();
        }
        if (columnIndex == 1) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            return df.format(file.getDataCreazione().getTime());
        }
        if (columnIndex == 2) {
            return file.getDimensione() + " kb";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome file";
        }
        if (column == 1) {
            return "Data creazione";
        }
        if (column == 2) {
            return "Dimensione";
        }
        return "";
    }
    
    public void inizializza() {
        this.fireTableDataChanged();
    }

}
