package repositories;

import entities.Produto;
import factories.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

        // Escrevendo um comando SQL para atualizar um produto no banco de dados
        var statement = connection.prepareStatement
                ("update produtos set nome = ?, preco = ?, quantidade = ? where id = ?");

        // Atribuindo valores aos values com o caracter '?'
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setInt(4, produto.getId());

        // Executando o comando sql
        int rowsAffected = statement.executeUpdate();

        // Fechando a conexao com o banco de dados
        connection.close();

        if (rowsAffected > 0) {
            System.out.println("Produto " + produto.getNome() + " atualizado com sucesso!");
        } else {
            System.out.println("Nenhum produto encontrado!");
        }
    }

    public void deletar(Integer id) throws Exception {
        // Abrindo conexao com o banco de dados bd_produtos
        Connection connection = new ConnectionFactory().getConnection();

        // Escrevendo um comando SQL para deletar um produto no banco de dados
        var statement = connection.prepareStatement
                ("delete from produtos where id = ?");

        // Atribuindo valores aos values com o caracter '?'
        statement.setInt(1, id);

        var encontrado = this.buscarProduto(id);

        if (encontrado) {
            // Executando o comando sql
            statement.execute();

            System.out.println("Produto deletado com sucesso!");
        }

        // Fechando a conexao com o banco de dados
        connection.close();
    }

    public List<Produto> listarTodos() throws Exception {
        // Abrindo conexao com o banco de dados bd_produtos
        Connection connection = new ConnectionFactory().getConnection();

        // Escrevendo um comando SQL para mostrar todos os produtos no banco de dados
        var statement = connection.prepareStatement
                ("select id, nome, preco, quantidade from produtos order by id");

        // Executando o comando sql
        var produtosResultSet = statement.executeQuery();

        List<Produto> produtos = new ArrayList<Produto>();

        if (!produtosResultSet.next()) {
            System.out.println("Nenhum produto cadastrado!");
            return produtos;
        }

        while (produtosResultSet.next()) {
            var produto = new Produto();
            produto.setId(produtosResultSet.getInt(1));
            produto.setNome(produtosResultSet.getString(2));
            produto.setPreco(produtosResultSet.getDouble(3));
            produto.setQuantidade(produtosResultSet.getInt(4));
            produtos.add(produto);
        }

        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        // Fechando a conexao com o banco de dados
        connection.close();

        System.out.println("\nProduto listados com sucesso!");

        return produtos;
    }

    public boolean buscarProduto(Integer id) throws Exception {
        // Abrindo conexao com o banco de dados bd_produtos
        Connection connection = new ConnectionFactory().getConnection();

        // Escrevendo um comando SQL para inserir um produto no banco de dados
        var statement = connection.prepareStatement
                ("select id, nome, preco, quantidade from produtos where id = ?");

        // Atribuindo valores aos values com o caracter '?'
        statement.setInt(1, id);

        ResultSet produtoEncontrado = statement.executeQuery();

        // Fechando a conexao com o banco de dados
        connection.close();

        if (produtoEncontrado.next()) {
            var produto = new Produto();
            produto.setId(produtoEncontrado.getInt(1));
            produto.setNome(produtoEncontrado.getString(2));
            produto.setPreco(produtoEncontrado.getDouble(3));
            produto.setQuantidade(produtoEncontrado.getInt(4));

            System.out.println(produto);
            return true;
        } else {
            System.out.println("Produto não encontrado!");
            return false;
        }
    }
}
