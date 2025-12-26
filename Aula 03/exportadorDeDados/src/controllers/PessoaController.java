package controllers;

import entities.PessoaFisica;
import entities.PessoaJuridica;
import services.PessoaService;
import services.PessoaServiceImpl;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class PessoaController implements Serializable {

    // Atributos
    private Scanner scanner = new Scanner(System.in);
    private PessoaService pessoaService;

    /**
     * Metodo para exportar dados de pessoa física
     */
    public void exportarPessoaFisica() throws Exception {
        // criando um objeto da classe pessoa fisica
        var pessoaFisica = new PessoaFisica();

        // gerando id
        pessoaFisica.setId(UUID.randomUUID());

        System.out.print("Nome..............: ");
        pessoaFisica.setNome(scanner.nextLine());

        System.out.print("Email.............: ");
        pessoaFisica.setEmail(scanner.nextLine());

        System.out.print("Telefone..........: ");
        pessoaFisica.setTelefone(scanner.nextLine());

        System.out.print("Cpf...............: ");
        pessoaFisica.setCpf(scanner.nextLine());

        System.out.print("Data nascimento...: ");
        pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));

        pessoaService = new PessoaServiceImpl();
        pessoaService.salvarPessoaFisica(pessoaFisica);
    }

    /**
     * Metodo para exportar dados de pessoa jurídica
     */
    public void exportarPessoaJuridica() throws Exception {
        // criando um objeto da classe pessoa fisica
        var pessoaJuridica = new PessoaJuridica();

        // gerando id
        pessoaJuridica.setId(UUID.randomUUID());

        System.out.print("Nome..............: ");
        pessoaJuridica.setNome(scanner.nextLine());

        System.out.print("Email.............: ");
        pessoaJuridica.setEmail(scanner.nextLine());

        System.out.print("Telefone..........: ");
        pessoaJuridica.setTelefone(scanner.nextLine());

        System.out.print("Cnpj..............: ");
        pessoaJuridica.setCnpj(scanner.nextLine());

        pessoaService = new PessoaServiceImpl();
        pessoaService.salvarPessoaJuridica(pessoaJuridica);
    }
}
