package src.negocio;

public abstract class Modalidade {

    protected int forca;

    public Modalidade(){
        setForca();
    }

    public int getForca(){
        return this.forca;
    }

    protected abstract void setForca();
}
