package ClassesDao;

import Classes.Cargo;
import Classes.Funcionarios;
import com.GestaoInfocell.ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoDao {
    private final ConexaoJDBC conexao;
    private final Connection em;
    PreparedStatement ps;
    ResultSet rs;
    
    public CargoDao(){
        this.conexao = new ConexaoJDBC();
        this.em = this.conexao.GetConexaoJDBC();
    }
    
    public List<Cargo>getLista(){
        String sql = "SELECT*FROM Cargo";
        try{
            ps = this.em.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Cargo>ListaConta = new ArrayList<>();
            while(rs.next()){
                Cargo conta = new Cargo();
                conta.setId(rs.getInt("idCargo"));
                conta.setFuncao(rs.getString("Funcao"));
                conta.setTipo(rs.getString("Tipo"));
                ListaConta.add(conta);
            }
            return ListaConta;
        } catch (SQLException ex) {
            Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
