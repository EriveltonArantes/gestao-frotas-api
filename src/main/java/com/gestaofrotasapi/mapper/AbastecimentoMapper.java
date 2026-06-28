package com.gestaofrotasapi.mapper;

import com.gestaofrotasapi.dto.AbastecimentoRequestDTO;
import com.gestaofrotasapi.dto.AbastecimentoResponseDTO;
import com.gestaofrotasapi.model.Abastecimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AbastecimentoMapper {

    @Mapping(target = "veiculo", ignore = true)
    @Mapping(target = "motorista", ignore = true)
    Abastecimento toEntity(AbastecimentoRequestDTO dto);

    @Mapping(target = "veiculoId", source = "veiculo.id")
    @Mapping(target = "motoristaId", source = "motorista.id")
    AbastecimentoResponseDTO toResponseDTO(Abastecimento entity);
}
