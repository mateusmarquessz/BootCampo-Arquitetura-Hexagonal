package com.javanauta.operadora_de_cartao.controller.dto.response;

public record CartaoResponseDTO(String numero,
                                String dataExpiracao,
                                String cvv,
                                double limite) {}
