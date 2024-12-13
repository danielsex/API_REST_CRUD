package com.example.rest.repository;
import com.example.rest.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    }

