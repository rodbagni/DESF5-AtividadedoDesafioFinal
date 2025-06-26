package com.example.desafiofinal.model.clientes.service;

import org.springframework.stereotype.Service;

import com.example.desafiofinal.model.clientes.entity.Cliente;
import com.example.desafiofinal.model.clientes.repository.RepositoryClientes;

@Service
public class ServiceClientes {

    private final RepositoryClientes repository;
    public ServiceClientes(RepositoryClientes repository) {
        this.repository = repository;
    }

    public void criarCliente(Cliente cliente) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(cliente.getNome());
        novoCliente.setEmail(cliente.getEmail());
        novoCliente.setTelefone(cliente.getTelefone());
        repository.save(cliente); // Salva o cliente no repositório
    }

    public void atualizarCliente(Cliente clienteAtualizado) {
        Cliente cliente = repository.findById(clienteAtualizado.getId()).orElse(null);
        if (cliente != null) {
            repository.save(cliente); // Atualiza o cliente no repositório
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + clienteAtualizado.getId());
        }
    }

    public void excluirCliente(Long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente != null) {
            repository.delete(cliente); // Exclui o cliente do repositório
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
    }

    public Cliente buscarClientePorId(Long id) {
        return repository.findById(id).orElse(null); // Busca o cliente pelo ID
    }

    public long contarClientes() {
        return repository.count(); // Conta o número total de clientes
    }

    public Iterable<Cliente> listarTodosClientes() {
        return repository.findAll(); // Lista todos os clientes
    }

    public Cliente buscarClientePorNome(String nome) {
        return repository.findByNome(nome); // Busca o cliente pelo nome
    }
}