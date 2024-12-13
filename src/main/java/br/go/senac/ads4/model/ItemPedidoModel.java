package br.go.senac.ads4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "item_pedido")
public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "QTDE_ITEM", nullable = false)
    private Double qtdeItem;
    @Column(name = "VAL_UNIDADE", precision = 10, scale = 2,
            nullable = false)
    private BigDecimal valUnidade;
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoModel pedido;

}