package principal;

import entidades.Cliente;
import repositorios.ClienteRepositorio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nSISTEMA DE CONTROLE DE CLIENTES");
        System.out.println("Entre com os dados para cadastrar um cliente:");

        Cliente cliente = new Cliente();

        try (Scanner scanner = new Scanner(System.in)){
            cliente.setId(UUID.randomUUID());

            System.out.print("Nome............: ");
            cliente.setNome(scanner.nextLine());

            System.out.print("E-mail..........: ");
            cliente.setEmail(scanner.nextLine());

            System.out.print("Telefone........: ");
            cliente.setTelefone(scanner.nextLine());

            System.out.print("Cpf.............: ");
            cliente.setCpf(scanner.nextLine());

            cliente.setDataHoraCadastro(LocalDateTime.now());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        ClienteRepositorio repo = new ClienteRepositorio();
        repo.exportar(cliente);

        System.out.println("\nCLIENTE:");
        System.out.println("ID......................: " + cliente.getId());
        System.out.println("Nome....................: " + cliente.getNome());
        System.out.println("Email...................: " + cliente.getEmail());
        System.out.println("Telefone................: " + cliente.getTelefone());
        System.out.println("CPF.....................: " + cliente.getCpf());
        System.out.println("Data/Hora Cadastro......: " + cliente.getDataHoraCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
    }

}
