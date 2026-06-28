package com.gestaofrotasapi.mapper;

import com.gestaofrotasapi.dto.ManutencaoFrotaRequestDTO;
import com.gestaofrotasapi.dto.ManutencaoFrotaResponseDTO;
import com.gestaofrotasapi.model.ManutencaoFrota;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManutencaoFrotaMapper {

    @Mapping(target = "veiculo", ignore = true)
    ManutencaoFrota toEntity(ManutencaoFrotaRequestDTO dto);

    @Mapping(target = "veiculoId", source = "veiculo.id")
    ManutencaoFrotaResponseDTO toResponseDTO(ManutencaoFrota entity);
}
