package src.negocio;

/**
 * Contem todas as acoes, que sao um atributo de um Lutador
 */
public class Acao {

    private int ataque;
	private int soco;
	private int chute;
	private int poder;
	private int defesa;

    /**
     * Construtor
     */
	public Acao(){

	}

    /**
     * Construtor
     * @param ataque
     * @param soco
     * @param chute
     * @param poder
     * @param defesa
     */
    public Acao(int ataque, int soco, int chute, int poder, int defesa){
        this.ataque = ataque;
        this.soco = soco;
        this.chute = chute;
        this.poder = poder;
        this.defesa = defesa;
    }

    //Getters e Setters
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getSoco() {
        return soco;
    }

    public void setSoco(int soco) {
        this.soco = soco;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }


}
