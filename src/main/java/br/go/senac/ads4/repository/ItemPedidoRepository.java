package br.go.senac.ads4.repository;

import br.go.senac.ads4.model.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}