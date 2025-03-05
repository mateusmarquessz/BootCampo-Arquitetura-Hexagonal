package com.javanauta.operadora_de_cartao.controller;



import com.javanauta.operadora_de_cartao.application.service.ClienteService;
import com.javanauta.operadora_de_cartao.controller.dto.request.ClienteRequestDTO;
import com.javanauta.operadora_de_cartao.controller.dto.response.ClienteResponseDTO;
import com.javanauta.operadora_de_cartao.controller.mappers.ClienteMapper;
import com.javanauta.operadora_de_cartao.infrastructure.entities.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteServicePort;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(clienteServicePort.solicitarCartao(mapper.toEntity(clienteRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscaClientePorCpf(@RequestParam String cpf) {
        ClienteEntity cliente = clienteServicePort.buscarPorCpf(cpf);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }
}
