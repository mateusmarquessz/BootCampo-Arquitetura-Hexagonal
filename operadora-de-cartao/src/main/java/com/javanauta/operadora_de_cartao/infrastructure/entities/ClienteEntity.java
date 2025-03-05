package com.javanauta.operadora_de_cartao.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Integer idade;
    private String cpf;
    private double rendaMensal;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private EnderecoEntity endereco;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private CartaoEntity cartao;


}
