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
    public String Grupo;
    public String Continente;
    public String Bandeira;

    public ArrayList<Time> Listar() throws Exception {
        String sql = "SELECT * FROM footcup.times;";
        ArrayList<Time> lTimes = new ArrayList<Time>();
        try ( Connection conexao = ConexaoBD.obtemConexao();  PreparedStatement ps = conexao.prepareStatement(sql)) {
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Time oTime = new Time();
                    oTime.Id = rs.getInt("iidtime");
                    oTime.Nome = rs.getString("cnome");
                    oTime.Grupo = rs.getString("cidgrupo");
                    oTime.Continente = rs.getString("ccontinente");
                    oTime.Bandeira = rs.getString("cbandeira");
                    lTimes.add(oTime);
                }
            }
        }
        return lTimes;
    }

    public Time Listar(int pId) {
        return new Time();
    }

    public void Deletar(int pId) throws SQLException {
        String sql = "DELETE FROM times WHERE iidtime = ?;";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, pId);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void Incluir() throws SQLException {
        String sql = "INSERT INTO times (cnome, cbandeira, cidgrupo, ccontinente) VALUES (?,?,?,?)";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, this.Nome);
            ps.setString(2, this.Bandeira);
            ps.setString(3, this.Grupo);
            ps.setString(4, this.Continente);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
