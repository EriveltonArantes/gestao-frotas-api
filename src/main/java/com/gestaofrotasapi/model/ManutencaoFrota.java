package com.gestaofrotasapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "manutencaofrotas")
public class ManutencaoFrota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    @Column(nullable = false)
    private String tipo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private java.math.BigDecimal custo;
    private Integer km;
    private java.time.LocalDateTime data;
    @Column(nullable = false)
    private String oficina;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
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
