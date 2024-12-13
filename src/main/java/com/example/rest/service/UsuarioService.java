package com.example.rest.service;
import com.example.rest.dto.UsuarioDtoResponse;
import com.example.rest.dto.UsuarioDtoRequest;
import com.example.rest.model.EnderecoModel;
import com.example.rest.model.UsuarioModel;
import com.example.rest.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private EnderecoService enderecoService;


    private EnderecoModel enderecoModel= new EnderecoModel();

    @Transactional(rollbackFor = Throwable.class)
    public UsuarioDtoResponse create(UsuarioDtoRequest userDto){
        enderecoModel = enderecoService.GetEndereco(userDto.getCep());

        UsuarioModel userSalvo = userRepository.save(userDto.ToModel(enderecoModel));

        return userSalvo.ToDtoResponse();
    }

    @Transactional(readOnly = true)
    public UsuarioDtoResponse read(Long id) {
        UsuarioDtoResponse userDto = new UsuarioDtoResponse();
        Optional<UsuarioModel> userEncontrado = userRepository.findById(id);
        if (userEncontrado.isPresent()) {
            UsuarioModel userModel = userEncontrado.get();
            return userModel.ToDtoResponse();
        }
        return null;
    }

        @Transactional(rollbackFor = Throwable.class)
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<UsuarioDtoResponse> readAll() {
        UsuarioDtoResponse userDto = new UsuarioDtoResponse();
        List<UsuarioModel> listaDeProdutos = userRepository.findAll();

        return listaDeProdutos.stream()
                .map(UsuarioModel::ToDtoResponse)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Throwable.class)
    public UsuarioDtoResponse update(Long id, UsuarioDtoRequest usuarioDto) {

        Optional<UsuarioModel> usuarioEncontrado = userRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            UsuarioModel usuarioModel = usuarioEncontrado.get();
            usuarioModel.setNome(usuarioDto.getNome());
            usuarioModel.setTelefone(usuarioDto.getTelefone());
            usuarioModel.setSobrenome(usuarioDto.getSobrenome());
           EnderecoModel endereco= enderecoService.GetEndereco(usuarioDto.getCep());
            if (endereco != null) {
                usuarioModel.setEndereco(endereco);
            }
            UsuarioModel usuarioAtualizado = userRepository.save(usuarioModel);
            return usuarioAtualizado.ToDtoResponse();
        }

        return null;
    }



}
