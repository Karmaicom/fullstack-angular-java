package entities;

import enums.StatusPedido;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Pedido {
    // Atributos
    private UUID    id;
    private Date data;
    private Double valor;

    // Relacionamentos
    private List<ItemPedido> itensPedido;
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(UUID id, Date data, Double valor, List<ItemPedido> itensPedido, StatusPedido status) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.itensPedido = itensPedido;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
