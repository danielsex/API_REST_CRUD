package br.go.senac.ads4.service;

import br.go.senac.ads4.dto.ItemPedidoDto;
import br.go.senac.ads4.model.ItemPedidoModel;
import br.go.senac.ads4.repository.ItemPedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    private ItemPedidoModel toModel(ItemPedidoDto itemPedidoDto) {
        ItemPedidoModel itemPedidoModel = new ItemPedidoModel();
        itemPedidoModel.setQtdeItem(itemPedidoDto.getQtdeItem());
        itemPedidoModel.setValUnidade(itemPedidoDto.getValUnidade());
        return itemPedidoModel;
    }

    // Método para converter ItemPedidoModel em ItemPedidoDto
    private ItemPedidoDto toDto(ItemPedidoModel itemPedidoModel) {
        ItemPedidoDto itemPedidoDto = new ItemPedidoDto();
        itemPedidoDto.setId(itemPedidoModel.getId()); // Se você tiver um ID no DTO
        itemPedidoDto.setQtdeItem(itemPedidoModel.getQtdeItem());
        itemPedidoDto.setValUnidade(itemPedidoModel.getValUnidade());
        return itemPedidoDto;
    }

    @Transactional(rollbackFor = Throwable.class)
    public ItemPedidoDto salvarItemPedido(ItemPedidoDto itemPedidoDto) {
        log.info("ItemPedidoService::salvarItemPedido");
        log.debug("Valores: {}", itemPedidoDto);

        // Converter ItemPedidoDto para ItemPedidoModel
        ItemPedidoModel itemPedidoModel = toModel(itemPedidoDto);

        // Salvar no banco de dados
        itemPedidoModel = itemPedidoRepository.save(itemPedidoModel);

        // Converter ItemPedidoModel para ItemPedidoDto e retornar
        return toDto(itemPedidoModel); // FAZER PARSE
    }

    @Transactional(readOnly = true)
    public ItemPedidoDto buscarItemPedido(Long id) {
        log.info("ItemPedidoService::buscarItemPedido");
        log.debug("ID: {}", id);

        Optional<ItemPedidoModel> itemPedidoOptional = itemPedidoRepository.findById(id);
        if (itemPedidoOptional.isPresent()) {
            return toDto(itemPedidoOptional.get()); // FAZER PARSE
        } else {
            throw new RuntimeException("Item de Pedido não encontrado com o ID: " + id);
        }
    }

    @Transactional(readOnly = true)
    public List<ItemPedidoDto> listarItensPedido() {
        log.info("ItemPedidoService::listarItensPedido");

        List<ItemPedidoModel> itensPedido = itemPedidoRepository.findAll();

        // Converter List<ItemPedidoModel> para List<ItemPedidoDto>
        return itensPedido.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Throwable.class)
    public ItemPedidoDto updateItemPedido(Long id, ItemPedidoDto itemPedidoDto) {
        log.info("ItemPedidoService::atualizarItemPedido");
        log.debug("ID: {}, Valores: {}", id, itemPedidoDto);

        Optional<ItemPedidoModel> itemPedidoOptional = itemPedidoRepository.findById(id);
        if (itemPedidoOptional.isPresent()) {
            ItemPedidoModel itemPedidoModel = itemPedidoOptional.get();
            itemPedidoModel.setQtdeItem(itemPedidoDto.getQtdeItem());
            itemPedidoModel.setValUnidade(itemPedidoDto.getValUnidade());

            itemPedidoModel = itemPedidoRepository.save(itemPedidoModel);
            return toDto(itemPedidoModel);
        } else {
            throw new RuntimeException("Item de Pedido não encontrado com o ID: " + id);
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public void deleteItemPedido(Long id) {
        log.info("ItemPedidoService::deletarItemPedido");
        log.debug("ID: {}", id);

        if (itemPedidoRepository.existsById(id)) {
            itemPedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Item de Pedido não encontrado com o ID: " + id);
        }
    }
}