package com.javanauta.operadora_de_cartao.controller.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "cartao", expression = "java(toCartaoEntity(cliente))")
    ClienteEntity toEntity(ClienteRequestDTO cliente);

    ClienteResponseDTO toResponse(ClienteEntity cliente);

    @Mapping(source = "dataVencimentoFatura", target = "dataVencimentoFatura")
    CartaoEntity toCartaoEntity(ClienteRequestDTO clienteRequestDTO);

}
