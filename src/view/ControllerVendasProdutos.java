package view;

import bean.LltVendaProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerVendasProdutos extends AbstractTableModel {

    private List<LltVendaProduto> lstVendasProdutos;

    public void setList(List<LltVendaProduto> lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        this.fireTableDataChanged();
    }

    public LltVendaProduto getBean(int rowIndex) {
        return lstVendasProdutos.get(rowIndex);
    }

    public void addBean(LltVendaProduto vendasProdutos) {
        this.lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }

    public void removeBean(int rowIndex) {
        this.lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (lstVendasProdutos == null) {
            return 0;
        }
        return lstVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5; 
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LltVendaProduto vendaProduto = (LltVendaProduto) lstVendasProdutos.get(rowIndex);

        if (columnIndex == 0) {
            return vendaProduto.getProduto().getLltIdProduto();
        } else if (columnIndex == 1) {
            return vendaProduto.getProduto().getLltNomeProduto();
        }else if (columnIndex ==2) {
            return vendaProduto.getQuantidade();
        } else if (columnIndex == 3) {
            return vendaProduto.getValorUnitario();
        } else if (columnIndex == 4) {
            return vendaProduto.getQuantidade() * vendaProduto.getValorUnitario();
        }

        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Total";
        }
        return "";
    }
}
