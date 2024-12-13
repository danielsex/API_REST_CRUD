package com.example.rest.dto;
import com.example.rest.model.EnderecoModel;
import com.example.rest.model.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDtoRequest {

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }



    private String nome;
    private String telefone;
    private String sobrenome;
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public UsuarioModel ToModel(EnderecoModel end) {
        UsuarioModel userModel = new UsuarioModel();
        userModel.setNome(this.nome);
        userModel.setSobrenome(this.sobrenome);
        userModel.setTelefone(this.telefone);
       userModel.setEndereco(end);

        return userModel;
    }

//     public UsuarioDto ToDto(UsuarioModel userModel) {
//        UsuarioDto userDto = new UsuarioDto();
//        userDto.setNome(userModel.getNome());
//        userDto.setSobrenome(userModel.getSobrenome());
//        userDto.setTelefone(userModel.getTelefone());
//        userDto.setEndereco(userModel.getEndereco());
//
//        return userDto;
//    }
}
