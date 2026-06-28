package com.gestaofrotasapi.mapper;

import com.gestaofrotasapi.dto.MotoristaRequestDTO;
import com.gestaofrotasapi.dto.MotoristaResponseDTO;
import com.gestaofrotasapi.model.Motorista;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MotoristaMapper {

    Motorista toEntity(MotoristaRequestDTO dto);

    MotoristaResponseDTO toResponseDTO(Motorista entity);
}
