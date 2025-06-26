package com.example.desafiofinal.model.clientes.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafiofinal.model.clientes.entity.Cliente;

public interface RepositoryClientes extends JpaRepository<Cliente, Long> {

    public Cliente findByNome(String nome); // Método para buscar cliente pelo nome
}