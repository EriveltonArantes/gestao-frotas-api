package com.gestaofrotasapi.dto;

public class AbastecimentoResponseDTO {

    private Long id;
    private Long veiculoId;
    private Long motoristaId;
    private java.time.LocalDateTime dataHora;
    private Double litros;
    private java.math.BigDecimal preco;
    private String posto;
    private Integer km;
    private String tipoCombustivel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
