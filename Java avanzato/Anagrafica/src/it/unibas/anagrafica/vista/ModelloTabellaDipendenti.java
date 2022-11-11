package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.modello.Dipendente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDipendenti extends AbstractTableModel {
    
    private List<Dipendente> listaDipendenti = new ArrayList<>();
    
    public void setListaDipendenti(List<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }
    
    @Override
    public int getRowCount() {
        return this.listaDipendenti.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dipendente dipendente = this.listaDipendenti.get(rowIndex);
        if (columnIndex == 0) {
            return dipendente.getCodFiscale();
        }
        if (columnIndex == 1) {
            return dipendente.getNome();
        }
        if (columnIndex == 2) {
            return dipendente.getCognome();
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(dipendente.getDataAssunzione().getTime());
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
            return "Codice fiscale";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Cognome";
        }
        if (column == 3) {
            return "Data assunzione";
        }
        return "";
    }

    public void inizializza() {
        fireTableDataChanged();
    }
    
}
