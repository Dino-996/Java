package it.unibas.file.vista;

import it.unibas.file.modello.Cartella;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPrincipale extends AbstractTableModel {

    private List<Cartella> listaCartelle = new ArrayList<>();

    public void setListaCartelle(List<Cartella> listaCartelle) {
        this.listaCartelle = listaCartelle;
    }

    @Override
    public int getRowCount() {
        return this.listaCartelle.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cartella cartella = this.listaCartelle.get(rowIndex);
        if (columnIndex == 0) {
            return cartella.getPercorso();
        }
        if (columnIndex == 1) {
            int mese = cartella.getDataCreazione().get(Calendar.MONTH);
            return meseCreazione(mese);
        }
        if (columnIndex == 2) {
            return cartella.getListaFile().size();
        }
        if (columnIndex == 3) {
            return cartella.getDimensione() + " kb";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2 || columnIndex == 3) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Percorso file";
        }
        if (column == 1) {
            return "Mese creazione";
        }
        if (column == 2) {
            return "Numero file";
        }
        if (column == 3) {
            return "Dimensione cartella";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
    
    private String meseCreazione(int mese) {
        String meseString = "";
        if (mese == 0) {
            return "Gennaio";
        }
        if (mese == 1) {
            return "Febbraio";
        }
        if (mese == 2) {
            return "Marzo";
        }
        if (mese == 3) {
            return "Aprile";
        }
        if (mese == 4) {
            return "Maggio";
        }
        if (mese == 5) {
            return "Giugno";
        }
        if (mese == 6) {
            return "Luglio";
        }
        if (mese == 7) {
            return "Agosto";
        }
        if (mese == 8) {
            return "Settembre";
        }
        if (mese == 9) {
            return "Ottobre";
        }
        if (mese == 10) {
            return "Novembre";
        }
        if (mese == 11) {
            return "Dicembre";
        }
        return meseString;
    } 
}
