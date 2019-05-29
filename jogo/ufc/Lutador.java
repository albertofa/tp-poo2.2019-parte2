package jogo.ufc;
/*
 * Classe base para um objeto que irá interagir com o jogo
 */
public class Lutador extends Poderes{

    private String nome;
    private String categoria;
    private String pais;
    private char sexo;
    private Acao acoes;
    private Modalidade modalidade;

    public Lutador() {

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Acao getAcoes() {
        return acoes;
    }

    public void setAcoes(Acao acoes) {
        this.acoes = acoes;
    }


}
