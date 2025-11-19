/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

import bean.LltVendaProduto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class ControllerVendasProdutos extends AbstractTableModel{

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
       return lista.get(rowIndex);    
    }
    
    public void addBean(LltVendaProduto vendasProdutos){
        this.lista.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        this.lista.remove(rowIndex); 
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        if (lista == null) {
        return 0; // ← mostra só as colunas, sem erro
    }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         LltVendaProduto venda_Produto = (LltVendaProduto) lista.get(rowIndex);
        if (columnIndex == 0) {
            return venda_Produto.getLltIdVendaProduto();
        }
        if (columnIndex == 1) {
            return venda_Produto.getLltIdVenda();
        }
        if (columnIndex == 2) {
            return venda_Produto.getLltIdProduto();
        }
        if (columnIndex == 3) {
            return venda_Produto.getLltStatusVenda();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Código da Venda";
        }
        if (column == 2) {
            return "Código do Produto";
        }
        if (column == 3) {
            return "Status Venda";
        }
        return "";
    }
}
    
