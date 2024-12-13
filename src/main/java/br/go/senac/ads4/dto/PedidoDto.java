package br.go.senac.ads4.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class PedidoDto {
    private Long nroPedido;
    private Date datPedido;
    private List<ItemPedidoDto> itens;
}