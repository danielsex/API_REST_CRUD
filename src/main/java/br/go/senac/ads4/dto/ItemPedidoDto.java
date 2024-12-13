package br.go.senac.ads4.dto;

import br.go.senac.ads4.model.ItemPedidoModel;
import br.go.senac.ads4.model.PedidoModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ItemPedidoDto {
    private Long id;
    private Double qtdeItem;
    private BigDecimal valUnidade;
}