package br.com.coti.api_clientes.controllers;

import br.com.coti.api_clientes.entities.Cliente;
import br.com.coti.api_clientes.repositories.ClienteRepository;
import br.com.coti.api_clientes.requests.ClienteRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    /**
     * Endpoint para retornar a lista
     * com todos os clientes cadastrados
     * @return lista de clientes
     */
    @GetMapping
    public List<Cliente> getAll() throws Exception {
        // instanciando a classe de repositório
        var repo = new ClienteRepository();

        // retornar os dados da consulta
        return repo.consultar();
    }

    /**
     * Endpoint para criar um cliente
     * no banco de dados
     * @param request
     */
    @PostMapping
    public String post(@RequestBody ClienteRequest request) {
        try {
            var cliente = new Cliente();
            cliente.setId(UUID.randomUUID());
            cliente.setNome(request.nome());
            cliente.setEmail(request.email());
            cliente.setCpf(request.cpf());

            var repo = new ClienteRepository();
            repo.inserir(cliente);

            return "Cliente " + cliente.getNome() + " cadastrado com sucesso!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Endpoint para deletar um cliente
     * do banco de dados
     * @param cliente
     */
    @DeleteMapping
    public void delete(Cliente cliente) {
        try {
            var repo = new ClienteRepository();
            repo.delete(cliente);
            System.out.println("Cliente " + cliente.getNome() + " excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Endpoint para atualizar um cliente
     * do bando de dados
     * @param cliente
     */
    @PutMapping
    public void put(Cliente cliente) {
        try {
            var repo = new ClienteRepository();
            repo.atualizar(cliente);
            System.out.println("Cliente " + cliente.getNome() + " atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
