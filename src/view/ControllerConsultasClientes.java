package view;

import bean.LltCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */
public class ControllerConsultasClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LltCliente cliente = (LltCliente) lstClientes.get(rowIndex);

        if ( columnIndex == 0 ){
            return cliente.getLltIdCliente();
        } else if (columnIndex ==1) {
            return cliente.getLltNome();        
        } else if (columnIndex ==2) {
            return cliente.getLltCpf();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Cpf";
        }
        return "";
    }
}
