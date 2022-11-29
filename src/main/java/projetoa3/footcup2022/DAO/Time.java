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
import projetoa3.footcup2022.Lib.ConexaoBD;

/**
 *
 * @author Lucas Parra
 */
public class Time {

    public Time() {
    }

    public int Id;
    public String Nome;
    public String IdGrupo;
    public String Continente;
    public String Bandeira;

    public ArrayList<Time> Listar(String pCrit) throws SQLException {

        String sql = "SELECT * FROM footcup.times $pCrit$";
        if (!pCrit.isBlank() || pCrit != null) {
            sql = sql.replace("$pCrit$", pCrit);
        }
        sql += ";";

        var lTimes = new ArrayList<Time>();
        try ( Connection conexao = ConexaoBD.obtemConexao();  PreparedStatement ps = conexao.prepareStatement(sql)) {
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Time oTime = new Time();
                    oTime.Id = rs.getInt("iidtime");
                    oTime.Nome = rs.getString("cnome");
                    oTime.IdGrupo = rs.getString("cidgrupo");
                    oTime.Continente = rs.getString("ccontinente");
                    oTime.Bandeira = rs.getString("cbandeira");
                    lTimes.add(oTime);
                }
            }
        }
        return lTimes;
    }

    public ArrayList<Time> Listar() throws SQLException {
        return this.Listar("");
    }

    public Time Listar(int pId) throws SQLException {
        String sql = "SELECT * FROM footcup.times WHERE iidtime = ?;";
        try ( Connection conexao = ConexaoBD.obtemConexao();  PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, pId);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Time oTime = new Time();
                    oTime.Id = rs.getInt("iidtime");
                    oTime.Nome = rs.getString("cnome");
                    oTime.IdGrupo = rs.getString("cidgrupo");
                    oTime.Continente = rs.getString("ccontinente");
                    oTime.Bandeira = rs.getString("cbandeira");
                    return oTime;
                }
            }
        }
        return null;
    }

    public void Deletar(int pId) throws SQLException {
        String sql = "DELETE FROM times WHERE iidtime = ?;";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pId);
            ps.execute();

            var oGrupo = new Grupo();
            oGrupo.Deletar(pId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void Incluir() throws SQLException {
        try {
            int qtdTimesCadastrados = this.Listar().size();
            int qtdTimesNoGrupo = new Grupo().Listar(this.IdGrupo).size();
            if (qtdTimesCadastrados < 32 && qtdTimesNoGrupo < 4) {
                String sql = "INSERT INTO times (cnome, cbandeira, cidgrupo, ccontinente) VALUES (?,?,?,?)";
                Connection c = ConexaoBD.obtemConexao();
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, this.Nome);
                ps.setString(2, this.Bandeira);
                ps.setString(3, this.IdGrupo);
                ps.setString(4, this.Continente);
                ps.execute();

                var oGrupo = new Grupo();
                oGrupo.IdGrupo = this.IdGrupo;
                oGrupo.IdTime = this.Id;
                oGrupo.Incluir();
            } else {
                String msg = "";
                if (qtdTimesCadastrados >= 32) {
                    msg = "Não é possível incluir o time " + this.Nome + " pois já existem 32 times cadastrados.\n";
                }
                if (qtdTimesNoGrupo >= 4) {
                    msg += "O Grupo " + this.IdGrupo + " já está cheio.";
                }
                throw new SQLException(msg);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void Atualizar(int pId) throws SQLException {
        String sql = "UPDATE footcup.times SET cnome = ?, cbandeira = ?, cidgrupo = ?, ccontinente = ? WHERE iidtime = ?;";
        Time oGrupoAntigo = this.Listar(pId);
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, this.Nome);
            ps.setString(2, this.Bandeira);
            ps.setString(3, this.IdGrupo);
            ps.setString(4, this.Continente);
            ps.setInt(5, pId);
            ps.execute();

            if (oGrupoAntigo.IdGrupo != this.IdGrupo) {
                var oGrupo = new Grupo();
                oGrupo.IdGrupo = this.IdGrupo;
                oGrupo.IdTime = pId;
                oGrupo.Atualizar();
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

}
