package controllers;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import enums.StatusPedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class PedidoController {

    // Atributos
    private Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para capturar um pedido
     * preenchido pelo usuario
     */
    public void capturarPedido() {
        System.out.print("\nCAPTURAR NVOO PEDIDO:\n");

        System.out.print("Nome do cliente......................: ");
        var nome = scanner.nextLine();

        System.out.print("Cpf...................................: ");
        var cpf = scanner.nextLine();

        System.out.print("Email.................................: ");
        var email = scanner.nextLine();

        System.out.print("\nQuantidade de itens do pedido: ");
        var itens = Integer.parseInt(scanner.nextLine());

        var itensPedido = new ArrayList<ItemPedido>();

        // Looping para capturar cada item do pedido
        var i = 1;
        while(i <= itens) {
            System.out.println("Entre com o item " + i + " do pedido: ");

            System.out.print("Nome do item....................: ");
            var nomeItem = scanner.nextLine();

            System.out.print("Preço...........................: ");
            var precoUnitario = Double.parseDouble(scanner.nextLine());

            System.out.print("Quantidade....................: ");
            var quantidade = Integer.parseInt(scanner.nextLine());

            var itemPedido = new ItemPedido(UUID.randomUUID(), nomeItem, precoUnitario, quantidade, null);
            itensPedido.add(itemPedido);

            i++;
        }

        // Criando um objetivo do tipo Cliente usando o construtor com entrada de argumentos
        var cliente = new Cliente(UUID.randomUUID(), nome, cpf, email, null);

        // Calculando o valor toral do pedido
        // Somar o preco unitario * quantidade de cada item do pedido
        var valorTotalPedido = 0.0;
        for (var item : itensPedido) {
            valorTotalPedido  += item.getPrecoUnitario() * item.getQuantidade();
        }

        // Criando um objeto do tipo Pedido usando o construtor com entrada de argumentos
        var pedido = new Pedido(UUID.randomUUID(), new Date(), valorTotalPedido, itensPedido, StatusPedido.Processando);

    }

}
