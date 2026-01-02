package br.com.coti.api_clientes.controllers;

import br.com.coti.api_clientes.entities.Cliente;
import br.com.coti.api_clientes.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    /**
     * Metodo para retornar a lista
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

}
