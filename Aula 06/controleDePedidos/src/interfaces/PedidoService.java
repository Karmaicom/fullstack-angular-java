package interfaces;

import entities.Pedido;

public interface PedidoService {

    /**
     * Metodo para exportar os dados
     * de um Pedido
     */
    void exportarPedido(Pedido pedido) throws Exception;

}
