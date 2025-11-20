package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LltVendaProduto – adaptado no padrão PedidosProdutos
 */
@Entity
@Table(name="llt_venda_produto",
       catalog="db_lucas_thiel")
public class LltVendaProduto implements java.io.Serializable {

    private int idVendaProduto;
    private LltVenda venda;
    private LltProduto produto;
    private int quantidade;
    private double valorUnitario;
    private String statusVenda;
    private String tipoEmbalagem;

    public LltVendaProduto() {
    }

    public LltVendaProduto(LltVenda venda, LltProduto produto, int quantidade, 
                           double valorUnitario, String statusVenda, String tipoEmbalagem) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.statusVenda = statusVenda;
        this.tipoEmbalagem = tipoEmbalagem;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="llt_idVendaProduto", unique = true, nullable = false)
    public int getIdVendaProduto() {
        return this.idVendaProduto;
    }

    public void setIdVendaProduto(int idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="llt_idVenda")
    public LltVenda getVenda() {
        return this.venda;
    }

    public void setVenda(LltVenda venda) {
        this.venda = venda;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="llt_idProduto")
    public LltProduto getProduto() {
        return this.produto;
    }

    public void setProduto(LltProduto produto) {
        this.produto = produto;
    }

    @Column(name="llt_quantidade")
    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Column(name="llt_valorUnitario", precision = 10)
    public double getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Column(name="llt_statusVenda", length = 15)
    public String getStatusVenda() {
        return this.statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    @Column(name="llt_tipoEmbalagem", length = 25)
    public String getTipoEmbalagem() {
        return this.tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }
}
