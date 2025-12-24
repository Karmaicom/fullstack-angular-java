package repositorios;

import entidades.Cliente;

import java.io.PrintWriter;
import java.util.UUID;

public class ClienteRepositorio {

    public void exportar(Cliente cliente) {

        try {
            // Criando um arquivo dentro do projeto
            PrintWriter printWriter = new PrintWriter("cliente_"+ cliente.getId() + ".txt");

            printWriter.write("\n" + cliente.getId());
            printWriter.write("\n" + cliente.getNome());
            printWriter.write("\n" + cliente.getEmail());
            printWriter.write("\n" + cliente.getCpf());
            printWriter.write("\n" + cliente.getTelefone());
            printWriter.write("\n" + cliente.getDataHoraCadastro());

            printWriter.close();

            System.out.println("\nDados gravados com sucesso!\n");

        } catch (Exception e) {
            System.out.println("\nFalha ao salvar os dados do cliente.\n Erro: " + e.getMessage());
        }


    }

}
