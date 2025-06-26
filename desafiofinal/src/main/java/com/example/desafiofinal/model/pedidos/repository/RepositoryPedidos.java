package com.example.desafiofinal.model.pedidos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiofinal.model.pedidos.entity.Pedido;

public interface RepositoryPedidos extends JpaRepository<Pedido, Long> {

    public Pedido findByDescricao(String descricao);
}