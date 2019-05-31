package jogo.ufc;

import javax.swing.*;
import java.util.ArrayList;

/*
 * Classe base para um objeto que irá interagir com o jogo
 */
public class Lutador{
    private ArrayList<Modalidade> modalidadesRegistradas;

    private String nome;
    private String categoria;
    private String pais;
    private String sexo;
    private Acao acoes;
    private Modalidade modalidade;

    public Lutador() {
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
