package main;

import controllers.ProdutoController;

public class Main {

    static void main() {

        try {
            var controller = new ProdutoController();
            controller.cadastrarProduto();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
