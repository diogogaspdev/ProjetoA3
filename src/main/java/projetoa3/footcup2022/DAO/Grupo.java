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
import javax.swing.JOptionPane;
import projetoa3.footcup2022.Lib.ConexaoBD;

/**
 *
 * @author Lucas Parra
 */
public class Grupo {

    public String IdGrupo;
    public String NomeTime;
    public int IdTime;
    public int qtdPontos;
    public int qtdVitorias;
    public int qtdEmpates;
    public int qtdDerrotas;
    public int qtdGolsMarcados;
    public int qtdGolsSofridos;
    public int saldoGols;
    public int qtdJogos;

    public ArrayList<Grupo> Listar(String IdGrupo) throws Exception {

        String sql = """
                     SELECT t.cnome, t.iidtime, grp.iqtdpts, grp.iqtdjogos, grp.iqtdvitorias, grp.iqtdempates, 
                     grp.iqtdderrotas, grp.iqtdgolspro, grp.iqtdgolscontra, grp.isaldo FROM grupos grp
                     INNER JOIN times t ON grp.iidtime = t.iidtime
                     $pCrit$""";

        if (!IdGrupo.isBlank() || IdGrupo != null) {
            sql = sql.replace("$pCrit$", "WHERE grp.cidgrupo = \"" + IdGrupo + "\"");
        }
        sql += ";";

        var lGrupos = new ArrayList<Grupo>();
        try ( Connection conexao = ConexaoBD.obtemConexao();  PreparedStatement ps = conexao.prepareStatement(sql)) {
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Grupo oGrupo = new Grupo();
                    oGrupo.IdGrupo = IdGrupo;
                    oGrupo.NomeTime = rs.getString("cnome");
                    oGrupo.IdTime = rs.getInt("iidtime");
                    oGrupo.qtdPontos = rs.getInt("iqtdpts");
                    oGrupo.qtdVitorias = rs.getInt("iqtdvitorias");
                    oGrupo.qtdEmpates = rs.getInt("iqtdderrotas");
                    oGrupo.qtdGolsMarcados = rs.getInt("iqtdgolspro");
                    oGrupo.qtdGolsSofridos = rs.getInt("iqtdgolscontra");
                    oGrupo.saldoGols = rs.getInt("isaldo");
                    oGrupo.qtdJogos = rs.getInt("iqtdjogos");
                    lGrupos.add(oGrupo);
                }
            }
        }
        return lGrupos;
    }

    public void Deletar(int pId) throws SQLException {
        String sql = "DELETE FROM grupos WHERE iidtime = ?;";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pId);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void Atualizar() throws SQLException {
        String sql = "UPDATE footcup.grupos SET cidgrupo = ? WHERE iidtime = ?;";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, this.IdGrupo);
            ps.setInt(2, this.IdTime);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void Incluir() throws SQLException {
        String sql = "SELECT iidtime FROM times ORDER BY iidtime DESC LIMIT 1;";

        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    this.IdTime = rs.getInt("iidtime");
                }
            }
        }
        sql = "INSERT INTO grupos (cidgrupo, iidtime, iqtdpts, iqtdvitorias, iqtdempates, iqtdderrotas, iqtdgolspro, iqtdgolscontra, isaldo, iqtdjogos)"
                + "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0);";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, this.IdGrupo);
            ps.setInt(2, this.IdTime);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
