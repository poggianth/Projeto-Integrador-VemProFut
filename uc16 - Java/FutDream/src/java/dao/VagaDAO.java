package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Vaga;

/**
 *
 * @author Th
 */
public class VagaDAO {
    private Connection con = null;
    
    public boolean create(Vaga vaga){
        con = MyConnection.getConnection();
        
        /*
        idvaga int AI PK 
idclube pais estado cidade cep bairro nome_local referencia responsavel_vaga posicao sub_requisitado sexo_requisitado 
        */
        String sql = "insert into vaga(idclube, pais, estado, cidade, cep, bairro, nome_local, referencia, responsavel_vaga, posicao, sub_requisitado, sexo_requisitado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, vaga.getIdclube());
            stmt.setString(2, vaga.getPais());
            stmt.setString(3, vaga.getEstado());
            stmt.setString(4, vaga.getCidade());
            stmt.setString(5, vaga.getCep());
            stmt.setString(6, vaga.getBairro());
            stmt.setString(7, vaga.getNome_local());
            stmt.setString(8, vaga.getReferencia());
            stmt.setString(9, vaga.getResponsavel_vaga());
            stmt.setString(10, vaga.getPosicao());
            stmt.setInt(11, vaga.getSub_requisitado());
            stmt.setInt(12, vaga.getSexo_requisitado());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir a Vaga: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Vaga> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from vaga";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vaga> vagas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                      
                Vaga vag = new Vaga();
                vag.setIdvaga(rs.getInt("idvaga"));
                vag.setIdclube(rs.getInt("idclube"));
                vag.setPais(rs.getString("pais"));
                vag.setEstado(rs.getString("estado"));
                vag.setCidade(rs.getString("cidade"));
                vag.setCep(rs.getString("cep"));
                vag.setBairro(rs.getString("bairro"));
                vag.setNome_local(rs.getString("nome_local"));
                vag.setReferencia(rs.getString("referencia"));
                vag.setResponsavel_vaga(rs.getString("responsavel_vaga"));
                vag.setPosicao(rs.getString("posicao"));
                vag.setSub_requisitado(rs.getInt("sub_requisitado"));
                
                char sex = '.';
                if ("F".equals(rs.getString("sexo_requisitado"))) {
                    sex = 'F';
                } else if("M".equals(rs.getString("sexo_requisitado"))){
                    sex = 'M';
                }
                vag.setSexo_requisitado(sex);
                vagas.add(vag);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return vagas;
    }
    
    public boolean update(Vaga vag){
        con = MyConnection.getConnection();
        
        String sql = "update vaga set idclube=?, pais=?, estado=?, cidade=?, cep=?, bairro=?, nome_local=?, referencia=?, responsavel_vaga=?, posicao=?, sub_requisitado=?, sexo_requisitado=? where idvaga=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, vag.getIdclube());
            stmt.setString(2, vag.getPais());            
            stmt.setString(3, vag.getEstado());
            stmt.setString(4, vag.getCidade());
            stmt.setString(5, vag.getCep());
            stmt.setString(6, vag.getBairro());
            stmt.setString(7, vag.getNome_local());
            stmt.setString(8, vag.getReferencia());
            stmt.setString(9, vag.getResponsavel_vaga());
            stmt.setString(10, vag.getPosicao());
            stmt.setInt(11, vag.getSub_requisitado());
            stmt.setInt(12, vag.getSexo_requisitado());
            stmt.setInt(13, vag.getIdvaga());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o vaga: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from vaga where idvaga=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir a vaga: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
}
