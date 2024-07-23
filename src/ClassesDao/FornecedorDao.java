package ClassesDao;

import Classes.Fornecedores;
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

public class FornecedorDao {
    private final ConexaoJDBC conexao;
    private final Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public FornecedorDao(){
        this.conexao = new ConexaoJDBC();
        this.conn = this.conexao.GetConexaoJDBC();
    }
    
    public int CadastroFornecedor(Fornecedores fornecedor){
        String sql = "INSERT INTO Fornecedor(Empresa,Categoria,Cnpj,Telefone,Celular,Email,Cep,Cidade,Estado,Rua,Numero, DataInicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,fornecedor.getEmpresa()); 
            ps.setString(2, fornecedor.getCategoria());
            ps.setString(3, fornecedor.getCnpj());
            ps.setString(4, fornecedor.getTelefone());
            ps.setString(5, fornecedor.getCelular());
            ps.setString(6, fornecedor.getEmail());
            ps.setString(7, fornecedor.getCep());
            ps.setString(8, fornecedor.getCidade());
            ps.setString(9, fornecedor.getEstado());
            ps.setString(10, fornecedor.getRua());
            ps.setInt(11, fornecedor.getNumero());
            ps.setDate(12, new java.sql.Date(fornecedor.getDataInicio().getTime()));
            ps.execute();
            System.out.println("Fornecedor adicionado com  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao adicionar Fornecedor !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
    }
    
    public Fornecedores BuscarFornecedorEmpresa(String Empresa){
        String sql = " SELECT*FROM Fornecedor WHERE Empresa LIKE ? ORDER BY Empresa ASC";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1, Empresa);
            rs = ps.executeQuery();
            if(rs.next()){
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setEmpresa(rs.getString("Empresa"));
                fornecedor.setCategoria(rs.getString("Categoria"));
                fornecedor.setCnpj(rs.getString("Cnpj"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setCelular(rs.getString("Celular"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setCep(rs.getString("Cep"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setRua(rs.getString("Rua"));
                fornecedor.setNumero(Integer.parseInt(rs.getString("Numero")));
                fornecedor.setDataInicio((rs.getDate("DataInicio")));
                return fornecedor;
            }else{
                JOptionPane.showMessageDialog(null, "Empresa não encontrado !!");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro, Empresa Não encontrado"+ex.getMessage());;
            return null;
        }finally{
            this.conexao.CloseConection();
        }
   }
    
    public List<Fornecedores>ListarEmpresa(String Empresa){
        String sql = "SELECT*FROM Fornecedor WHERE Empresa LIKE ? ORDER BY Empresa ASC";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,Empresa+"%");
            rs = ps.executeQuery();
            List<Fornecedores>ListaFornecedores = new ArrayList<>();
            while(rs.next()){
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setEmpresa(rs.getString("Empresa"));
                fornecedor.setCategoria(rs.getString("Categoria"));
                fornecedor.setCnpj(rs.getString("Cnpj"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setCelular(rs.getString("Celular"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setCep(rs.getString("Cep"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setRua(rs.getString("Rua"));
                fornecedor.setNumero(Integer.parseInt(rs.getString("Numero")));
                fornecedor.setDataInicio((rs.getDate("DataInicio")));
                ListaFornecedores.add(fornecedor);
            }
            return ListaFornecedores;            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.conexao.CloseConection();
        }
        return null;
    }
    
    public List<Fornecedores>ListarCnpj(String Cnpj){
        String sql = "SELECT*FROM Fornecedor WHERE Cnpj LIKE ? ORDER BY Cnpj ASC";
        try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,Cnpj+"%");
            rs = ps.executeQuery();
            List<Fornecedores>ListaFornecedores = new ArrayList<>();
            while(rs.next()){
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setEmpresa(rs.getString("Empresa"));
                fornecedor.setCategoria(rs.getString("Categoria"));
                fornecedor.setCnpj(rs.getString("Cnpj"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setCelular(rs.getString("Celular"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setCep(rs.getString("Cep"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setRua(rs.getString("Rua"));
                fornecedor.setNumero(Integer.parseInt(rs.getString("Numero")));
                fornecedor.setDataInicio((rs.getDate("DataInicio")));
                ListaFornecedores.add(fornecedor);
            }
            return ListaFornecedores;            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.conexao.CloseConection();
        }
        return null;
    }
    
    public List<Fornecedores>TabelaFornecedor(){
        String sql = "SELECT*FROM Fornecedor ORDER BY Empresa ASC";
        try{
            ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Fornecedores>ListaFornecedores = new ArrayList<>();
            while(rs.next()){
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setEmpresa(rs.getString("Empresa"));
                fornecedor.setCategoria(rs.getString("Categoria"));
                fornecedor.setCnpj(rs.getString("Cnpj"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setCelular(rs.getString("Celular"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedor.setCep(rs.getString("Cep"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setEstado(rs.getString("Estado"));
                fornecedor.setRua(rs.getString("Rua"));
                fornecedor.setNumero(Integer.parseInt(rs.getString("Numero")));
                fornecedor.setDataInicio((rs.getDate("DataInicio")));
                ListaFornecedores.add(fornecedor);
            }
            return ListaFornecedores;            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.conexao.CloseConection();
        }
        return null;
    }
    
    public int AlterarFornecedor(String Nome,Fornecedores fornecedor){
       String sql = "UPDATE Fornecedor SET Empresa = ?,Categoria = ?,Cnpj = ?,Telefone = ?,Celular = ?,Email = ?,Cep = ?,Cidade = ?,Estado = ?,Rua = ?,Numero = ?, DataInicio = ? WHERE Empresa = ?";
       try{
            ps = this.conn.prepareStatement(sql);
            ps.setString(1,fornecedor.getEmpresa()); 
            ps.setString(2, fornecedor.getCategoria());
            ps.setString(3, fornecedor.getCnpj());
            ps.setString(4, fornecedor.getTelefone());
            ps.setString(5, fornecedor.getCelular());
            ps.setString(6, fornecedor.getEmail());
            ps.setString(7, fornecedor.getCep());
            ps.setString(8, fornecedor.getCidade());
            ps.setString(9, fornecedor.getEstado());
            ps.setString(10, fornecedor.getRua());
            ps.setInt(11, fornecedor.getNumero());
            ps.setDate(12, new java.sql.Date(fornecedor.getDataInicio().getTime()));
            ps.setString(13, Nome);

            ps.execute();
            System.out.println("Fornecedor Alterado com  sucesso");
            return 1;
        }catch(SQLException e){
            System.out.println("Erro ao Alterar Fornecedor !!"+e.getMessage());
            return 0;
        }finally{
            conexao.CloseConection();
        }
    }
    
    public int ExcluirFornecedor(Fornecedores fornecedor){
       String sql = "DELETE FROM Fornecedor WHERE Empresa = ?";
       try{
           ps = this.conn.prepareStatement(sql);
           ps.setString(1, fornecedor.getEmpresa());
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
