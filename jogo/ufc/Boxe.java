package jogo.ufc;

public class Boxe {

    private int usos;
    private double dano;

    public Boxe(){
        this.usos = 0;
        this.dano = 10.0;
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
