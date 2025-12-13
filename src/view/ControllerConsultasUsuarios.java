package view;

import bean.LltCliente;
import bean.LltUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultasUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstProdutos) {
        this.lstUsuarios = lstProdutos;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LltUsuario usuario = (LltUsuario) lstUsuarios.get(rowIndex);
        
        if ( columnIndex == 0 ){
            return usuario.getLltIdUsuario();
        } else if (columnIndex ==1) {
            return usuario.getLltNome();        
        } else if (columnIndex ==2) {
            return usuario.getLltApelido();
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
            return "Apelido";
        }
        return "";
    }
}
