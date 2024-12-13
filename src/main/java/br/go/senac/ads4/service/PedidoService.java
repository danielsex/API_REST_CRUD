package br.go.senac.ads4.service;

import br.go.senac.ads4.dto.PedidoDto;
import br.go.senac.ads4.model.PedidoModel;
import br.go.senac.ads4.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Transactional
    public PedidoDto createPedido(PedidoDto pedidoDto) {
        // Conversão DTO para Model e salvamento
        PedidoModel pedidoModel = new PedidoModel();
        // Conversão e set dos campos...
        PedidoModel salvo = pedidoRepository.save(pedidoModel);
        return new PedidoDto(); // Retornar o DTO correspondente
    }
    @Transactional(readOnly = true)
    public PedidoDto buscarPedido(Long id) {
        Optional<PedidoModel> pedidoOptional =
                pedidoRepository.findById(id);
        return pedidoOptional.map(pedido -> new
                PedidoDto()).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
    @Transactional(readOnly = true)
    public List<PedidoDto> listarPedidos() {
        List<PedidoModel> pedidos = pedidoRepository.findAll();
        return List.of(); // Conversão de Model para DTO
    }
    @Transactional
    public PedidoDto updatePedido(Long id, PedidoDto pedidoDto) {
        Optional<PedidoModel> pedidoOptional =
                pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            PedidoModel pedidoExistente = pedidoOptional.get();
            // Atualização dos campos
            pedidoRepository.save(pedidoExistente);
            return new PedidoDto(); // Retornar DTO atualizado
        }
        throw new RuntimeException("Pedido não encontrado");
    }
    @Transactional
    public void deletePedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido não encontrado");
        }
    }
}
