package jogo.ufc;
/*
 * Classe base para um objeto que irá interagir com o jogo
 */
public class Lutador extends Poderes{

    private String nome;
    private String categoria;
    private String pais;
    private char sexo;

     TodasAcoes action;
    private double hp;
    private Poderes poder;

    public Lutador() {
        action = new TodasAcoes();
        hp = 1000.00;
        poder = new Poderes();

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

    public void recebeDano(double dano){
        this.hp = this.hp-dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

}
