package jogo.ufc;

public class Wrestling {

    private int usos;
    private double dano;

    public Wrestling(){
        this.usos = 0;
        this.dano = 200.0;
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
