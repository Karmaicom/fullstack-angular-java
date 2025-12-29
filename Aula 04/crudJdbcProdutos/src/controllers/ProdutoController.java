package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Classe para realizar as interações
 * com o usuário da aplicação
 */
public class ProdutoController {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para capturar os dados
     * para realizar o cadastro
     * de um produto
     */
    public void cadastrarProduto() throws Exception {
        System.out.println("\nCADASTRO DE PRODUTOS\n");

        var produto = new Produto(); // criando objeto

        System.out.print("Nome do produto...........: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Preço.....................: ");
        produto.setPreco(scanner.nextDouble());

        System.out.print("Quantidade................: ");
        produto.setQuantidade(scanner.nextInt());

        var repo = new ProdutoRepository();
        repo.inserir(produto);
    }

    /**
     * Metodo para capturar os dados
     * para atualizar um produto
     */
    public void atualizarProduto() throws Exception {
        System.out.println("\nATUALIZAR PRODUTO\n");

        var produto = new Produto(); // criando objeto

        System.out.print("Id......................: ");
        produto.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nome do produto...........: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Preço.....................: ");
        produto.setPreco(scanner.nextDouble());

        System.out.print("Quantidade................: ");
        produto.setQuantidade(scanner.nextInt());

        var repo = new ProdutoRepository();
        repo.atualizar(produto);
    }

    /**
     * Metodo para capturar os dados
     * para deletar um produto
     */
    public void deletarProduto() throws Exception {
        System.out.println("\nDELETAR PRODUTO\n");

        var produto = new Produto(); // criando objeto

        System.out.print("Id......................: ");
        produto.setId(scanner.nextInt());

        var repo = new ProdutoRepository();
        repo.deletar(produto.getId());
    }

    /**
     * Metodo para capturar os dados
     * para listar todos os produtos
     */
    public void listarProdutos() throws Exception {
        System.out.println("\nLISTAR PRODUTOS\n");

        var repo = new ProdutoRepository();
        repo.listarTodos();
    }

    /**
     * Metodo para capturar os dados
     * para buscar um produto
     */
    public void buscarProduto() throws Exception {
        System.out.println("\nBUSCAR PRODUTO\n");

        var produto = new Produto(); // criando objeto

        System.out.print("Id......................: ");
        produto.setId(scanner.nextInt());

        var repo = new ProdutoRepository();
        repo.buscarProduto(produto.getId());
    }
}
