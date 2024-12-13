package br.go.senac.ads4.resource;

import br.go.senac.ads4.dto.ProdutoDto;
import br.go.senac.ads4.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProdutoDto create(@RequestBody ProdutoDto produtoDto) {
        log.info("ProdutoResource::create");
        return produtoService.create(produtoDto); // Usar método correto
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProdutoDto get(@PathVariable Long id) {
        log.info("ProdutoResource::get");
        return produtoService.read(id); // Usar método correto
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<ProdutoDto> getAll() {
        log.info("ProdutoResource::getAll");
        return produtoService.lerTodos(); // Usar método correto
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProdutoDto update(
            @PathVariable Long id,
            @RequestBody ProdutoDto produtoDto) {
        log.info("ProdutoResource::update");
        return produtoService.update(id, produtoDto); // Usar método correto
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("ProdutoResource::delete");
        produtoService.delete(id); // Usar método correto
    }
}
