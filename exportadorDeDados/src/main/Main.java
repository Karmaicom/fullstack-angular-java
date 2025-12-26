package main;

import controllers.PessoaController;

import java.util.Scanner;

public class Main {

    // Atributo
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Informe (1) Pessoa Física ou (2) Pessoa Jurídica");
        var opcao = Integer.parseInt(scanner.nextLine());

        // criando o objeto
        var pessoaController = new PessoaController();

        // try/catch necessário porque os métodos tem throws exception na assinatura
        try {
            switch (opcao) {
                case 1:
                    pessoaController.exportarPessoaFisica();
                    System.out.println("Dados de pessoa fisica exportados com sucesso!");
                    break;
                case 2:
                    pessoaController.exportarPessoaJuridica();
                    System.out.println("Dados de pessoa juridica exportados com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
