package Classes;

import java.util.Date;

public class Clientes {
    private int idCliente;
    private String Nome;
    private String Cpf;
    private Date DataNascimento;
    private int Idade;
    private String Telefone;
    private String Celular;
    private String Email;
    private String Cep;
    private String Cidade; 
    private String Estado; 
    private String Municipio; 
    private String Rua;
    private int Numero; 
    private float TotalCompra;
    private Date DataCadastro;
    
    public Clientes(){
    }


    public Clientes(int idCliente, String Nome, String Cpf, Date DataNascimento, int Idade, String Telefone, String Celular, String Email, String Cep, String Cidade, String Estado, String Municipio, String Rua, int Numero, float TotalCompra, Date DataCadastro) {
        this.idCliente = idCliente;
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.DataNascimento = DataNascimento;
        this.Idade = Idade;
        this.Telefone = Telefone;
        this.Celular = Celular;
        this.Email = Email;
        this.Cep = Cep;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Municipio = Municipio;
        this.Rua = Rua;
        this.Numero = Numero;
        this.TotalCompra = TotalCompra;
        this.DataCadastro = DataCadastro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
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

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
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

    public float getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(float TotalCompra) {
        this.TotalCompra = TotalCompra;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
    
    

    
}
