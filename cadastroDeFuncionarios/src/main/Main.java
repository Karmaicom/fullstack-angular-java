package main;

import entities.Endereco;
import entities.Funcionario;
import repositories.FuncionarioRepository;

import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        var funcionario = new Funcionario();
        var endereco = new Endereco();
        funcionario.setEndereco(endereco);

        funcionario.setId(UUID.randomUUID());
        funcionario.setNome("Funcionario" + ((int) (Math.random() * 1000)));
        funcionario.setCpf("12345678900");
        funcionario.setMatricula("123456");
        funcionario.setDataAdmissao(new Date());
        funcionario.setSalario(5000.0);

        funcionario.getEndereco().setId(UUID.randomUUID());
        funcionario.getEndereco().setLogradouro("Av. Rio Branco");
        funcionario.getEndereco().setNumero("185");
        funcionario.getEndereco().setComplemento("Sala 307");
        funcionario.getEndereco().setBairro("Centro");
        funcionario.getEndereco().setCidade("Rio de Janeiro");
        funcionario.getEndereco().setUf("RJ");
        funcionario.getEndereco().setCep("20040007");

        var repository = new FuncionarioRepository();
        repository.inserir(funcionario); // inserindo funcionario no banco de dados

    }

}
