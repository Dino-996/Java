package it.unibas.aule.vista;

import it.unibas.aule.modello.Accesso;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAccessi extends AbstractTableModel {

    private List<Accesso> listaAccessi = new ArrayList<>();

    public void setListaAccessi(List<Accesso> listaAccessi) {
        this.listaAccessi = listaAccessi;
    }
    
    @Override
    public int getRowCount() {
        return this.listaAccessi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Accesso accesso = this.listaAccessi.get(rowIndex);
        if (columnIndex == 0) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            return df.format(accesso.getDataOra().getTime());
        }
        if (columnIndex == 1) {
            return accesso.getMatricola();
        }
        if (columnIndex == 2) {
            return accesso.getTempoPermanenza() + " minuti";
        }
        if (columnIndex == 3) {
            return accesso.getMotivazione();
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
            return "Data e ora";
        }
        if (column == 1) {
            return "Matricola";
        }
        if (column == 2) {
            return "Tempo di permanenza";
        }
        if (column == 3) {
            return "Motivazione";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
}
