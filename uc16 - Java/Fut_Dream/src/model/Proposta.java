package model;

/**
 *
 * @author Th
 */


public class Proposta {
    private int idproposta;
    private int idclube;
    private String data; //date
    private int codigo_acesso;
    private int resposta;

    public Proposta() {
    }

    public Proposta(int idproposta, int idclube, String data, int codigo_acesso, int resposta) {
        this.idproposta = idproposta;
        this.idclube = idclube;
        this.data = data;
        this.codigo_acesso = codigo_acesso;
        this.resposta = resposta;
    }

    public int getIdproposta() {
        return idproposta;
    }

    public void setIdproposta(int idproposta) {
        this.idproposta = idproposta;
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

    public int getCodigo_acesso() {
        return codigo_acesso;
    }

    public void setCodigo_acesso(int codigo_acesso) {
        this.codigo_acesso = codigo_acesso;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
}
