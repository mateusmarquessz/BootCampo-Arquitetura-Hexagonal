package com.javanauta.operadora_de_cartao.application.service;

import com.javanauta.operadora_de_cartao.infrastructure.entities.CartaoEntity;
import com.javanauta.operadora_de_cartao.infrastructure.entities.ClienteEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class GeraDadosCartaoService {

    private static final String PREFIXO_NUMERO_CARTAO = "4000";
    private static final int TAMANHO_NUMERO_CARTAO = 16;

    public CartaoEntity gerarParaCliente(ClienteEntity cliente) {
        String numeroCartao = gerarNumeroCartao();
        LocalDate dataExpiracao = gerarDataExpiracao();
        String cvv = gerarCVV();
        double limiteCredito = determinarLimiteCredito(cliente);

        return new CartaoEntity(numeroCartao, dataExpiracao, cvv, limiteCredito, cliente, cliente.getCartao().getUltimaAlteracaoLimite(),
                cliente.getCartao().getDataVencimentoFatura());
    }

    private String gerarNumeroCartao() {
        Random random = new Random();
        StringBuilder numeroCartao = new StringBuilder(PREFIXO_NUMERO_CARTAO);
        for (int i = 0; i < TAMANHO_NUMERO_CARTAO - PREFIXO_NUMERO_CARTAO.length(); i++) {
            numeroCartao.append(random.nextInt(10));
        }
        return numeroCartao.toString();
    }

    private LocalDate gerarDataExpiracao() {
        Random random = new Random();
        int mes = random.nextInt(12) + 1;
        int ano = random.nextInt(5) + 2024;
        return LocalDate.of(ano, mes, 1);
    }

    private String gerarCVV() {
        Random random = new Random();
        return String.format("%03d", random.nextInt(1000));
    }

    private double determinarLimiteCredito(ClienteEntity cliente) {
        int idade = cliente.getIdade();
        double salario = cliente.getRendaMensal();

        if (idade >= 18 && idade <= 25) {
            if (salario < 3000) {
                return 1000.00;
            } else if (salario < 6000) {
                return 3000.00;
            } else {
                return 5000.00;
            }
        } else if (idade >= 26 && idade <= 40) {
            if (salario < 4000) {
                return 2000.00;
            } else if (salario < 8000) {
                return 5000.00;
            } else {
                return 10000.00;
            }
        } else {
            if (salario < 5000) {
                return 3000.00;
            } else if (salario < 10000) {
                return 8000.00;
            } else {
                return 15000.00;
            }
        }
    }
}