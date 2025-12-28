package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

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

        System.out.print("Nome do produto................: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Preço........................: ");
        produto.setPreco(scanner.nextDouble());

        System.out.print("Quantidade...................: ");
        produto.setQuantidade(scanner.nextInt());

        var repo = new ProdutoRepository();
        repo.inserir(produto);
    }

}
