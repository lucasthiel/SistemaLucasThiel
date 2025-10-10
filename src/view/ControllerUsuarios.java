/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LltUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Lucas
 */
public class ControllerUsuarios extends AbstractTableModel {
    
    List lista;
    
    public void setLista(List lista) {
        this.lista = lista;
    }
    
    public Object getBean (int rowIndex) {
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
    public Object getValueAt(int rowIndex, int columnIndex){
        LltUsuario usuarios = (LltUsuario) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getLltIdUsuario();
        }
        if (columnIndex == 1) {
            return usuarios.getLltNome();
        }
        if (columnIndex == 2) {
            return usuarios.getLltCpf();
        }
        if (columnIndex == 3) {
            return usuarios.getLltApelido();
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
            return "Apelido";
        }else {
            return "";
        }
    }
    
}
