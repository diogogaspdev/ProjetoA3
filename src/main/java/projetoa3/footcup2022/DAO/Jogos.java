/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoa3.footcup2022.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projetoa3.footcup2022.Lib.Comum;
import projetoa3.footcup2022.Lib.ConexaoBD;

/**
 *
 * @author Lucas Parra
 */
public class Jogos {

    private int IdTimeA;
    private int IdTimeB;
    private int TpJogo;
    private ArrayList<String> lRegistroJogos = new ArrayList<String>();

    public void SimularGrupo(String pIdGrupo) throws SQLException {
        try {
            var lGrupo = new Grupo().Listar(pIdGrupo);
            ArrayList<Grupo> lAux = lGrupo;

            for (Grupo timeA : lGrupo) {
                IdTimeA = timeA.IdTime;
                TpJogo = 0;
                for (Grupo timeB : lAux) {
                    if (timeA.IdTime == timeB.IdTime) {
                        continue;
                    }
                    IdTimeB = timeB.IdTime;
                    // Verificamos se a partida já aconteceu e os times tem menos de 3 jogos registrados.
                    if (!this.ConfrontoRepetido() && (timeA.qtdJogos < 3 && timeB.qtdJogos < 3)) {
                        int qtdGolsTimeA = this.getSimulacaoGols();
                        int qtdGolsTimeB = this.getSimulacaoGols();

                        // Empate
                        if (qtdGolsTimeA == qtdGolsTimeB) {
                            timeA.qtdPontos++;
                            timeB.qtdPontos++;
                            timeA.qtdEmpates++;
                            timeB.qtdEmpates++;
                        } else if (qtdGolsTimeA > qtdGolsTimeB) {// Vitoria do TimeA
                            timeA.qtdPontos += 3;
                            timeA.qtdVitorias++;
                            timeB.qtdDerrotas++;
                        } else { // Vitoria do TimeB
                            timeB.qtdPontos += 3;
                            timeB.qtdVitorias++;
                            timeA.qtdDerrotas++;
                        }
                        timeA.qtdJogos++;
                        timeA.qtdGolsMarcados += qtdGolsTimeA;
                        timeA.qtdGolsSofridos += qtdGolsTimeB;
                        timeA.saldoGols = timeA.qtdGolsMarcados - timeA.qtdGolsSofridos;
                        timeA.AtualizarPontos();

                        timeB.qtdJogos++;
                        timeB.qtdGolsMarcados += qtdGolsTimeB;
                        timeB.qtdGolsSofridos += qtdGolsTimeA;
                        timeB.saldoGols = timeB.qtdGolsMarcados - timeB.qtdGolsSofridos;
                        timeB.AtualizarPontos();
                        RegistraJogo();
                    }
                }
                //RegistraJogos();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public int getSimulacaoGols() {
        return (int) Math.round((Math.random() * (3 - 0)) + 0);
    }

    private void RegistraJogos() throws SQLException {
        try {
            String sql = "INSERT INTO footcup.rodadas (itpjogo, iidtimea, iidtimeb, dtevento)\n "
                    + "VALUES ( ?, ?, ?, NOW());";
            try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, TpJogo);
                ps.setInt(2, IdTimeA);
                ps.setInt(3, IdTimeB);
                ps.execute();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    private void RegistraJogo() throws SQLException {
        this.lRegistroJogos.add(TpJogo + "_" + IdTimeA + "_" + IdTimeB);
    }

    private boolean ConfrontoRepetido() throws SQLException {
        return this.lRegistroJogos.contains(TpJogo + "_" + IdTimeA + "_" + IdTimeB);
    }
    
}
