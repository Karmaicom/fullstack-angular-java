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
     * @param id
     */
    @DeleteMapping("{id}")
    public String delete(@PathVariable UUID id) {
        try {
            var repo = new ClienteRepository();
            var rowsAffected = repo.delete(id);

            if (rowsAffected) {
                return "Cliente excluído com sucesso!";
            } else {
                return "Nenhum dado foi excluído";
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    /**
     * Endpoint para atualizar um cliente
     * do bando de dados
     * @param request
     * @return Mensagem de texto
     */
    @PutMapping("{id}")
    public String put(@PathVariable UUID id, @RequestBody ClienteRequest request) {
        try {
            var cliente = new Cliente();
            cliente.setId(id);
            cliente.setNome(request.nome());
            cliente.setEmail(request.email());
            cliente.setCpf(request.cpf());

            var repo = new ClienteRepository();
            var rowsAffected = repo.atualizar(cliente);

            if (rowsAffected) {
                return "Cliente " + cliente.getNome() + " atualizado com sucesso!";
            } else {
                return "Não foi possível atualizar";
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
