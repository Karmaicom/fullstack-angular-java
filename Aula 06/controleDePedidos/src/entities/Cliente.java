package entities;

import java.util.List;
import java.util.UUID;

public class Cliente {

    // Atributos
    private UUID id;
    private String nome;
    private String cpf;
    private String email;

    // Relacionamentos
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(UUID id, String nome, String cpf, String email, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pedidos = pedidos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
