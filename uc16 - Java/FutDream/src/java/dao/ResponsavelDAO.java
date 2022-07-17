package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Responsavel;

/**
 *
 * @author Th
 */
public class ResponsavelDAO {
    private Connection con = null;
    
    public boolean create(Responsavel responsavel){
        con = MyConnection.getConnection();
        
        String sql = "insert into responsavel(nome, data_nasc, sexo, telefone, email, nacionalidade, estado, cidade, cep, idresponsavel) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, responsavel.getNome());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(responsavel.getData_nasc());
            java.sql.Date dt_nascimento = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(2, dt_nascimento);
            stmt.setInt(3, responsavel.getSexo());
            stmt.setString(4, responsavel.getTelefone());
            stmt.setString(5, responsavel.getEmail());
            stmt.setString(6, responsavel.getNacionalidade());
            stmt.setString(7, responsavel.getEstado());
            stmt.setString(8, responsavel.getCidade());
            stmt.setString(9, responsavel.getCep());
            stmt.setInt(10, responsavel.getIdresponsavel());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir Responsavel: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Responsavel> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from responsavel";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Responsavel> responsaveis = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {     
                Responsavel res = new Responsavel();
                res.setIdresponsavel(rs.getInt("idresponsavel"));
                res.setNome(rs.getString("nome"));
                res.setData_nasc(rs.getDate("data_nasc").toString());
                
                char sex = '.';
                if ("F".equals(rs.getString("sexo"))) {
                    sex = 'F';
                } else if("M".equals(rs.getString("sexo"))){
                    sex = 'M';
                }
                
                res.setSexo(sex);
                res.setTelefone(rs.getString("telefone"));
                res.setEmail(rs.getString("email"));
                res.setNacionalidade(rs.getString("nacionalidade"));
                res.setEstado(rs.getString("estado"));
                res.setCidade(rs.getString("cidade"));
                res.setCep(rs.getString("cep"));
                res.setIdresponsavel(rs.getInt("idresponsavel"));
                responsaveis.add(res);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return responsaveis;
    }
    
    public boolean update(Responsavel res){
        con = MyConnection.getConnection();
        
        String sql = "update responsavel set nome=?, data_nasc=?, sexo=?, telefone=?, email=?, nacionalidade=?, estado=?, cidade=?, cep=?, idjogador=? where idresponsavel=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, res.getNome());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(res.getData_nasc());
            java.sql.Date nascimento = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(2, nascimento);            
            stmt.setInt(3, res.getSexo());
            stmt.setString(4, res.getTelefone());
            stmt.setString(5, res.getEmail());
            stmt.setString(6, res.getNacionalidade());
            stmt.setString(7, res.getEstado());
            stmt.setString(8, res.getCidade());
            stmt.setString(9, res.getCep());
            stmt.setInt(10, res.getIdjogador());
            stmt.setInt(11, res.getIdresponsavel());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o Responsavel: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from responsavel where idresponsavel=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir o responsável: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
}
