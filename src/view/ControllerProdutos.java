/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.LltProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class ControllerProdutos extends AbstractTableModel{
    
    List lista;
    
    public void setLista(List lista) {
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
         LltProduto produto = (LltProduto) lista.get(rowIndex);
        if (columnIndex == 0) {
            return produto.getLltIdProduto();
        }
        if (columnIndex == 1) {
            return produto.getLltNomeProduto();
        }
        
        if (columnIndex == 2) {
            return produto.getLltCategoria();
        }
       
        if (columnIndex == 3){
            return produto.getLltMarca();
        }else {
            return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Produto";
        }
        if (column == 2) {
            return "Categoria";
        }
        if (column == 3) {
            return "Marca";
        }else {
            return "";
        }
    }
}
