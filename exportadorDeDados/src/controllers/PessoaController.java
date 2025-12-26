package controllers;

import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class PessoaController implements Serializable {

    // Atributos
    private Scanner scanner = new Scanner(System.in);

    /**
     * Metodo para exportar dados de pessoa física
     */
    public void exportarPessoaFisica() throws Exception {
        // criando um objeto da classe pessoa fisica
        var pessoaFisica = new PessoaFisica();

        // gerando id
        pessoaFisica.setId(UUID.randomUUID());

        System.out.println("Nome..............:");
        pessoaFisica.setNome(scanner.nextLine());

        System.out.println("Email.............:");
        pessoaFisica.setEmail(scanner.nextLine());

        System.out.println("Telefone..........:");
        pessoaFisica.setTelefone(scanner.nextLine());

        System.out.println("Cpf...............:");
        pessoaFisica.setCpf(scanner.nextLine());

        System.out.println("Data nascimento...:");
        pessoaFisica.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
    }

    /**
     * Metodo para exportar dados de pessoa jurídica
     */
    public void exportarPessoaJuridica() throws Exception {
        // criando um objeto da classe pessoa fisica
        var pessoaJuridica = new PessoaJuridica();

        // gerando id
        pessoaJuridica.setId(UUID.randomUUID());

        System.out.println("Nome..............:");
        pessoaJuridica.setNome(scanner.nextLine());

        System.out.println("Email.............:");
        pessoaJuridica.setEmail(scanner.nextLine());

        System.out.println("Telefone..........:");
        pessoaJuridica.setTelefone(scanner.nextLine());

        System.out.println("Cnpj..............:");
        pessoaJuridica.setCnpj(scanner.nextLine());
    }


}
