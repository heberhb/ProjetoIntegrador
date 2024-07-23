package Classes;

import java.util.Date;

public class Produtos {
    private int id;
    private String Nome;
    private String Descricao;
    private String Categoria;
    private String Tamanho; 
    private String peso;
    private float preco;
    private Date DataCadastro;
     

    public Produtos(){
    }

    public Produtos(int id, String Nome, String Descricao, String Categoria, String Tamanho, String peso, float preco, Date DataCadastro) {
        this.id = id;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Categoria = Categoria;
        this.Tamanho = Tamanho;
        this.peso = peso;
        this.preco = preco;
        this.DataCadastro = DataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    
}