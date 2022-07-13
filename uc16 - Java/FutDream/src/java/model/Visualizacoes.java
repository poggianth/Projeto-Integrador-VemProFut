package model;

/**
 *
 * @author Th
 */


public class Visualizacoes {
    private int idvisualizacoes;
    private int idjogador;
    private int idclube;
    private String data; //date
    private int quantidade_visu;

    public Visualizacoes() {
    }

    public Visualizacoes(int idvisualizacoes, int idjogador, int idclube, String data, int quantidade_visu) {
        this.idvisualizacoes = idvisualizacoes;
        this.idjogador = idjogador;
        this.idclube = idclube;
        this.data = data;
        this.quantidade_visu = quantidade_visu;
    }

    public int getIdvisualizacoes() {
        return idvisualizacoes;
    }

    public void setIdvisualizacoes(int idvisualizacoes) {
        this.idvisualizacoes = idvisualizacoes;
    }

    public int getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(int idjogador) {
        this.idjogador = idjogador;
    }

    public int getIdclube() {
        return idclube;
    }

    public void setIdclube(int idclube) {
        this.idclube = idclube;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade_visu() {
        return quantidade_visu;
    }

    public void setQuantidade_visu(int quantidade_visu) {
        this.quantidade_visu = quantidade_visu;
    }

    public void getIdvisualizacoes(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
