package com.example.rest.model;

import com.example.rest.dto.UsuarioDtoRequest;
import com.example.rest.dto.UsuarioDtoResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "USUARIO")
public class UsuarioModel {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "SOBRENOME", length = 100)
    private String sobrenome;

    @Column(name = "TELEFONE", length = 10, nullable = false)
    private String telefone;

    //Sua função é mapear o relacionamento entre duas tabelas no banco de dados que tenha relação do tipo 1x1.
    @JoinColumn(name = "endereco_id_fk")
    @OneToOne(cascade = CascadeType.ALL) // um endereço para um funcionario fazer sempre a chave estrangeira onde e
    private EnderecoModel endereco;

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public UsuarioDtoResponse ToDtoResponse() {
        UsuarioDtoResponse userDto = new UsuarioDtoResponse();
        this.setNome(this.getNome());
        this.setSobrenome(this.getSobrenome());
        this.setTelefone(this.getTelefone());
        this.setEndereco(this.getEndereco());

        return userDto;
    }


}