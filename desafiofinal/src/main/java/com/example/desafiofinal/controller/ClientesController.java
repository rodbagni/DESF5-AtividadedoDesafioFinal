package com.example.desafiofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiofinal.model.clientes.entity.Cliente;
import com.example.desafiofinal.model.clientes.service.ServiceClientes;

@RestController
@RequestMapping("/v1/clientes")
public class ClientesController {
    
    private final ServiceClientes serviceClientes;

    public ClientesController(ServiceClientes serviceClientes) {
        this.serviceClientes = serviceClientes;
    }

    @GetMapping({"", "/", "/listar"})
    public Iterable<Cliente> listarClientes() {
        // Implement the method to list clients
        return serviceClientes.listarTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        // Implement the method to get a client by ID
        return serviceClientes.buscarClientePorId(id);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public Cliente buscarClientePorNome(@PathVariable String nome) {
        return serviceClientes.buscarClientePorNome(nome);
    }

    @PostMapping("/criarCliente")
    public void criarCliente(@RequestBody Cliente cliente) {
        serviceClientes.criarCliente(cliente);
    }

    @PutMapping("/atualizarCliente")
    public void atualizarCliente(@RequestBody Cliente cliente) {
        serviceClientes.atualizarCliente(cliente);
    }
 
    @DeleteMapping("/deletarCliente/{id}")
    public void deletarCliente(@PathVariable Long id) {
        serviceClientes.excluirCliente(id);
    }

    @GetMapping("/contarClientes")
    public long contarClientes() {
        return serviceClientes.contarClientes();
    } 
}
