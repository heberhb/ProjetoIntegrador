package ClassesDao;

import Classes.Vendas;
import com.GestaoInfocell.ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VendasDao {
    private final ConexaoJDBC Conexao;
    private final Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public VendasDao() {
        this.Conexao = new ConexaoJDBC();
        this.conn = this.Conexao.GetConexaoJDBC();
    }
    
    public int CadastrarVendas(Vendas venda){
        if(this.conn == null){
            System.out.println("Erro ao conectar no banco de dados");
        }
        String sql = "INSERT INTO Venda (ProdutoVendido, Quantidade, ValorProduto, Total, DataVenda) VALUES (?,?,?,?,?) ";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, venda.getProdutoVendido());
            ps.setInt(2, venda.getQuantidade());
            ps.setFloat(3,venda.getValorProduto());
            ps.setFloat(4, venda.getTotal());
            ps.setString(5, sdf.format(venda.getDataVenda()));
            ps.execute();
            System.out.println("Venda cadastrada");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Falha ao Cadastrar venda!! "+ex.getMessage());
            return 0;
        }
    }
    
    public Vendas BuscarVenda(String Nome){
        String sql = "SELECT*FROM Venda WHERE Nome = ? ";
        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Nome);
            rs = ps.executeQuery();
            if(rs.next()){
                Vendas venda = new Vendas();
                venda.setProdutoVendido(rs.getString("ProdutoVendido"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                venda.setTotal(rs.getFloat("Total"));
                System.out.println("Venda encontrada");
                return venda;
            }
        } catch (SQLException ex) {
            System.out.println("Venda não Encontrada!! "+ex.getMessage());
            return null;
        }finally{
            this.Conexao.CloseConection();
        }
        return null;
    }
    
    public List<Vendas>ListaMaisVendidos(){
        String sql = "SELECT*FROM Venda Order By Quantidade DESC";
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<Vendas>ListaMaisVendidos = new ArrayList<>();
            
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setProdutoVendido(rs.getString("ProdutoVendido"));
                venda.setValorProduto(rs.getFloat("ValorProduto"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                
                ListaMaisVendidos.add(venda);
            }
            return ListaMaisVendidos;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar a lista Mais Vendidos");
        }
        return null;
    }
    
    public List<Vendas>ListaVendidos(){
        String sql = "SELECT*FROM Venda WHERE idVenda ORDER BY ValorProduto ASC";
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<Vendas>ListaMaisVendidos = new ArrayList<>();
            
            while(rs.next()){
                Vendas venda = new Vendas();
                venda.setProdutoVendido(rs.getString("ProdutoVendido"));
                venda.setValorProduto(rs.getFloat("ValorProduto"));
                venda.setQuantidade(rs.getInt("Quantidade"));
                
                ListaMaisVendidos.add(venda);
            }
            return ListaMaisVendidos;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar a lista Mais Vendidos");
        }
        return null;
    }
    
    public Float ValorTotalDia(){
        String sql = "SELECT SUM(Total) AS TotalVendasDia FROM Venda WHERE DataVenda = CURDATE()";
        Float TotalVenda = null;
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                TotalVenda = rs.getFloat("TotalVendasDia");
                System.out.println("Total Vendas do Dia :"+ TotalVenda);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar total venda");
            return null;
        }finally{
            this.Conexao.CloseConection();
        }
        return TotalVenda;
    }
    
    public Float ValorTotalSemana(){
        String sql = "SELECT sum(Total) AS TotalVenda FROM Venda WHERE datavenda >= CURDATE() - INTERVAL DAYOFWEEK(CURDATE())+6 DAY AND datavenda <= CURDATE() - INTERVAL DAYOFWEEK(CURDATE())-1 DAY";
        Float TotalVendaSemana = null;
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                TotalVendaSemana = rs.getFloat("TotalVenda");
                System.out.println("Total Vendas do Dia :"+ TotalVendaSemana);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar total venda");
            return null;
        }finally{
            this.Conexao.CloseConection();
        }
        return TotalVendaSemana;
    }
}
