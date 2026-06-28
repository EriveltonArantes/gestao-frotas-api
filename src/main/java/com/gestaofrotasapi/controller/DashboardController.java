package com.gestaofrotasapi.controller;

import com.gestaofrotasapi.model.Veiculo;
import com.gestaofrotasapi.model.Motorista;
import com.gestaofrotasapi.model.Abastecimento;
import com.gestaofrotasapi.model.ManutencaoFrota;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.gestaofrotasapi.repository.VeiculoRepository veiculoRepository;

    @Autowired
    private com.gestaofrotasapi.repository.MotoristaRepository motoristaRepository;

    @Autowired
    private com.gestaofrotasapi.repository.AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private com.gestaofrotasapi.repository.ManutencaoFrotaRepository manutencaoFrotaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalVeiculo", veiculoRepository.count());
        resumo.put("somaKmVeiculo", veiculoRepository.findAll().stream().filter(e -> e.getKm() != null).mapToLong(e -> e.getKm()).sum());
        resumo.put("totalMotorista", motoristaRepository.count());
        resumo.put("totalAbastecimento", abastecimentoRepository.count());
        resumo.put("somaLitrosAbastecimento", abastecimentoRepository.findAll().stream().filter(e -> e.getLitros() != null).mapToDouble(e -> e.getLitros()).sum());
        resumo.put("totalManutencaoFrota", manutencaoFrotaRepository.count());
        resumo.put("somaKmManutencaoFrota", manutencaoFrotaRepository.findAll().stream().filter(e -> e.getKm() != null).mapToInt(e -> e.getKm()).sum());
        resumo.put("graficoManutencaoFrota", manutencaoFrotaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
