package Classes;

import java.util.Date;

public class Vendas {
    private int Id;
    private String ProdutoVendido;
    private int Quantidade;
    private float ValorProduto;
    private float Total;
    private Date DataVenda;
    
    public Vendas(){
    }

    public Vendas(int Id, String ProdutoVendido,int Quantidade, float ValorProduto, float Total, Date DataVenda) {
        this.Id = Id;
        this.ProdutoVendido = ProdutoVendido;
        this.Quantidade = Quantidade;
        this.ValorProduto = ValorProduto;
        this.Total = Total;
        this.DataVenda = DataVenda;
    }


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getProdutoVendido() {
        return ProdutoVendido;
    }

    public void setProdutoVendido(String ProdutoVendido) {
        this.ProdutoVendido = ProdutoVendido;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public float getValorProduto() {
        return ValorProduto;
    }

    public void setValorProduto(float ValorProduto) {
        this.ValorProduto = ValorProduto;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }
    
    

}