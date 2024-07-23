package Classes;

public class Cargo {
    private int id;
    private String Tipo;
    private String Funcao;

    public Cargo(){
    }
    
    public Cargo(int id, String Tipo,String Funcao) {
        this.id = id;
        this.Tipo = Tipo;
        this.Funcao = Funcao;
  
    }
    
    @Override
    public String toString(){
        return this.Tipo;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }
}
