package entities;

import java.util.List;
import java.util.UUID;

public class ItemPedido {

    // Atributos
    private UUID id;
    private String nome;
    private Double precoUnitario;
    private Integer quantidade;

    // Relacionamentos
    private List<Pedido> pedidos;

    public ItemPedido(UUID id, String nome, Double precoUnitario, Integer quantidade, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
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

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
