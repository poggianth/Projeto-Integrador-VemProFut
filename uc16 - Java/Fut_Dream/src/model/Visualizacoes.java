package model;

/**
 *
 * @author Th
 */


public class Visualizacoes {
    private int idjogador;
    private int idclube;
    private String data; //date
    private int quantidade_visu;

    public Visualizacoes() {
    }

    public Visualizacoes(int idjogador, int idclube, String data, int quantidade_visu) {
        this.idjogador = idjogador;
        this.idclube = idclube;
        this.data = data;
        this.quantidade_visu = quantidade_visu;
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
}
