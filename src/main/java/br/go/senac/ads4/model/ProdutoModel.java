package br.go.senac.ads4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DES_PRODUTO", length = 50, nullable = false)
    private String desProduto;
    @Column(name = "QTDE_PRODUTO", nullable = false)
    private Double qtdeProduto;
    @Column(name = "VAL_PRODUTO", precision = 10, scale = 2, nullable = false)
    private BigDecimal valProduto;


}