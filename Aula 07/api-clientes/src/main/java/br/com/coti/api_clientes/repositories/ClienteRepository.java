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
     *  Metodo para consultar todos os clientes cadastrados
     *  e retornar uma lista destes clientes
     * @return Lista de clientes
     * @throws Exception
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

    /**
     * Metodo para cadastrar um cliente
     * no banco de dados
     * @param cliente
     * @throws Exception
     */
    public void inserir(Cliente cliente) throws Exception {
        // consulta que sera executada no bando de dados
        var sql = """
                    insert into clientes(id, nome, email, cpf)
                    values(?, ?, ?, ?)
                """;

        // Abrindo conexão com o banco de dados
        var connection = factory.getConnection();

        // preparando comando sql com os dados recebidos como parâmetro
        var statement = connection.prepareStatement(sql);
        statement.setObject(1, cliente.getId());
        statement.setString(2, cliente.getNome());
        statement.setString(3, cliente.getEmail());
        statement.setString(4, cliente.getCpf());

        // executando o comando sql
        statement.execute();

        // fechando a conexao com o bando de dados
        connection.close();
    }

    /**
     * Metodo para atualizar os dados do cliente
     * no banco de dados
     * @param cliente
     * @throws Exception
     */
    public void atualizar(Cliente cliente) throws Exception {
        // consulta que sera executada no bando de dados
        var sql = """
                    update cliente set nome = ? , email = ?, cpf = ?)
                    where id = ?
                """;

        // Abrindo conexao com o banco de dados
        var connection = factory.getConnection();

        // preparando comando sql com os dados recebidos como parâmetro
        var statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setObject(4, cliente.getId());

        // executando comando sql para atualizar os dados do cliente
        statement.executeUpdate();

        // fechando conexão com o banco de dados
        connection.close();
    }

    /**
     * Metodo para excluir um cliente
     * do banco de dados
     * @param cliente
     * @throws Exception
     */
    public void delete(Cliente cliente) throws Exception {
        // consulta que sera executada no bando de dados
        var sql = """
                    delete from cliente where id = ?
                """;

        // Abrindo conexao com o banco de dados
        var connection = factory.getConnection();

        // preparando comando sql com os dados recebidos como parâmetro
        var statement = connection.prepareStatement(sql);
        statement.setObject(1, cliente.getId());

        // executando comando sql para atualizar os dados do cliente
        statement.execute();

        // fechando conexão com o banco de dados
        connection.close();
    }
}
