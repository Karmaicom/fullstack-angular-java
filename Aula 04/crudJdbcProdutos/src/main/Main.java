package main;

import controllers.ProdutoController;

import java.util.Scanner;

public class Main {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("(1) Cadastrar Produto");
            System.out.println("(2) Atualizar Produto");
            System.out.println("(3) Deletar Produto");
            System.out.println("(4) Buscar por um produto pelo id");
            System.out.println("(5) Listar todos os produtos");
            System.out.print("\nEscolha a opção: ");

            var opcao = scanner.nextInt();

            var controller = new ProdutoController();

            switch (opcao) {
                case (1):
                    controller.cadastrarProduto();
                    break;
                case (2):
                    controller.atualizarProduto();
                    break;
                case (3):
                    controller.deletarProduto();
                    break;
                case (4):
                    controller.buscarProduto();
                    break;
                case (5):
                    controller.listarProdutos();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
