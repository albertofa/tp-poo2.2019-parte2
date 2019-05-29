package jogo.ufc;

public class JiuJitsu {

    private int usos;
    private double dano;

    public JiuJitsu(){
        this.usos = 0;
        this.dano = 80.0;
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
