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
        cliente.setId(UUID.randomUUID());
        cliente.setNome("Sérgio Mendes");
        cliente.setEmail("sergio@gmail.com");
        cliente.setTelefone("(21) 96957-5900");
        cliente.setCpf("123.456.789-00");
        cliente.setDataHoraCadastro(LocalDateTime.now());

        System.out.println("\nCLIENTE:");
        System.out.println("ID......................: " + cliente.getId());
        System.out.println("Nome....................: " + cliente.getNome());
        System.out.println("Email...................: " + cliente.getEmail());
        System.out.println("Telefone................: " + cliente.getTelefone());
        System.out.println("CPF.....................: " + cliente.getCpf());
        System.out.println("Data/Hora Cadastro......: " + cliente.getDataHoraCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")));
    }

}
