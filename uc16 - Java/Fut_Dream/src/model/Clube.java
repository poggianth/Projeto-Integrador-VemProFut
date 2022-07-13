package model;

/**
 *
 * @author Th
 */
public class Clube {

    private String razao;
    private String fantasia;
    private String data_fundacao;
    private String pais;
    private String estado;
    private String cidade;
    private String cep;
    private String telefone;
    private String email;
    private String cnpj;
    private String sobre;
    private String responsavel_cadastro;

    public Clube() {
    }

    public Clube(String razao, String fantasia, String data_fundacao, String pais, String estado, String cidade, String cep, String telefone, String email, String cnpj, String sobre, String responsavel_cadastro) {
        this.razao = razao;
        this.fantasia = fantasia;
        this.data_fundacao = data_fundacao;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.sobre = sobre;
        this.responsavel_cadastro = responsavel_cadastro;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(String data_fundacao) {
        this.data_fundacao = data_fundacao;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getResponsavel_cadastro() {
        return responsavel_cadastro;
    }

    public void setResponsavel_cadastro(String responsavel_cadastro) {
        this.responsavel_cadastro = responsavel_cadastro;
    }
}
