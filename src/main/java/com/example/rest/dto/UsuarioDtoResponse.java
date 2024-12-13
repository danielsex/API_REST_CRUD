package com.example.rest.dto;
import com.example.rest.model.EnderecoModel;
import com.example.rest.model.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDtoResponse {

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
    private EnderecoModel endereco;

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }


}
