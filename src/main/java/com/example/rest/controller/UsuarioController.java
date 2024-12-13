package com.example.rest.controller;
import com.example.rest.dto.UsuarioDtoRequest;
import com.example.rest.dto.UsuarioDtoResponse;
import com.example.rest.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public UsuarioDtoResponse create(UsuarioDtoRequest usuario) {

    return usuarioService.create(usuario);

    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public UsuarioDtoResponse get(@PathVariable Long id) {

        return usuarioService.read(id);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public UsuarioDtoResponse update(
            @PathVariable Long id,
            @RequestBody UsuarioDtoRequest usuarioDto) {
        return usuarioService.update(id, usuarioDto);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }

}
