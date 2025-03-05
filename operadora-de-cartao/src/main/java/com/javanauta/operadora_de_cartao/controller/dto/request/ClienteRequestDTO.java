package com.javanauta.operadora_de_cartao.controller.dto.request;

public record ClienteRequestDTO (String nome,
                              String email,
                              Integer idade,
                              String cpf,
                              EnderecoRequestDTO endereco,
                              double rendaMensal,
                              String dataVencimentoFatura){}



