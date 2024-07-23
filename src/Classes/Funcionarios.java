package Classes;

import java.util.Date;

public class Funcionarios{
    private int idFuncionario;
    private String Nome;
    private String Cpf;
    private Date DataNascimento;
    private int Idade;
    private String Telefone;
    private String Celular;
    private String Email;
    private String Cargo;
    private String Cep;
    private String Cidade; 
    private String Estado; 
    private String Municipio; 
    private String Rua;
    private int Numero; 
    private Date DataInicio;
    private Date DataFim;
    private String Senha;
    private String Login;
    
    public Funcionarios(){
        
    }

    public Funcionarios(int idFuncionario, String Nome, String Cpf, Date DataNascimento, int Idade, String Telefone, String Celular, String Email, String Cargo,String Cep, String Cidade, String Estado, String Municipio, String Rua, int Numero, Date DataInicio, Date DataFim,String Login,String Senha) {
        this.idFuncionario = idFuncionario;
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
        this.DataInicio = DataInicio;
        this.DataFim = DataFim;
        this.Cargo = Cargo;
        this.Senha = Senha;
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public Date getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(Date DataInicio) {
        this.DataInicio = DataInicio;
    }

    public Date getDataFim() {
        return DataFim;
    }

    public void setDataFim(Date DataFim) {
        this.DataFim = DataFim;
    }
    
    
    
}