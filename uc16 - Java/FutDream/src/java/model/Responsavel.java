package model;

/**
 *
 * @author Th
 */

        
public class Responsavel {
    private int idresponsavel;
    private String nome;
    private String data_nasc; //date
    private char sexo;
    private String telefone;
    private String email;
    private String nacionalidade;
    private String estado;
    private String cidade;
    private String cep;
    private int idjogador;

    public Responsavel() {
    }

    public Responsavel(int idresponsavel, String nome, String data_nasc, char sexo, String telefone, String email, String nacionalidade, String estado, String cidade, String cep, int idjogador) {
        this.idresponsavel = idresponsavel;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.idjogador = idjogador;
    }

    public int getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(int idresponsavel) {
        this.idresponsavel = idresponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
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

    public int getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(int idjogador) {
        this.idjogador = idjogador;
    }
}
