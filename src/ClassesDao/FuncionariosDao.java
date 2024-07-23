package ClassesDao;

import Classes.Funcionarios;
import com.GestaoInfocell.ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionariosDao {
    private final ConexaoJDBC conexao;
    private final Connection conn;
    PreparedStatement ps = null;
    ResultSet rs;
    
    public FuncionariosDao(){
        this.conexao = new ConexaoJDBC();
        this.conn = this.conexao.GetConexaoJDBC();
    }
    
    public Funcionarios AutenticarUsuario(Funcionarios func){
        String sql = "SELECT*FROM Funcionarios WHERE Login = ? AND Senha = ?";
        Funcionarios funcionario = null;
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, func.getLogin());
            ps.setString(2, func.getSenha());
            rs = ps.executeQuery();
            
            if(rs.next()){
                funcionario = new Funcionarios();
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setLogin(rs.getString("Login"));
                funcionario.setSenha(rs.getString("Senha"));  
            }
            }catch(Exception ex){
                System.out.println("Error, Usuario não encontrado"+ex.getMessage());
            }finally{
            this.conexao.CloseConection();
        }
        return funcionario;
    }
    
    public List<Funcionarios> ListaFuncionariosNome(String Nome){
        String sql = "select*from Funcionarios WHERE Nome LIKE ? ORDER BY Nome ASC";        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Nome+"%");
            rs = ps.executeQuery();
            
            List<Funcionarios>ListaFuncionarios = new ArrayList<>();
            
            while(rs.next()){
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setNome(rs.getString("Nome"));
                funcionarios.setCpf(rs.getString("Cpf"));
                funcionarios.setDataNascimento(rs.getDate("DataNascimento"));
                funcionarios.setTelefone(rs.getString("Telefone"));
                funcionarios.setCelular(rs.getString("Celular"));
                funcionarios.setEmail(rs.getString("Email"));
                funcionarios.setCep(rs.getString("Cep"));
                funcionarios.setCidade(rs.getString("Cidade"));
                funcionarios.setEstado(rs.getString("Estado"));
                funcionarios.setRua(rs.getString("Rua"));
                funcionarios.setNumero(rs.getInt("Numero"));
                funcionarios.setDataInicio(rs.getDate("DataInicio"));
                funcionarios.setCargo(rs.getString("Cargo"));
                
                ListaFuncionarios.add(funcionarios);
            }
            return ListaFuncionarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Funcionario");
            return null;
        }finally{
            this.conexao.CloseConection();
        }
    }
    
    public List<Funcionarios> ListaFuncionariosCpf(String Cpf){
        String sql = "select*from Funcionarios WHERE Cpf LIKE ? ORDER BY Cpf ASC";        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Cpf+"%");
            rs = ps.executeQuery();
            
            List<Funcionarios>ListaFuncionarios = new ArrayList<>();
            
            while(rs.next()){
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setNome(rs.getString("Nome"));
                funcionarios.setCpf(rs.getString("Cpf"));
                funcionarios.setDataNascimento(rs.getDate("DataNascimento"));
                funcionarios.setTelefone(rs.getString("Telefone"));
                funcionarios.setCelular(rs.getString("Celular"));
                funcionarios.setEmail(rs.getString("Email"));
                funcionarios.setCep(rs.getString("Cep"));
                funcionarios.setCidade(rs.getString("Cidade"));
                funcionarios.setEstado(rs.getString("Estado"));
                funcionarios.setRua(rs.getString("Rua"));
                funcionarios.setNumero(rs.getInt("Numero"));
                funcionarios.setDataInicio(rs.getDate("DataInicio"));
                funcionarios.setCargo(rs.getString("Cargo"));
                
                ListaFuncionarios.add(funcionarios);
            }
            return ListaFuncionarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Funcionario");
            return null;
        }finally{
            this.conexao.CloseConection();
        }
    }
    
   public int CadastrarFuncionario(Funcionarios func){
       String sql = "INSERT INTO Funcionarios (Nome,Cpf,DataNascimento,Telefone,Celular,Email,Cep,Cidade,Estado,Rua,Numero,DataInicio,Cargo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
       try{
           ps = this.conn.prepareStatement(sql);
           ps.setString(1,func.getNome());
            ps.setString(2, func.getCpf());
            ps.setDate(3, new java.sql.Date(func.getDataNascimento().getTime()));
            ps.setString(4, func.getTelefone());
            ps.setString(5, func.getCelular());
            ps.setString(6, func.getEmail());
            ps.setString(7, func.getCep());
            ps.setString(8, func.getCidade());
            ps.setString(9, func.getEstado());
            ps.setString(10, func.getRua());
            ps.setInt(11, func.getNumero());
            ps.setDate(12,new java.sql.Date(func.getDataInicio().getTime()));
            ps.setString(13, func.getCargo());
           ps.execute();
           return 1;
       }catch(SQLException e){
           System.out.println("Funcionario não cadastrado !!"+e.getMessage());
           return 0;
       }finally{
           this.conexao.CloseConection();
       }
   }
   
   public Funcionarios BuscarFuncionarioNome(String Nome){
        String sql = " SELECT*FROM Funcionarios WHERE Nome = ? ";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Nome);
            rs = ps.executeQuery();
            if(rs.next()){
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setNome(rs.getString("Nome"));
                funcionarios.setCpf(rs.getString("Cpf"));
                funcionarios.setDataNascimento(rs.getDate("DataNascimento"));
                funcionarios.setTelefone(rs.getString("Telefone"));
                funcionarios.setCelular(rs.getString("Celular"));
                funcionarios.setEmail(rs.getString("Email"));
                funcionarios.setCep(rs.getString("Cep"));
                funcionarios.setCidade(rs.getString("Cidade"));
                funcionarios.setEstado(rs.getString("Estado"));
                funcionarios.setRua(rs.getString("Rua"));
                funcionarios.setNumero(rs.getInt("Numero"));
                funcionarios.setDataInicio(rs.getDate("DataInicio"));
                funcionarios.setCargo(rs.getString("Cargo"));
                return funcionarios;
            }else{
                JOptionPane.showMessageDialog(null, "Funcionario não encontrado !!");
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado !!"+ex.getMessage());
            return null;
        }finally{
            this.conexao.CloseConection();
        }
   }
       
    public int AlterarFuncionario(String nome, Funcionarios func){
       String sql = "UPDATE Funcionarios SET Nome = ?,Cpf = ?,DataNascimento = ?,Telefone = ?,Celular = ?,Email = ?,Cep = ?,Cidade = ?,Estado = ?,Rua = ?,Numero = ?,DataInicio = ?, Cargo = ? WHERE Nome = ?";
       try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,func.getNome());
            ps.setString(2, func.getCpf());
            ps.setDate(3, new java.sql.Date(func.getDataNascimento().getTime()));
            ps.setString(4, func.getTelefone());
            ps.setString(5, func.getCelular());
            ps.setString(6, func.getEmail());
            ps.setString(7, func.getCep());
            ps.setString(8, func.getCidade());
            ps.setString(9, func.getEstado());
            ps.setString(10, func.getRua());
            ps.setInt(11, func.getNumero());
            ps.setDate(12,new java.sql.Date(func.getDataInicio().getTime()));
            ps.setString(13, func.getCargo());
            ps.setString(14, nome);

            ps.execute();
            System.out.println("Funcionario Alterado com  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao Alterar Funcionario !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
   }
    
    public int ExcluirFuncionario(Funcionarios func){
       String sql = "DELETE FROM Funcionarios WHERE Nome = ?";
       try{
           ps = this.conn.prepareStatement(sql);
           ps.setString(1, func.getNome());
           ps.execute();
           System.out.println("Funcionario Excluido com sucesso");
           return 1;
       } catch (SQLException ex) {
            System.out.println("Erro ao deletar Funcionario");
            return 0;
        }finally{
           this.conexao.CloseConection();
       }
    }
}
