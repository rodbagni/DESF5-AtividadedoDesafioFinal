package com.example.desafiofinal.model.pedidos.service;

import org.springframework.stereotype.Service;

import com.example.desafiofinal.model.pedidos.entity.Pedido;
import com.example.desafiofinal.model.pedidos.repository.RepositoryPedidos;

@Service
public class ServicePedidos {

    private final RepositoryPedidos repositoryPedidos;

    public ServicePedidos(RepositoryPedidos repositoryPedidos) {
        this.repositoryPedidos = repositoryPedidos;
    }

    public Pedido criarPedido(Pedido pedido) {
        return repositoryPedidos.save(pedido);
    }

    public Pedido atualizarPedido(Pedido pedidoAtualizado) {
        if (!repositoryPedidos.existsById(pedidoAtualizado.getId()  )) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoAtualizado.setId(pedidoAtualizado.getId());
        return repositoryPedidos.save(pedidoAtualizado);
    }

    public void deletarPedido(Long id) {
        if (!repositoryPedidos.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        repositoryPedidos.deleteById(id);
    }

    public Pedido buscarPedidoPorId(Long id) {
        return repositoryPedidos.findById(id).orElse(null);
    }

    public long contarPedidos() {
        return repositoryPedidos.count();
    }

    public Iterable<Pedido> listarTodosPedidos() {
        return repositoryPedidos.findAll();
    }

    public Pedido buscarPedidosPorDescricao(String descricao) {
        return repositoryPedidos.findByDescricao(descricao);
    }
}