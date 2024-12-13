package br.go.senac.ads4.resource;

import br.go.senac.ads4.dto.PedidoDto;
import br.go.senac.ads4.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService pedidoService;
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public PedidoDto get(@PathVariable Long id) {
        log.info("PedidoResource::get");
        log.debug("ID: {}", id);
        return pedidoService.buscarPedido(id);
    }
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<PedidoDto> getAll() {
        log.info("PedidoResource::getAll");
        return pedidoService.listarPedidos();
    }
    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public PedidoDto update(
            @PathVariable Long id,
            @RequestBody PedidoDto pedidoDto) {
        log.info("PedidoResource::update");
        log.debug("ID: {}, Valores: {}", id, pedidoDto);
        return pedidoService.updatePedido(id, pedidoDto);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("PedidoResource::delete");
        log.debug("ID: {}", id);
        pedidoService.deletePedido(id);
    }
}