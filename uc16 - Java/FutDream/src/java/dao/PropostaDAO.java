package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Proposta;

/**
 *
 * @author Th
 */
public class PropostaDAO {
    private Connection con = null;
    
    public boolean create(Proposta proposta){
        con = MyConnection.getConnection();
        /*
            idproposta int AI PK 
idclube data codigo_acesso resposta
        */
        String sql = "insert into proposta(idclube, data, codigo_acesso, resposta) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, proposta.getIdclube());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(proposta.getData());
            java.sql.Date data = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(2, data);
            stmt.setInt(3, proposta.getCodigo_acesso());
            stmt.setInt(4, proposta.getResposta());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir Proposta: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Proposta> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from proposta";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Proposta> propostas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {    
                Proposta pro = new Proposta();
                pro.setIdproposta(rs.getInt("idproposta"));
                pro.setIdclube(rs.getInt("idclube"));
                pro.setData(rs.getDate("data").toString());
                pro.setCodigo_acesso(rs.getInt("codigo_acesso"));
                pro.setResposta(rs.getInt("resposta"));
                propostas.add(pro);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return propostas;
    }
    
    public boolean update(Proposta pro){
        con = MyConnection.getConnection();
        
        String sql = "update proposta set idclube=?, data=?, codigo_acesso=?, resposta=? where idproposta=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pro.getIdclube());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(pro.getData());
            java.sql.Date dt = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(2, dt);
            stmt.setInt(3, pro.getCodigo_acesso());
            stmt.setInt(4, pro.getResposta());
            stmt.setInt(5, pro.getIdproposta());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a Proposta: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from proposta where idproposta=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir a proposta: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
}
