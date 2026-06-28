package com.gestaofrotasapi.dto;

public class ManutencaoFrotaResponseDTO {

    private Long id;
    private Long veiculoId;
    private String tipo;
    private String descricao;
    private java.math.BigDecimal custo;
    private Integer km;
    private java.time.LocalDateTime data;
    private String oficina;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
