package entities;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Funcionario {

    private UUID id;
    private String nome;
    private String cpf;
    private String matricula;
    private Date dataAdmissao;
    private Double salario;
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(UUID id, String nome, String cpf, String matricula, Date dataAdmissao, Double salario, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                ", salario=" + salario +
                ", endereco=" + endereco +
                '}';
    }
}
