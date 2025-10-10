/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LltVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class ControllerVendedor extends AbstractTableModel{
    
    List lista;

    public void setLista(List lista) {
        this.lista = lista; 
    }

    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LltVendedor vendedor = (LltVendedor) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendedor.getLltIdVendedor();
        }
        if (columnIndex == 1) {
            return vendedor.getLltNome();  
        }
        if (columnIndex == 2) {
            return vendedor.getLltCpf();
        }
        if (columnIndex == 3) {
            return vendedor.getLltCelular();
        }
        
        else {
            return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Vendedor";
        }
        if (column == 2) {
            return "CPF";
        }
        if (column == 3) {
            return "Celular";
        }else {
            return "";
        }
    }
}
