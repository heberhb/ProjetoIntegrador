 package Classes;

import java.util.Date;

public class Fornecedores {
    private int idFornecedor;
    private String Empresa;
    private String Categoria;
    private String Cnpj;
    private String Telefone;
    private String Celular;
    private String Email;
    private String Cep;
    private String Cidade;
    private String Estado;
    private String Rua;
    private int Numero;
    private Date DataInicio;
    
    public Fornecedores(){
    }

    public Fornecedores(int idFornecedor, String Empresa,String Categoria, String Cnpj, String Telefone, String Celular, String Email, String Cep, String Cidade, String Estado, String Municipio, String Rua, int Numero, Date DataInicio) {
        this.idFornecedor = idFornecedor;
        this.Empresa = Empresa;
        this.Cnpj = Cnpj;
        this.Telefone = Telefone;
        this.Celular = Celular;
        this.Email = Email;
        this.Cep = Cep;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Categoria = Categoria;
        this.Rua = Rua;
        this.Numero = Numero;
        this.DataInicio = DataInicio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String toString(){
        return this.getCidade()+"("+this.getEstado()+")";
    }
    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public Date getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(Date DataInicio) {
        this.DataInicio = DataInicio;
    }

    
}
