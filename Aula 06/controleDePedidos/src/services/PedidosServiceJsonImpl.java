package services;

import entities.Pedido;
import interfaces.PedidoService;
import tools.jackson.databind.ObjectMapper;

import java.io.PrintWriter;

public class PedidosServiceJsonImpl implements PedidoService {

    @Override
    public void exportarPedido(Pedido pedido) throws Exception {
        // Criando um arquivo na maquina do usuario
        var printWriter = new PrintWriter("pedido_" + pedido.getId() + ".json");

        // Transformar os dados do pedido para Json -> Serializacao
        var objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(pedido);

        // Gravando os dados no arquivos
        printWriter.write(json);

        // Fechando o arquivo
        printWriter.close();
    }
}
