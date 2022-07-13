
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MyConnection {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_futdream";
    private static final String USER = "root";
    private static final String PASS = "123456";
    
    //Criando método para conectar com o Banco de Dados
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println("Erro ao tentar conectar o Banco de Dados! " + erro);
            throw new RuntimeException("Erro ao tentar conectar o Banco de Dados! ", erro);
        }
    }
    
    //Criando método para fechar apenas o Connection
    public static void closeConnection(Connection con){
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Erro ao tentar fechar o Banco de Dados! " + e);
            }
        }
    }
    
    //Método para fechar o Connection e o PreparedStatement
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Erro ao tentar fechar o Statement! " + e);
            }
        }
        closeConnection(con);
    }
    
    
    //Método para fechar o Connection, PreparedStatement e o ResultSet
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Erro ao tentar fechar o ResultSet! " + e);
            }
        }
        closeConnection(con, stmt);
    }
}
