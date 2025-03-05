package com.javanauta.operadora_de_cartao.controller.dto.response;


public record ClienteResponseDTO(String nome,
                                 String email,
                                 Integer idade,
                                 String cpf,
                                 CartaoResponseDTO cartao){}



