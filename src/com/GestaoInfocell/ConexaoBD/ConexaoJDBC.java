package com.GestaoInfocell.ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConexaoJDBC {
        
           private final String url = "jdbc:mysql://LocalHost:3306/gestaoinfocell";
           private final  String user = "root";
           private final  String Senha = "19101992";
           Connection conn;

   public Connection GetConexaoJDBC(){
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Conexão com drive bem sucedida");
        conn = DriverManager.getConnection(url,user,Senha);
        System.out.println("Conexão com banco de dados efetuada");
        
        }catch (ClassNotFoundException | SQLException e) {
               System.out.println("Erro na conexão com Banco de dados"+e.getMessage());
               return null;
        }
        return conn;
   }
   
   public void CloseConection(){
       try{
       if(conn != null && !conn.isClosed()){
           conn.close();
           System.out.println(" Banco de dados desconectado");
       }
       }catch (SQLException ex) {
           System.out.println("Não foi possível desconectar do banco de dados");
       }
   }
   
   public Connection GetConexao(){
       return conn;
   }
}
