package repositories;

import entities.Produto;

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
        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/bd_produtos","postgres","q1w2e3r4");

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
    }

}
