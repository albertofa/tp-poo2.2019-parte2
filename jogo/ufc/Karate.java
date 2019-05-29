package jogo.ufc;

public class Karate {

    private int usos;
    private double dano;

    public Karate(){
        this.usos = 0;
        this.dano = 250.0;
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
