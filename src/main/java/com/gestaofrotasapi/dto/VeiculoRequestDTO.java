package com.gestaofrotasapi.dto;

import jakarta.validation.constraints.*;

public class VeiculoRequestDTO {

    @NotBlank(message = "placa não pode estar em branco")
    private String placa;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @NotBlank(message = "marca não pode estar em branco")
    private String marca;
    @Min(value = 0, message = "ano não pode ser negativo")
    @NotNull(message = "ano não pode ser nulo")
    private Integer ano;
    @NotNull(message = "km não pode ser nulo")
    private Long km;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "combustivel não pode estar em branco")
    private String combustivel;
    @NotBlank(message = "setor não pode estar em branco")
    private String setor;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
    public Long getKm() { return km; }
    public void setKm(Long km) { this.km = km; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getCombustivel() { return combustivel; }
    public void setCombustivel(String combustivel) { this.combustivel = combustivel; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
