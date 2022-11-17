package projetoa3.footcup2022.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    private static String host = "aws-sa-east-1.connect.psdb.cloud";
    private static String porta = "3306";
    private static String db = "footcup";
    private static String usuario = "32dheyfnkraxcnghe5hd";
    private static String senha = "pscale_pw_qIpFUGGin4bBr129xImqqSxFWLhf9qQsOxsurrQkh8R";

    public static Connection obtemConexao() {
        try {
            //Connection c = DriverManager.getConnection(
            //"jdbc:mysql://" + host + ":" + porta + "/" + db, usuario, senha);

            //Connection c = DriverManager.getConnection("jdbc:mysql//" + host + ":" + porta + "/" + bd + "?user="+usuario+"&password="+senha+"&useTimezone=true&serverTimezone=America/Sao_Paulo");
            String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", host, porta, db);
            Connection c = DriverManager.getConnection(url, usuario, senha);

            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
