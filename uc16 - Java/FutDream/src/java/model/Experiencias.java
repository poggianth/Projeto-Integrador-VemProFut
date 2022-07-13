package model;

/**
 *
 * @author Th
 */

public class Experiencias {
    private int idexperiencias;
    private String nome_clube;
    private String estado;
    private String cidade;
    private String posicao;
    private String inicio; //date
    private String fim; //date
    private String conquistas;
    private int idjogador;

    public Experiencias() {
    }

    public Experiencias(int idexperiencias, String nome_clube, String estado, String cidade, String posicao, String inicio, String fim, String conquistas, int idjogador) {
        this.idexperiencias = idexperiencias;
        this.nome_clube = nome_clube;
        this.estado = estado;
        this.cidade = cidade;
        this.posicao = posicao;
        this.inicio = inicio;
        this.fim = fim;
        this.conquistas = conquistas;
        this.idjogador = idjogador;
    }

    public int getIdexperiencias() {
        return idexperiencias;
    }

    public void setIdexperiencias(int idexperiencias) {
        this.idexperiencias = idexperiencias;
    }

    public String getNome_clube() {
        return nome_clube;
    }

    public void setNome_clube(String nome_clube) {
        this.nome_clube = nome_clube;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getConquistas() {
        return conquistas;
    }

    public void setConquistas(String conquistas) {
        this.conquistas = conquistas;
    }

    public int getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(int idjogador) {
        this.idjogador = idjogador;
    }
    
    
    
}
