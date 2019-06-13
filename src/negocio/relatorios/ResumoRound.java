package src.negocio.relatorios;

/**
 * Contem os atributos necessarios para criar um ResumoRound que irá ser utilizado na ViewResumoRounds
 */
public class ResumoRound {


    private String nome;
    private int pontos;
    private int idLuta;
    private int anoLiga;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getIdLuta() {
        return idLuta;
    }

    public void setIdLuta(int idLuta) {
        this.idLuta = idLuta;
    }

    public int getAnoLiga() {
        return anoLiga;
    }

    public void setAnoLiga(int anoLiga) {
        this.anoLiga = anoLiga;
    }

}
