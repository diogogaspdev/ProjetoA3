/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoa3.footcup2022.Lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import projetoa3.footcup2022.DAO.Usuario;

/**
 *
 * @author Lucas Parra
 */
public final class Acesso {
    private Acesso(){}
    
    public static Usuario User;
    
    public static boolean Autenticar(String pUserName, String pSenha) throws Exception {
        String sql = "SELECT * FROM login WHERE cuser = ? AND csenha = ?";
        try ( Connection c = ConexaoBD.obtemConexao();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, pUserName);
            ps.setString(2, pSenha);
            try ( ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
