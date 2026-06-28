package com.gestaofrotasapi.controller;

import com.gestaofrotasapi.dto.ManutencaoFrotaRequestDTO;
import com.gestaofrotasapi.dto.ManutencaoFrotaResponseDTO;
import com.gestaofrotasapi.service.ManutencaoFrotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "ManutencaoFrota", description = "Gerenciamento de manutencaofrotas")
@RestController
@RequestMapping("/api/manutencaofrotas")
public class ManutencaoFrotaController {

    @Autowired
    private ManutencaoFrotaService service;

    @Operation(summary = "Listar todos os ManutencaoFrota")
    @GetMapping
    public List<ManutencaoFrotaResponseDTO> listar(@RequestParam(required = false) String descricao, @RequestParam(required = false) Long veiculoId) {
        List<ManutencaoFrotaResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (veiculoId != null) {
            resultado = resultado.stream().filter(item -> veiculoId.equals(item.getVeiculoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar ManutencaoFrota por ID")
    @GetMapping("/{id}")
    public ManutencaoFrotaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar ManutencaoFrota")
    @PostMapping
    public ResponseEntity<ManutencaoFrotaResponseDTO> criar(@Valid @RequestBody ManutencaoFrotaRequestDTO manutencaoFrota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(manutencaoFrota));
    }

    @Operation(summary = "Atualizar ManutencaoFrota")
    @PutMapping("/{id}")
    public ManutencaoFrotaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ManutencaoFrotaRequestDTO manutencaoFrota) {
        return service.atualizar(id, manutencaoFrota);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir ManutencaoFrota")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
