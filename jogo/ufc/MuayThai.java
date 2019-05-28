package jogo.ufc;

public class MuayThai {

    private int usos;
    private double dano;

    public MuayThai(){
        this.usos = 0;
        this.dano = 150.0;
    }

    public double getDano() {
        return dano;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

}
