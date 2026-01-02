package br.com.coti.api_clientes.repositories;

import br.com.coti.api_clientes.entities.Cliente;
import br.com.coti.api_clientes.factories.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClienteRepository {

    // Atributos
    private ConnectionFactory factory = new ConnectionFactory();

    /**
     * Metodo para consultar todos os clientes cadastrados
     * e retornar uma lista destes clientes
     */
    public List<Cliente> consultar() throws Exception {

        var sql = """
                    select id, nome, email, cpf
                    from clientes
                    order by nome
                """;

        // Abrindo conexao com o banco de dados
        var connection = factory.getConnection();

        // Executando o comando sql para consultar os clientes na tabela do banco de dados
        var statement = connection.prepareStatement(sql);
        var resultSet = statement.executeQuery();

        /**
         * Montando a lista de clientes com a lista retornada no ResultSet
         */
        var clientes = new ArrayList<Cliente>();
        while (resultSet.next()) { // lendo cada registro do resultset
            var cliente = new Cliente();
            cliente.setId(resultSet.getObject("id", UUID.class));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setCpf(resultSet.getString("cpf"));

            clientes.add(cliente);
        }

        // fechando a conexao com o banco de dados
        connection.close();

        return clientes;
    }

}
