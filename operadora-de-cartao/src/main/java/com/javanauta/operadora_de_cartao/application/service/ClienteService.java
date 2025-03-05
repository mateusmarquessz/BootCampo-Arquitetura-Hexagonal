package com.javanauta.operadora_de_cartao.application.service;

import com.javanauta.operadora_de_cartao.infrastructure.entities.CartaoEntity;
import com.javanauta.operadora_de_cartao.infrastructure.entities.ClienteEntity;
import com.javanauta.operadora_de_cartao.infrastructure.repositories.ClienteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteJpaRepository clienteRepository;
    private final GeraDadosCartaoService geraCartao;

    public ClienteEntity solicitarCartao(ClienteEntity cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Usuário já possui um cartão.");
        }

        CartaoEntity cartao = geraCartao.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
        return clienteRepository.save(cliente);

    }

    public ClienteEntity buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).
                orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }
}