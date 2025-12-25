package repositories;

import entities.Funcionario;

import java.sql.DriverManager;

public class FuncionarioRepository {

    public void inserir (Funcionario funcionario) {
        try {

            // Abrir conexõ com o banco de dados
            var connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/bd_funcionarios", "postgres","q1w2e3r4");

            // Inserir os dados do funcionário no banco de dados
            var stFuncionario = connection.prepareStatement(
                    "insert into funcionarios(id, nome, cpf, matricula, dataAdmissao, salario)" +
                            " values(?,?,?,?,?,?)");
            stFuncionario.setObject(1, funcionario.getId());
            stFuncionario.setString(2, funcionario.getNome());
            stFuncionario.setString(3, funcionario.getCpf());
            stFuncionario.setString(4, funcionario.getMatricula());
            stFuncionario.setDate(5, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
            stFuncionario.setDouble(6, funcionario.getSalario());
            stFuncionario.execute();

            // Inserir os dados de endereço do funcionario no banco de dados
            var stEndereco = connection.prepareStatement(
                    "insert into enderecos(id, logradouro, numero, complemento, bairro, cidade, estado, cep, funcionario_id)" +
                            " values(?,?,?,?,?,?,?,?,?)");
            stEndereco.setObject(1, funcionario.getEndereco().getId());
            stEndereco.setString(2, funcionario.getEndereco().getLogradouro());
            stEndereco.setString(3, funcionario.getEndereco().getNumero());
            stEndereco.setString(4, funcionario.getEndereco().getComplemento());
            stEndereco.setString(5, funcionario.getEndereco().getBairro());
            stEndereco.setString(6, funcionario.getEndereco().getCidade());
            stEndereco.setString(7, funcionario.getEndereco().getUf());
            stEndereco.setString(8, funcionario.getEndereco().getCep());
            stEndereco.setObject(9, funcionario.getId());
            stEndereco.execute();

            connection.close();

            System.out.println("Dados de funcionario gravados com sucesso!");

        } catch (Exception e) {
            System.out.println("\nFalha ao inserir no banco de dados. Erro: " + e.getMessage());
        }
    }

}
