package com.gestaofrotasapi.mapper;

import com.gestaofrotasapi.dto.VeiculoRequestDTO;
import com.gestaofrotasapi.dto.VeiculoResponseDTO;
import com.gestaofrotasapi.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    Veiculo toEntity(VeiculoRequestDTO dto);

    VeiculoResponseDTO toResponseDTO(Veiculo entity);
}
