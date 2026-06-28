package com.gestaofrotasapi.service;

import com.gestaofrotasapi.dto.ManutencaoFrotaRequestDTO;
import com.gestaofrotasapi.dto.ManutencaoFrotaResponseDTO;
import com.gestaofrotasapi.exception.ResourceNotFoundException;
import com.gestaofrotasapi.mapper.ManutencaoFrotaMapper;
import com.gestaofrotasapi.model.ManutencaoFrota;
import com.gestaofrotasapi.repository.ManutencaoFrotaRepository;
import com.gestaofrotasapi.repository.VeiculoRepository;
import com.gestaofrotasapi.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManutencaoFrotaService {

    @Autowired
    private ManutencaoFrotaRepository repository;

    @Autowired
    private ManutencaoFrotaMapper mapper;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public List<ManutencaoFrotaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ManutencaoFrotaResponseDTO buscar(Long id) {
        ManutencaoFrota entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ManutencaoFrota não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ManutencaoFrotaResponseDTO criar(ManutencaoFrotaRequestDTO dto) {
        ManutencaoFrota entity = mapper.toEntity(dto);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        ManutencaoFrota salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ManutencaoFrotaResponseDTO atualizar(Long id, ManutencaoFrotaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ManutencaoFrota não encontrado com id: " + id);
        }
        ManutencaoFrota entity = mapper.toEntity(dto);
        entity.setId(id);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        ManutencaoFrota salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ManutencaoFrota não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
