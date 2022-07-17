package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Experiencias;

/**
 *
 * @author Th
 */
public class ExperienciasDAO {
    private Connection con = null;
    
    public boolean create(Experiencias experiencia){
        con = MyConnection.getConnection();
        
        String sql = "insert into experiencias(nome_clube, estado, cidade, posicao, inicio, fim, conquistas, idjogador) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, experiencia.getNome_clube());
            stmt.setString(2, experiencia.getEstado());
            stmt.setString(3, experiencia.getCidade());
            stmt.setString(4, experiencia.getPosicao());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(experiencia.getInicio());
            java.sql.Date inicio = new java.sql.Date(dtNasc.getTime());
           
            stmt.setDate(5, inicio);
           
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtfim = format.parse(experiencia.getInicio());
            java.sql.Date fim = new java.sql.Date(dtfim.getTime());
            
            stmt.setDate(6, fim);
            
            stmt.setString(7, experiencia.getConquistas());
            stmt.setInt(8, experiencia.getIdjogador());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível inserir uma Experiência: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }   
    }
    
    public List<Experiencias> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from experiencias";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Experiencias> experienciass = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {         
                Experiencias exp = new Experiencias();
                exp.setIdexperiencias(rs.getInt("idexperiencias"));
                exp.setNome_clube(rs.getString("nome_clube"));
                exp.setEstado(rs.getString("estado"));
                exp.setCidade(rs.getString("cidade"));
                exp.setPosicao(rs.getString("posicao"));
                exp.setInicio(rs.getString("inicio"));
                exp.setFim(rs.getString("fim"));
                exp.setConquistas(rs.getString("conquistas"));
                exp.setIdjogador(rs.getInt("idjgador"));
                experienciass.add(exp);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível selecionar a Experiência: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return experienciass;
    }
    
    public boolean update(Experiencias exp){
        con = MyConnection.getConnection();
        
        String sql = "update experiencias set nome_clube=?, estado=?, cidade=?, posicao=?, inicio=?, fim=?, conquistas=?, idjogador=? where idexperiencias=?";
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, exp.getNome_clube());
            stmt.setString(2, exp.getEstado());
            stmt.setString(3, exp.getCidade());
            stmt.setString(4, exp.getPosicao());

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(exp.getInicio());
            java.sql.Date inicio = new java.sql.Date(dtNasc.getTime());

            stmt.setDate(5, inicio);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtfim = format.parse(exp.getInicio());
            java.sql.Date fim = new java.sql.Date(dtfim.getTime());

            stmt.setDate(6, fim);

            stmt.setString(7, exp.getConquistas());
            stmt.setInt(8, exp.getIdjogador());
            stmt.setInt(9, exp.getIdexperiencias());

            stmt.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println("[ERRO] Não foi possível atualizar a Experiência: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from experiencias where idexperiencias=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir a Experiência: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
