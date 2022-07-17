package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Clube;

/**
 *
 * @author Th
 */
public class ClubeDAO {
    private Connection con = null;
    
    public boolean create(Clube clube){
        con = MyConnection.getConnection();
        
        String sql = "insert into clube(razao, fantasia, data_fundacao, pais, estado, cidade, cep, telefone, email, cnpj, sobre, responsavel_cadastro) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, clube.getRazao());
            stmt.setString(2, clube.getFantasia());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(clube.getData_fundacao());
            java.sql.Date dt_fundacao = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(3, dt_fundacao);
            stmt.setString(4, clube.getPais());
            stmt.setString(5, clube.getEstado());
            stmt.setString(6, clube.getCidade());
            stmt.setString(7, clube.getCep());
            stmt.setString(8, clube.getTelefone());
            stmt.setString(9, clube.getEmail());
            stmt.setString(10, clube.getCnpj());
            stmt.setString(11, clube.getSobre());
            stmt.setString(12, clube.getResponsavel_cadastro());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir Clube: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Clube> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from clube";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Clube> clubes = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {    
                Clube clu = new Clube();
                clu.setIdclube(rs.getInt("idclube"));
                clu.setRazao(rs.getString("razao"));
                clu.setFantasia(rs.getString("fantasia"));
                clu.setData_fundacao(rs.getDate("data_fundacao").toString());
                clu.setPais(rs.getString("pais"));
                clu.setEstado(rs.getString("estado"));
                clu.setCidade(rs.getString("cidade"));
                clu.setCep(rs.getString("cep"));
                clu.setTelefone(rs.getString("telefone"));
                clu.setEmail(rs.getString("email"));
                clu.setCnpj(rs.getString("cnpj"));
                clu.setSobre(rs.getString("sobre"));
                clu.setResponsavel_cadastro(rs.getString("responsavel_cadastro"));
                clubes.add(clu);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return clubes;
    }
    
    public boolean update(Clube clu){
        con = MyConnection.getConnection();
        
        String sql = "update clube set razao=?, fantasia=?, data_fundacao=?, pais=?, estado=?, cidade=?, cep=?, telefone=?, email=?, cnpj=?, sobre=?, responsavel_cadastro=? where idclube=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, clu.getRazao());
            stmt.setString(2, clu.getFantasia());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(clu.getData_fundacao());
            java.sql.Date dt_fundacao = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(3, dt_fundacao);
            stmt.setString(4, clu.getPais());
            stmt.setString(5, clu.getEstado());
            stmt.setString(6, clu.getCidade());
            stmt.setString(7, clu.getCep());
            stmt.setString(8, clu.getTelefone());
            stmt.setString(9, clu.getEmail());
            stmt.setString(10, clu.getCnpj());
            stmt.setString(11, clu.getSobre());
            stmt.setString(12, clu.getResponsavel_cadastro());
            stmt.setInt(13, clu.getIdclube());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Clube: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from clube where idclube=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir o clube: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
}
