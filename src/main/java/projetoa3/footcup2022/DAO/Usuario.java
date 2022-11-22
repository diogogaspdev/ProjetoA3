package projetoa3.footcup2022.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projetoa3.footcup2022.Lib.Comum;
import projetoa3.footcup2022.Lib.ConexaoBD;

public class Usuario {

    public String Nome;
    public int Id;
    public int TipoPrivilegio;

    public Usuario() {
    }

    public Usuario getUser(String pNome) throws SQLException {
        Usuario usrRetorno = new Usuario();
        String sql = "SELECT iidlogin, cuser, itpprivilegio FROM login WHERE cuser = ?";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, pNome);
            try ( ResultSet rs = ps.executeQuery()) {
                rs.next();
                usrRetorno.Id = rs.getInt("iidlogin");
                usrRetorno.Nome = rs.getString("cuser");
                usrRetorno.TipoPrivilegio = rs.getInt("itpprivilegio");
                return usrRetorno;
            }
        }
    }

    public void CadastrarUsuario(String novoUsuario, String novoSenha) throws SQLException {
        String sql = "INSERT INTO login (cuser, csenha, itpprivilegio) VALUES (?,?,?)";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, novoUsuario);
            ps.setString(2, Comum.Hash256(novoSenha));
            ps.setString(3, "1");
            ps.execute();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
}
