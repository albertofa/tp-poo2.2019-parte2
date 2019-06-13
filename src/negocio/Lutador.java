package src.negocio;

import src.negocio.modalidade.*;

import java.util.ArrayList;

/**
 * Classe lutador que contem seus atributos,acoes e poder(modalidade)
 *
 * @author José Alberto Fernandes
 */
public class Lutador{

    //Irá conter todas as classes que herdam Modalidade
    private ArrayList<Modalidade> modalidadesRegistradas;

    private String nome;
    private String categoria;
    private String pais;
    private String sexo;
    private Acao acoes;
    private Modalidade modalidade;

    /**
     * Construtor
     */
    public Lutador() {
        //Todas as tipos de modalidades devem ser adicionadas nesste inicializador
        modalidadesRegistradas= new ArrayList<Modalidade>(){
            {
                add(new Boxe());
                add(new JiuJitsu());
                add(new MuayThai());
                add(new Wrestling());
                add(new Karate());
            }
        };
    }

    /**
     * Construtor
     * @param nome
     * @param categoria
     * @param pais
     * @param sexo
     * @param acoes
     * @param modalidade
     */
    public Lutador(String nome, String categoria, String pais, String sexo, Acao acoes, int modalidade){
        modalidadesRegistradas= new ArrayList<Modalidade>(){
            {
                add(new Boxe());
                add(new JiuJitsu());
                add(new MuayThai());
                add(new Wrestling());
                add(new Karate());
            }
        };

        this.nome = nome;
        this.categoria = categoria;
        this.pais = pais;
        this.sexo = sexo;
        this.acoes = acoes;
        setModalideByForca(modalidade);

    }


    //Getters and Setters
    public void setModalideByForca(int forca){
        modalidade = modalidadesRegistradas.get(forca);
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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
