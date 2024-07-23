package Classes;

public class Categoria {
    private int id;
    private String TipoCategoria;
    
    public Categoria(){
    }

    public Categoria(int id, String TipoCategoria) {
        this.id = id;
        this.TipoCategoria = TipoCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCategoria() {
        return TipoCategoria;
    }

    public void setTipoCategoria(String TipoCategoria) {
        this.TipoCategoria = TipoCategoria;
    }
    
    
}
