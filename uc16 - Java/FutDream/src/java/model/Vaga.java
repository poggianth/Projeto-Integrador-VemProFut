package model;

/**
 *
 * @author Th
 */


public class Vaga {
    private int idvaga;
    private int idclube;
    private String pais;
    private String estado;
    private String cidade;
    private String cep;
    private String bairro;
    private String nome_local;
    private String referencia;
    private String responsavel_vaga;
    private String posicao;
    private int sub_requisitado;
    private char sexo_requisitado;

    public Vaga() {
    }

    public Vaga(int idvaga, int idclube, String pais, String estado, String cidade, String cep, String bairro, String nome_local, String referencia, String responsavel_vaga, String posicao, int sub_requisitado, char sexo_requisitado) {
        this.idvaga = idvaga;
        this.idclube = idclube;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.nome_local = nome_local;
        this.referencia = referencia;
        this.responsavel_vaga = responsavel_vaga;
        this.posicao = posicao;
        this.sub_requisitado = sub_requisitado;
        this.sexo_requisitado = sexo_requisitado;
    }

    public int getIdvaga() {
        return idvaga;
    }

    public void setIdvaga(int idvaga) {
        this.idvaga = idvaga;
    }

    public int getIdclube() {
        return idclube;
    }

    public void setIdclube(int idclube) {
        this.idclube = idclube;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNome_local() {
        return nome_local;
    }

    public void setNome_local(String nome_local) {
        this.nome_local = nome_local;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getResponsavel_vaga() {
        return responsavel_vaga;
    }

    public void setResponsavel_vaga(String responsavel_vaga) {
        this.responsavel_vaga = responsavel_vaga;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getSub_requisitado() {
        return sub_requisitado;
    }

    public void setSub_requisitado(int sub_requisitado) {
        this.sub_requisitado = sub_requisitado;
    }

    public char getSexo_requisitado() {
        return sexo_requisitado;
    }

    public void setSexo_requisitado(char sexo_requisitado) {
        this.sexo_requisitado = sexo_requisitado;
    }
}
