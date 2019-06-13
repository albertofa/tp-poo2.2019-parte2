package src.negocio.bd;

import src.negocio.liga.Liga;
import src.negocio.liga.Round;
import src.persistencia.tabelas.*;
import src.persistencia.views.ViewResumoRoundsDAO;

import java.util.ArrayList;

/**
 * Possui metodos que irão interagir com as classes DAO, criando uma maior camada de encapsulamento
 */
public class LinkBancoDados {

    /**
     * Irá inserir no banco de dados os resultados dos Rounds
     * @param round
     * @param anoLiga
     * @param anoLuta
     */
    public void inserirResultadosBanco(Round round, int anoLiga, int anoLuta){

        round.getRoundResult();
        PontosRoundDAO.inserir(round.getPontosLutador1(),round.getIdRound(),anoLiga,anoLuta,round.getlutador1().getNome());
        PontosRoundDAO.inserir(round.getPontosLutador2(),round.getIdRound(),anoLiga,anoLuta,round.getlutador2().getNome());

    }

    /**
     * Irá inserir no banco de dados os dados que compoem um round
     *
     * @param round
     * @param anoLiga
     * @param idLuta
     */
    public void inserirRoundBanco(Round round, int anoLiga, int idLuta){

        RoundDAO.inserir(round,idLuta,anoLiga);

        LutadorDAO.inserir(round.getlutador1());
        AcaoDAO.inserir(round.getlutador1().getAcoes(),round.getIdRound(),anoLiga,idLuta,round.getlutador1().getNome());
        ModalidadeDAO.inserir(round.getlutador1().getModalidade(),round.getIdRound(),round.getlutador1().getNome(),idLuta,anoLiga);

        LutadorDAO.inserir(round.getlutador2());
        AcaoDAO.inserir(round.getlutador2().getAcoes(),round.getIdRound(),anoLiga,idLuta,round.getlutador2().getNome());
        ModalidadeDAO.inserir(round.getlutador2().getModalidade(),round.getIdRound(),round.getlutador2().getNome(),idLuta,anoLiga);
    }

    /**
     * Irá inserir no banco de dados os dados que compoem uma liga
     * @param liga
     */
    public void inserirLigaBanco(Liga liga){
        LigaDAO.inserir(liga);
    }

    /**
     * Irá inserir no banco de dados os resultados das lutas,
     * a partir dos resultados dos rounds ja disponiveis no bando de dados
     */
    public void inserirResultadoLutaBanco() {

        ArrayList<ResumoRound> resumoRounds = ViewResumoRoundsDAO.selecionarView();


        //Todo seprar if em outros metodos
        for (int i = 0; i < resumoRounds.size(); i++) {
            System.out.println(resumoRounds.get(i).getAnoLiga() + "-" + resumoRounds.get(i).getIdLuta() + "-" + resumoRounds.get(i).getNome());
            for (int j = i + 1; j < resumoRounds.size(); j++) {
                if (resumoRounds.get(i).getAnoLiga() == resumoRounds.get(j).getAnoLiga()) {
                    if (resumoRounds.get(i).getIdLuta() == resumoRounds.get(j).getIdLuta()) {
                        if (resumoRounds.get(i).getPontos() > resumoRounds.get(j).getPontos()) {
                            ResultadoLutaDAO.inserir(resumoRounds.get(i).getAnoLiga(), resumoRounds.get(i).getIdLuta(), resumoRounds.get(i).getNome());
                        } else {
                            ResultadoLutaDAO.inserir(resumoRounds.get(j).getAnoLiga(), resumoRounds.get(j).getIdLuta(), resumoRounds.get(j).getNome());
                        }
                    }
                }

            }
        }
    }


}
