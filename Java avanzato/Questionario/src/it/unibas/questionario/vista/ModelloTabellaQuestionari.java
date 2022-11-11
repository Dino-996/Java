package it.unibas.questionario.vista;

import it.unibas.questionario.modello.Questionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaQuestionari extends AbstractTableModel {

    private List<Questionario> listaQuestionario = new ArrayList<>();

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public void setListaQuestionario(List<Questionario> listaQuestionario) {
        this.listaQuestionario = listaQuestionario;
    }

    @Override
    public int getRowCount() {
        return this.listaQuestionario.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Questionario questionario = this.listaQuestionario.get(rowIndex);
        if (columnIndex == 0) {
            return questionario.getCodiceUnivoco();
        }
        if (columnIndex == 1) {
            return questionario.getDescrizione();
        }
        if (columnIndex == 2) {
            return questionario.getDifficolta();
        }
        if (columnIndex == 3) {
            return questionario.getCompilazioniPositive();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3 || columnIndex == 4) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice univoco";
        }
        if (column == 1) {
            return "Descrizione";
        }
        if (column == 2) {
            return "Difficolta'";
        }
        if (column == 3) {
            return "Compilazioni positive";
        }
        return "";
    }

    public void inizializza() {
        this.fireTableDataChanged();
    }
}
