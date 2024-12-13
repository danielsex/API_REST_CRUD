package br.go.senac.ads4.repository;

import br.go.senac.ads4.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
