package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Jogador;

/**
 *
 * @author Th
 */
public class JogadorDAO {
    private Connection con = null;
    
    public boolean create(Jogador jogador){
        con = MyConnection.getConnection();
        
        /*
        
        idjogador
nome data_nasc sexo telefone email nacionalidade estado cidade cep posicao_principal posicao_secundaria altura peso 
        */
        
        String sql = "insert into jogador(nome, data_nasc, sexo, telefone, email, nacionalidade, estado, cidade, cep, posicao_principal, posicao_secundaria, altura, peso) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, jogador.getNome());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(jogador.getData_nasc());
            java.sql.Date dt_nascimento = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(2, dt_nascimento);
            stmt.setInt(3, jogador.getSexo());
            stmt.setString(4, jogador.getTelefone());
            stmt.setString(5, jogador.getEmail());
            stmt.setString(6, jogador.getNacionalidade());
            stmt.setString(7, jogador.getEstado());
            stmt.setString(8, jogador.getCidade());
            stmt.setString(9, jogador.getCep());
            stmt.setString(10, jogador.getPosicao_principal());
            stmt.setString(11, jogador.getPosicao_secundaria());
            stmt.setFloat(12, jogador.getAltura());
            stmt.setFloat(13, jogador.getPeso());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha ao Inserir jogador: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Jogador> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from jogador";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jogador> jogadores = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {    
                
                      /*
        
        idjogador
nome data_nasc sexo telefone email nacionalidade estado cidade cep posicao_principal posicao_secundaria altura peso 
        */
                      
                Jogador jog = new Jogador();
                jog.setIdjogador(rs.getInt("idjogador"));
                jog.setNome(rs.getString("nome"));
                jog.setData_nasc(rs.getDate("data_nasc").toString());
                
                char sex = '.';
                if ("F".equals(rs.getString("sexo"))) {
                    sex = 'F';
                } else if("M".equals(rs.getString("sexo"))){
                    sex = 'M';
                }
                
                jog.setSexo(sex);
                jog.setTelefone(rs.getString("telefone"));
                jog.setEmail(rs.getString("email"));
                jog.setNacionalidade(rs.getString("nacionalidade"));
                jog.setEstado(rs.getString("estado"));
                jog.setCidade(rs.getString("cidade"));
                jog.setCep(rs.getString("cep"));
                jog.setPosicao_principal(rs.getString("posicao_principal"));
                jog.setPosicao_secundaria(rs.getString("posicao_secundaria"));
                jog.setAltura(rs.getFloat("altura"));
                jog.setPeso(rs.getFloat("peso"));
                jogadores.add(jog);
            }
        } catch (Exception e) {
            System.out.println("[ERRO] Alguma coisa não saiu conforme o planejado: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return jogadores;
    }
    
    public boolean update(Jogador jog){
        con = MyConnection.getConnection();
        
        String sql = "update jogador set nome=?, data_nasc=?, sexo=?, telefone=?, email=?, nacionalidade=?, estado=?, cidade=?, cep=?, posicao_principal=?, posicao_secundaria=?, altura=?, peso=? where idjogador=?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, jog.getNome());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dtNasc = formato.parse(jog.getData_nasc());
            java.sql.Date nascimento = new java.sql.Date(dtNasc.getTime());
            
            stmt.setDate(2, nascimento);            
            stmt.setInt(3, jog.getSexo());
            stmt.setString(4, jog.getTelefone());
            stmt.setString(5, jog.getEmail());
            stmt.setString(6, jog.getNacionalidade());
            stmt.setString(7, jog.getEstado());
            stmt.setString(8, jog.getCidade());
            stmt.setString(9, jog.getCep());
            stmt.setString(10, jog.getPosicao_principal());
            stmt.setString(11, jog.getPosicao_secundaria());
            stmt.setFloat(12, jog.getAltura());
            stmt.setFloat(13, jog.getPeso());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o jogador: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from jogador where idjogador=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível excluir o jogador: " + e);
            return false;
        } finally{
            MyConnection.closeConnection(con, stmt);
        }
    }
}
