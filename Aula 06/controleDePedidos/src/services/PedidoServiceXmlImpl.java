package services;

import entities.Pedido;
import interfaces.PedidoService;
import tools.jackson.dataformat.xml.XmlMapper;

import java.io.PrintWriter;

public class PedidoServiceXmlImpl implements PedidoService {

    @Override
    public void exportarPedido(Pedido pedido) throws Exception {
        // Criando um arquivo na maquina do usuario
        var printWriter = new PrintWriter("pedido_" + pedido.getId() + ".xml");

        // Transformar os dados do pedido para XML -> Serializacao
        var xmlMapper = new XmlMapper();
        var xml = xmlMapper.writeValueAsString(pedido);

        // Gravando os dados no arquivos
        printWriter.write(xml);

        // Fechando o arquivo
        printWriter.close();
    }
}
