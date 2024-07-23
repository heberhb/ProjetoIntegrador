package ClassesDao;

import Classes.Produtos;
import Classes.Vendas;
import com.GestaoInfocell.ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDao {
    private static final List<Produtos>Lista = new ArrayList<>();
    private final ConexaoJDBC conexao;
    private final Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ProdutoDao(){
        this.conexao = new ConexaoJDBC();
        this.conn = this.conexao.GetConexaoJDBC();
    }
    
    public List<Produtos>ListarProduto(){
        return Lista;
    }
    
    public List<Produtos>Listar(){
        String sql = "SELECT*FROM Produtos";
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Produtos>ListaProdutos = new ArrayList<>();
            while(rs.next()){
                Produtos novo = new Produtos();
                novo.setId(rs.getInt("idProdutos"));
                novo.setNome(rs.getString("Nome"));
                novo.setPreco(Float.parseFloat(rs.getString("Preco")));
                novo.setCategoria(rs.getString("Categoria"));
                novo.setDataCadastro(rs.getDate("DataCadastro"));
                ListaProdutos.add(novo);
            }
            return ListaProdutos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.conexao.CloseConection();
        }
        return null;
    }
    
    public List<Produtos> BuscarProdutoNome(String Nome){
        String sql = "SELECT*FROM Produtos WHERE nome LIKE ? ORDER BY Nome ASC;";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,Nome+"%");
            rs = ps.executeQuery();
            
            List<Produtos>ListaProduto = new ArrayList<>();
            
            while(rs.next()){
                Produtos produto = new Produtos();
                produto.setNome(rs.getString("Nome"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setPreco(rs.getFloat("Preco"));
                produto.setDataCadastro(rs.getDate("DataCadastro"));
                
                ListaProduto.add(produto);
                System.out.println("Produto Encontrado");
            }
            return ListaProduto;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Produto Não Encontrado !!");
            return null;
        }
        finally{
            this.conexao.CloseConection();
        }
    }
    
    public List<Produtos> BuscarProdutoCategoria(String Categoria){
        String sql = "SELECT*FROM Produtos WHERE Categoria LIKE ? ORDER BY Categoria ASC;";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,Categoria+"%");
            rs = ps.executeQuery();
            
            List<Produtos>ListaProduto = new ArrayList<>();
            
            while(rs.next()){
                Produtos produto = new Produtos();
                produto.setNome(rs.getString("Nome"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setPreco(rs.getFloat("Preco"));
                produto.setDataCadastro(rs.getDate("DataCadastro"));
                
                ListaProduto.add(produto);
                System.out.println("Produto Encontrado");
            }
            return ListaProduto;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Produto Não Encontrado !!");
            return null;
        }
        finally{
            this.conexao.CloseConection();
        }
    }
    
    public Produtos BuscarProdutonome(String Nome){
        String sql = " SELECT*FROM Produtos WHERE Nome = ? ";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Nome);
            rs = ps.executeQuery();
            if(rs.next()){
                Produtos produto = new Produtos();
                produto.setNome(rs.getString("Nome"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setTamanho(rs.getString("Tamanho"));
                produto.setPeso(rs.getString("Peso"));
                produto.setPreco(rs.getFloat("Preco"));
                produto.setDataCadastro(rs.getDate("DataCadastro"));
                return produto;
            }else{
                JOptionPane.showMessageDialog(null, "Produto não encontrado !!");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro, Produto Não encontrado");;
            return null;
        }finally{
            this.conexao.CloseConection();
        }
   }
   
    public void AdicionarListaCompra(Vendas venda){
        String sql = "INSERT INTO Venda (ProdutoVendido,Quantidade,ValorProduto,Total,DataVenda) VALUES (?,?,?,?,?) ";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,venda.getProdutoVendido());
            ps.setInt(2, venda.getQuantidade());
            ps.setFloat(3, venda.getValorProduto());
            ps.setFloat(4, venda.getTotal());
            ps.setDate(5, new java.sql.Date(venda.getDataVenda().getTime()));
            ps.execute();
            System.out.println("Produto adicionado om  sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao Adicionar Produto");
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int AdicionarProduto(Produtos produto){
        String sql = "INSERT INTO Produtos(Nome, Descricao, Categoria,Tamanho, Peso, Preco,DataCadastro) VALUES (?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getTamanho());
            ps.setString(5, produto.getPeso());
            ps.setFloat(6, produto.getPreco());
            ps.setString(7, sdf.format(produto.getDataCadastro()));
            ps.execute();
            System.out.println("Produto adicionado om  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao adicionar Produto !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
    }
    
     public int AlterarProduto(String Nome,Produtos produto){
       String sql = "UPDATE produtos SET Nome = ?,Descricao = ?,Categoria = ?,Tamanho = ?,Peso = ?,Preco = ?,DataCadastro = ? WHERE Nome = ?";
       try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getTamanho());
            ps.setString(5, produto.getPeso());
            ps.setFloat(6, produto.getPreco());
            ps.setDate(7,new java.sql.Date(produto.getDataCadastro().getTime()));
            ps.setString(8, Nome);

            ps.execute();
            System.out.println("Produto Alterado com  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao Alterar Produto !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
    }
   
    public int ExcluirProduto(Produtos produto){
       String sql = "DELETE FROM Produtos WHERE Nome = ?";
       try{
           ps = this.conn.prepareStatement(sql);
           ps.setString(1, produto.getNome());
           ps.execute();
           System.out.println("produto Excluido com sucesso");
           return 1;
       } catch (SQLException ex) {
            System.out.println("Erro ao deletar Produto");
            return 0;
        }finally{
           this.conexao.CloseConection();
       }
    }
}
