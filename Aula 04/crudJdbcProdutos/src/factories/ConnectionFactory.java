package factories;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsavel por gerar a conexao
 * com o banco de dados
 */
public class ConnectionFactory {

    /**
     * Metodo para retornar uma conexao
     * com um banco de dados
     * PostgreSQL
     */
    public Connection getConnection() throws Exception {
        var host = "jdbc:postgresql://localhost:5432/bd_produtos";
        var user = "postgres";
        var password = "q1w2e3r4";

        return DriverManager.getConnection(host, user, password);
    }
    
}
