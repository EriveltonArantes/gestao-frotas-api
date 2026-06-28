package com.gestaofrotasapi.dto;

import jakarta.validation.constraints.*;

public class AbastecimentoRequestDTO {

    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotNull(message = "MotoristaId é obrigatório")
    @Positive(message = "MotoristaId deve ser um ID válido (positivo)")
    private Long motoristaId;
    @FutureOrPresent(message = "data hora não pode ser retroativo")
    @NotNull(message = "data hora não pode ser nulo")
    private java.time.LocalDateTime dataHora;
    @NotNull(message = "litros não pode ser nulo")
    private Double litros;
    @DecimalMin(value = "0.0", message = "preco não pode ser negativo")
    @NotNull(message = "preco não pode ser nulo")
    private java.math.BigDecimal preco;
    @NotBlank(message = "posto não pode estar em branco")
    private String posto;
    @NotNull(message = "km não pode ser nulo")
    private Integer km;
    @NotBlank(message = "tipo combustivel não pode estar em branco")
    private String tipoCombustivel;

    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public Long getMotoristaId() { return motoristaId; }
    public void setMotoristaId(Long motoristaId) { this.motoristaId = motoristaId; }
    public java.time.LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(java.time.LocalDateTime dataHora) { this.dataHora = dataHora; }
    public Double getLitros() { return litros; }
    public void setLitros(Double litros) { this.litros = litros; }
    public java.math.BigDecimal getPreco() { return preco; }
    public void setPreco(java.math.BigDecimal preco) { this.preco = preco; }
    public String getPosto() { return posto; }
    public void setPosto(String posto) { this.posto = posto; }
    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }
    public String getTipoCombustivel() { return tipoCombustivel; }
    public void setTipoCombustivel(String tipoCombustivel) { this.tipoCombustivel = tipoCombustivel; }
}
