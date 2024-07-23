package Classes;

public class Usuario {
    private int id;
    private String Nome;
    private String Login;
    private String Senha;

    public Usuario(int id, String Nome, String Login, String Senha) {
        this.id = id;
        this.Nome = Nome;
        this.Login = Login;
        this.Senha = Senha;
    }
    
    @Override
    public String toString(){
        return this.Login+"("+this.Nome+")";
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

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    
}
