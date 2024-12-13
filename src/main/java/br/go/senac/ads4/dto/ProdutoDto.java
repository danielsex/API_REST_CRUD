package br.go.senac.ads4.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDto {
    private Long id;
    private String desProduto;
    private Double qtdeProduto;
    private BigDecimal valProduto;


}