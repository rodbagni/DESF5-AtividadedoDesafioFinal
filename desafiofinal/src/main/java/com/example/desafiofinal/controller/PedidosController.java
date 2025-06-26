package com.example.desafiofinal.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiofinal.model.pedidos.entity.Pedido;
import com.example.desafiofinal.model.pedidos.service.ServicePedidos;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidosController {
    
    private final ServicePedidos servicePedidos;

    public PedidosController(ServicePedidos servicePedidos) {
        this.servicePedidos = servicePedidos;
    }

    @GetMapping({"", "/", "/buscarTodos"})
    public Iterable<Pedido> buscarTodosPedidos() {
        return servicePedidos.listarTodosPedidos();
    }

    @GetMapping("/buscarPorDescricao/{descricao}")
    public Pedido buscarPedidosPorDescricao(@PathVariable String descricao) {
        return servicePedidos.buscarPedidosPorDescricao(descricao);
    }

    @PostMapping("/criarPedido")
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return servicePedidos.criarPedido(pedido);
    }

    @PutMapping("/atualizarPedido/{id}")
    public Pedido atualizarPedido(@RequestBody Pedido pedidoAtualizado) {
        return servicePedidos.atualizarPedido(pedidoAtualizado);
    }

    @DeleteMapping("/deletarPedido/{id}")
    public void deletarPedido(@PathVariable Long id) {
        servicePedidos.deletarPedido(id);
    }

    @GetMapping("/buscarPedidoPorId/{id}")
    public Pedido buscarPedidoPorId(@PathVariable Long id) {
        return servicePedidos.buscarPedidoPorId(id);
    }

    @GetMapping("/contarPedidos")
    public long contarPedidos() {
        return servicePedidos.contarPedidos();
    }
}
