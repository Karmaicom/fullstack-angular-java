package br.com.coti.api_clientes.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    /**
     * Atributos para conexão com o banco de dados
     */
    private static String url = "jdbc:postgresql://localhost:5432/api-clientes";
    private static String user = "postgres";
    private static String password = "q1w2e3r4";

    /**
     * Metodo para gerar e retornar uma conexao com o banco de dados
     * @return Connection
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

}
