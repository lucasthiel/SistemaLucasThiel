package view;

import bean.LltCliente;
import bean.LltProduto;
import bean.LltVenda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos
 */
public class ControllerConsultasVenda extends AbstractTableModel {

    private List lstVenda;

    public void setList(List lstVenda) {
        this.lstVenda = lstVenda;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVenda.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LltVenda venda = (LltVenda) lstVenda.get( rowIndex);
        if ( columnIndex == 0 ){
            return venda.getLltIdVenda();
        } else if (columnIndex ==1) {
            return venda.getLltIdVendedor();        
        } else if (columnIndex ==2) {
            return venda.getLltIdCliente();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Vendedor";         
        } else if ( columnIndex == 2) {
            return "Cliente";
        }
        return "";
    }
}
