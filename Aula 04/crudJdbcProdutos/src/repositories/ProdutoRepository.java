package repositories;

import entities.Produto;
import factories.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsavel por gravar, alterar, excluir e consultar
 * dados de produtos no banco de dados do PostgreSql (CRUD)
 */
public class ProdutoRepository {

    /**
     * Metodo para inserir um produto novo na tabela produtos do banco de dados bd_produtos
     * @param produto
     */
    public void inserir(Produto produto) throws Exception {
        // Abrindo conexao com o banco de dados bd_produtos
        Connection connection = new ConnectionFactory().getConnection();

        // Escrevendo um comando SQL para inserir um produto no banco de dados
        var statement = connection.prepareStatement
                ("insert into produtos(nome, preco, quantidade) values (?, ?, ?)");

        // Atribuindo valores aos values com o caracter '?'
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());

        // Executando o comando sql
        statement.execute();

        // Fechando a conexao com o banco de dados
        connection.close();

        System.out.println("Produto " + produto.getNome() + " cadastrado com sucesso!");
    }

    public void atualizar(Produto produto) throws Exception {
        // Abrindo conexao com o banco de dados bd_produtos
        Connection connection = new ConnectionFactory().getConnection();

        // Escrevendo um comando SQL para inserir um produto no banco de dados
        var statement = connection.prepareStatement
                ("update produtos set nome = ?, preco = ?, quantidade = ? where id = ?");

        // Atribuindo valores aos values com o caracter '?'
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setInt(4, produto.getId());

        // Executando o comando sql
        statement.execute();

        // Fechando a conexao com o banco de dados
        connection.close();

        System.out.println("Produto " + produto.getNome() + " atualizado com sucesso!");

    }
}
