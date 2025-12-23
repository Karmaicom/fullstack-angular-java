package principal;

import entidades.Cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nSISTEMA DE CONTROLE DE CLIENTES");
        System.out.println("Entre com os dados para cadastrar um cliente:");

        Cliente cliente = new Cliente();
        cliente.id = UUID.randomUUID();
        cliente.nome = "Sérgio Mendes";
        cliente.email = "sergio@gmail.com";
        cliente.telefone = "(21) 96957-5900";
        cliente.cpf = "123.456.789-00";
        cliente.dataHoraCadastro = LocalDateTime.now();

        System.out.println("\nCLIENTE:");
        System.out.println("ID......................: " + cliente.id);
        System.out.println("Nome....................: " + cliente.nome);
        System.out.println("Email...................: " + cliente.email);
        System.out.println("Telefone................: " + cliente.telefone);
        System.out.println("CPF.....................: " + cliente.cpf);
        System.out.println("Data/Hora Cadastro......: " + cliente.dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
    }

}
