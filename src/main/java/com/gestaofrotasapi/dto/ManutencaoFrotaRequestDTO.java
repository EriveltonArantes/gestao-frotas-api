package com.gestaofrotasapi.dto;

import jakarta.validation.constraints.*;

public class ManutencaoFrotaRequestDTO {

    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @DecimalMin(value = "0.0", message = "custo não pode ser negativo")
    @NotNull(message = "custo não pode ser nulo")
    private java.math.BigDecimal custo;
    @NotNull(message = "km não pode ser nulo")
    private Integer km;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @NotBlank(message = "oficina não pode estar em branco")
    private String oficina;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public java.math.BigDecimal getCusto() { return custo; }
    public void setCusto(java.math.BigDecimal custo) { this.custo = custo; }
    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public String getOficina() { return oficina; }
    public void setOficina(String oficina) { this.oficina = oficina; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
