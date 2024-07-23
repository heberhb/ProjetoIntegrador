package ClassesDao;

import Classes.Clientes;
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

public class ClienteDao {
    private final ConexaoJDBC conexao;
    private final Connection conn;
    PreparedStatement ps = null;
    ResultSet rs;
    
    public ClienteDao(){
        this.conexao = new ConexaoJDBC();
        this.conn = this.conexao.GetConexaoJDBC();
    }
    
    public int AdicionarCliente(Clientes cliente){
        String sql = "INSERT INTO Cliente(Nome, Cpf, DataNascimento,Telefone, Celular, Email, Cep, Cidade, Estado, Rua, Numero, DataCadastro) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, sdf.format(cliente.getDataNascimento()));
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getCelular());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getCep());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getEstado());
            ps.setString(10, cliente.getRua());
            ps.setInt(11, cliente.getNumero());
            ps.setString(12, sdf.format(cliente.getDataCadastro()));
            ps.execute();
            System.out.println("Cliente adicionado om  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao adicionar cliente !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
    }
        
    public Clientes BuscarCliente(String nome){
        String sql = " SELECT*FROM cliente WHERE Nome = ? ";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setRua(rs.getString("Rua"));
                cliente.setNumero(rs.getInt("Numero"));
                cliente.setDataNascimento(rs.getDate("DataNascimento"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setCep(rs.getString("Cep"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setDataCadastro(rs.getDate("DataCadastro"));
                cliente.setTotalCompra(rs.getFloat("TotalCompras"));
                return cliente;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não encontrado !!");
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            this.conexao.CloseConection();
        }
   }
    
    public Clientes BuscarClienteCpf(String Cpf){
        String sql = " SELECT*FROM cliente WHERE Cpf = ? ";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Cpf);
            rs = ps.executeQuery();
            if(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setRua(rs.getString("Rua"));
                cliente.setNumero(rs.getInt("Numero"));
                cliente.setDataNascimento(rs.getDate("DataNascimento"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setCep(rs.getString("Cep"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setDataCadastro(rs.getDate("DataCadastro"));
                cliente.setTotalCompra(rs.getFloat("TotalCompras"));
                return cliente;
            }else{
                JOptionPane.showMessageDialog(null, "Cliente não encontrado !!");
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            this.conexao.CloseConection();
        }
   }
    
   public int atualizarCliente(int idCliente, float totalCompras) {
    String sql = "UPDATE Cliente SET TotalCompras = ? WHERE idCliente = ?";
    
    try {
        ps = this.conn.prepareStatement(sql);
        ps.setFloat(1, totalCompras); // Set the TotalCompras value
        ps.setInt(2, idCliente); // Set the id value
        ps.executeUpdate();
        System.out.println("Cadastro atualizado");
        return 1;
        
       }catch(SQLException e){
           System.out.println("Erro ao atualizar"+e.getMessage());
       }finally{
           this.conexao.CloseConection();
       }
        return 0;
   }
   
   public List<Clientes> ListaClientesNome(String Cliente){
        String sql = "select*from cliente WHERE Nome LIKE ? ORDER BY Nome ASC";        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%"+Cliente+"%");
            rs = ps.executeQuery();
            
            List<Clientes>ClientesFidelizados = new ArrayList<>();
            
            while(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setTotalCompra(rs.getFloat("TotalCompras"));
                cliente.setDataCadastro(rs.getDate("DataCadastro"));
                ClientesFidelizados.add(cliente);
            }
            return ClientesFidelizados;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente");
            return null;
        }finally{
            this.conexao.CloseConection();
        }
    }
   
   public List<Clientes> ListaClientesCpf(String Cpf){
        String sql = "select*from cliente WHERE Cpf LIKE ? ORDER BY Cpf ASC";        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, "%"+Cpf+"%");
            rs = ps.executeQuery();
            
            List<Clientes>ClientesFidelizados = new ArrayList<>();
            
            while(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setCpf(rs.getString("Cpf"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setTotalCompra(rs.getFloat("TotalCompras"));
                cliente.setDataCadastro(rs.getDate("DataCadastro"));
                ClientesFidelizados.add(cliente);
            }
            return ClientesFidelizados;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente");
            return null;
        }finally{
            this.conexao.CloseConection();
        }
    }
   
   public List<Clientes> ClientesFidelizados(){
        String sql = "select*from cliente where TotalCompras > 5000";
        
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<Clientes>ClientesFidelizados = new ArrayList<>();
            
            while(rs.next()){
                Clientes cliente = new Clientes();
                cliente.setNome(rs.getString("Nome"));
                cliente.setTotalCompra(rs.getFloat("TotalCompras"));
                cliente.setCelular(rs.getString("Celular"));
                ClientesFidelizados.add(cliente);
            }
            return ClientesFidelizados;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente");
            return null;
        }finally{
            this.conexao.CloseConection();
        }
    }
   
   public int AlterarCliente(String nome, Clientes cliente){
       String sql = "UPDATE Cliente SET Nome = ?,Cpf = ?,DataNascimento = ?,Telefone = ?,Celular = ?,Email = ?,Cep = ?,Cidade = ?,Estado = ?,Rua = ?,Numero = ?,DataCadastro = ? WHERE Nome = ?";
       try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getCelular());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getCep());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getEstado());
            ps.setString(10, cliente.getRua());
            ps.setInt(11, cliente.getNumero());
            ps.setDate(12,new java.sql.Date(cliente.getDataCadastro().getTime()));
            ps.setString(13, nome);

            ps.execute();
            System.out.println("Cliente Alterado com  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao Alterar cliente !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
    }
   
    public int ExcluirCliente(Clientes cliente){
       String sql = "DELETE FROM cliente WHERE Nome = ?";
       try{
           ps = this.conn.prepareStatement(sql);
           ps.setString(1, cliente.getNome());
           ps.execute();
           System.out.println("Cliente Excluido com sucesso");
           return 1;
       } catch (SQLException ex) {
            System.out.println("Erro ao deletar Cliente");
            return 0;
        }finally{
           this.conexao.CloseConection();
       }
    }
        
}
