package principal;

import controllers.PedidoController;

public class Main {

    static void main() {
        try {

            var pedidoController = new PedidoController();
            pedidoController.capturarPedido();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
