package src.negocio.relatorios;

import src.persistencia.ResultadoLutaDAO;
import src.persistencia.ViewResumoRoundsDAO;

import java.util.ArrayList;

public class ResultadoLuta {

    private ArrayList<ResumoLuta> resumoLutas = ViewResumoRoundsDAO.selecionarView();

    public void inserirVencedoresLutasBanco(){
        for(int i=0; i<resumoLutas.size(); i++){
            System.out.println(resumoLutas.get(i).getAnoLiga()+"-"+resumoLutas.get(i).getIdLuta()+"-"+resumoLutas.get(i).getNome());
            for(int j=i+1; j<resumoLutas.size(); j++){
                if(resumoLutas.get(i).getAnoLiga() == resumoLutas.get(j).getAnoLiga()){
                    if(resumoLutas.get(i).getIdLuta() == resumoLutas.get(j).getIdLuta()){
                        if(resumoLutas.get(i).getPontos() > resumoLutas.get(j).getPontos()){
                            ResultadoLutaDAO.inserir(resumoLutas.get(i).getAnoLiga(),resumoLutas.get(i).getIdLuta(),resumoLutas.get(i).getNome());
                        }else{
                            ResultadoLutaDAO.inserir(resumoLutas.get(j).getAnoLiga(),resumoLutas.get(j).getIdLuta(),resumoLutas.get(j).getNome());
                        }
                    }
                }

            }
        }
    }
}
