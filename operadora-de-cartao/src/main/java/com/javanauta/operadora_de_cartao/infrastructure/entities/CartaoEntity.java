package com.javanauta.operadora_de_cartao.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private LocalDate dataExpiracao;
    private String cvv;
    private double limite;
    private double availableLimit;
    private LocalDate ultimaAlteracaoLimite;
    private Integer dataVencimentoFatura;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    public CartaoEntity(String numeroCartao, LocalDate dataExpiracao, String cvv, double limiteCredito, ClienteEntity cliente, LocalDate ultimaAlteracaoLimite, Integer dataVencimentoFatura) {
    }
}
