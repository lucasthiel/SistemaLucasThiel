/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LltCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class ControllerClientes extends AbstractTableModel{

    List lista;
    
    public void setLista(List lista){
        this.lista = lista;
    }
    
    public Object getBean(int rowIndex){
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
        LltCliente clientes = (LltCliente) lista.get(rowIndex);
        if (columnIndex == 0) {
            return clientes.getLltIdCliente();
        }
        if (columnIndex == 1) {
            return clientes.getLltNome();
        }
        if (columnIndex == 2) {
            return clientes.getLltCpf();
        }
        if (columnIndex == 3) {
            return clientes.getLltRg();
        }
  
        if (columnIndex == 4){
            return clientes.getLltEmail();
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
            return "Nome";
        }
        if (column == 2) {
            return "CPF";
        }
        if (column == 3) {
            return "Email";
        }else {
            return "";
        }
    }
}
