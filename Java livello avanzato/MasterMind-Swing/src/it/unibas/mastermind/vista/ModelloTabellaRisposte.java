package it.unibas.mastermind.vista;

import it.unibas.mastermind.modello.Risposta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaRisposte extends AbstractTableModel {
    
    private List<Risposta> listaRisposte = new ArrayList<>();

    public void setRisposta(List<Risposta> listaRisposte) {
        this.listaRisposte = listaRisposte;
    }

    @Override
    public int getRowCount() {
        return this.listaRisposte.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return String.class;
        }
        return Integer.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Num. Tentativo";
        } else if (column == 1) {
            return "Combinazione";
        } else if (column == 2) {
            return "Pallini Neri";
        } else if (column == 3) {
            return "Pallini Bianchi";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        Risposta risposta = this.listaRisposte.get(rowIndex);
        if (columIndex == 0) {
            return rowIndex + 1;
        } else if (columIndex == 1) {
            return risposta.getTentativo().toString();
        } else if (columIndex == 2) {
            return risposta.getPalliniNeri();
        } else if (columIndex == 3) {
            return risposta.getPalliniBianchi();
        }
        return "";
    }
    
    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
    
}
