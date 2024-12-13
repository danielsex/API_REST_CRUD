package br.go.senac.ads4.resource;

import br.go.senac.ads4.dto.ItemPedidoDto;
import br.go.senac.ads4.service.ItemPedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/itenspedido")
public class ItemPedidoResource {
    @Autowired
    private ItemPedidoService itemPedidoService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ItemPedidoDto create(@RequestBody ItemPedidoDto
                                        itemPedidoDto) {
        log.info("ItemPedidoResource::create");
        log.debug("Valores: {}", itemPedidoDto);
        return itemPedidoService.salvarItemPedido(itemPedidoDto);
    }
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ItemPedidoDto get(@PathVariable Long id) {
        log.info("ItemPedidoResource::get");
        log.debug("ID: {}", id);
        return itemPedidoService.buscarItemPedido(id);
    }
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ItemPedidoDto> getAll() {
        log.info("ItemPedidoResource::getAll");
        return itemPedidoService.listarItensPedido();
    }
    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ItemPedidoDto update(
            @PathVariable Long id,
            @RequestBody ItemPedidoDto itemPedidoDto) {
        log.info("ItemPedidoResource::update");
        log.debug("ID: {}, Valores: {}", id, itemPedidoDto);
        return itemPedidoService.updateItemPedido(id, itemPedidoDto);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("ItemPedidoResource::delete");
        log.debug("ID: {}", id);
        itemPedidoService.deleteItemPedido(id);
    }
}