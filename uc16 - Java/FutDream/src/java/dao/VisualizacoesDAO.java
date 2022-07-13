package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Visualizacoes;

/**
 *
 * @author Th
 */
public class VisualizacoesDAO {
    private Connection con = null;
    
    public boolean create(Visualizacoes visualizacao){
        con = MyConnection.getConnection();
        
        String sql = "insert into visualizacoes(idvisualizacoes, idjogador, idclube, data, quantidade_visu) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareCall(sql);
            stmt.setInt(1, visualizacao.getIdvisualizacoes());
            stmt.setInt(2, visualizacao.getIdjogador());
            stmt.setInt(3, visualizacao.getIdclube());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dt = formato.parse(visualizacao.getData());
            java.sql.Date data = new java.sql.Date(dt.getTime());
            
            stmt.setDate(4, data);
            stmt.setInt(5, visualizacao.getQuantidade_visu());
            stmt.executeUpdate();
            return true;            
        } catch (Exception e) {
            System.out.println("[ERRO] Algo deu errado na hora de inserir uma Visualização: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public List<Visualizacoes> read(){
        con = MyConnection.getConnection();
        
        String sql = "select * from visualizacoes";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Visualizacoes> visualizacoesss = new ArrayList<>();
        
        try{
            //idvisualizacoes, idjogador, idclube, data, quantidade_visu
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Visualizacoes visu = new Visualizacoes();
                visu.setIdvisualizacoes(rs.getInt("idvisualizacoes"));
                visu.setIdjogador(rs.getInt("idjogador"));
                visu.setIdclube(rs.getInt("idclube"));
                visu.setData(rs.getDate("data").toString());
                visu.setQuantidade_visu(rs.getInt("quantidade_visu"));
                visualizacoesss.add(visu);
            }
        } catch (Exception e){
            System.out.println("[ERRO] Ao selecionar a Visualizações: " + e);
        } finally{
            MyConnection.closeConnection(con, stmt, rs);
        }
        return visualizacoesss;
    }
    
    public boolean update(Visualizacoes visu){
        con = MyConnection.getConnection();
        
        String sql = "update visualizacoes set idjogador=?, idclube=?, data=?, quantidade_visu=? where idvisualizacoes=?";
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, visu.getIdjogador());
            stmt.setInt(2, visu.getIdclube());
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dt = formato.parse(visu.getData());
            java.sql.Date data = new java.sql.Date(dt.getTime());
            
            stmt.setDate(3, data);
            stmt.setInt(4, visu.getQuantidade_visu());
            stmt.setInt(5, visu.getIdvisualizacoes());
            return true;
        } catch (Exception e){
            System.out.println("[ERRO] Não foi possível atualizar a Visualização: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(int id){
        con = MyConnection.getConnection();
        
        String sql = "delete from visualizacoes where idvisualizacoes=?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("[ERRO] ao exluir uma Visualizacoes: " + e);
            return false;
        } finally {
            MyConnection.closeConnection(con, stmt);
        }
    }
}
