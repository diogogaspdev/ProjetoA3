package projetoa3.footcup2022.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {

    public String Nome;
    public String Senha;
    public int Id;
    public int TipoPrivilegio;

    public Usuario(String pNome, String pSenha, int pId, int pTpPrivilegio) {
        Nome = pNome;
        Senha = pSenha;
        Id = pId;
        TipoPrivilegio = pTpPrivilegio;
    }

    public Usuario(String pNome, String pSenha) {
        Nome = pNome;
        Senha = pSenha;
    }

    public boolean Autenticar(Usuario pUser) throws Exception {
        boolean mRetorno = false;
        String sql = "SELECT * FROM login WHERE cuser = ? AND csenha = ?";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, pUser.Nome);
            ps.setString(2, pUser.Senha);
            try ( ResultSet rs = ps.executeQuery()) {
                mRetorno = rs.next();
                if (mRetorno) {
                    pUser.Id = rs.getInt("iidlogin");
                    pUser.TipoPrivilegio = rs.getInt("itpprivilegio");
                }
                return mRetorno;
            }
        }
    }
}
