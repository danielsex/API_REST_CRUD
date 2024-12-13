package br.go.senac.ads4.service;

import br.go.senac.ads4.dto.ProdutoDto;
import br.go.senac.ads4.model.ProdutoModel;
import br.go.senac.ads4.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Converter ProdutoDto para ProdutoModel
    private ProdutoModel toModel(ProdutoDto produtoDto) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setDesProduto(produtoDto.getDesProduto());
        produtoModel.setQtdeProduto(produtoDto.getQtdeProduto());
        produtoModel.setValProduto(produtoDto.getValProduto());
        return produtoModel;
    }

    // Converter ProdutoModel para ProdutoDto
    private ProdutoDto toDto(ProdutoModel produtoModel) {
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produtoModel.getId());
        produtoDto.setDesProduto(produtoModel.getDesProduto());
        produtoDto.setQtdeProduto(produtoModel.getQtdeProduto());
        produtoDto.setValProduto(produtoModel.getValProduto());
        return produtoDto;
    }

    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDto create(ProdutoDto produtoDto) {
        log.info("ProdutoService::criar");
        log.debug("Valores: {}", produtoDto);

        // Converter DTO para Model
        ProdutoModel produtoModel = toModel(produtoDto);
        ProdutoModel produtoSalvo = produtoRepository.save(produtoModel);
        return toDto(produtoSalvo);
    }

    @Transactional(readOnly = true)
    public ProdutoDto read(Long id) {
        log.info("ProdutoService::ler(id)");
        log.debug("Valores: {}", id);

        // Busca o produto pelo ID
        Optional<ProdutoModel> produtoEncontrado = produtoRepository.findById(id);
        if (produtoEncontrado.isPresent()) {
            ProdutoModel produtoModel = produtoEncontrado.get();
            return toDto(produtoModel);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<ProdutoDto> lerTodos() {
        log.info("ProdutoService::lerTodos");
        log.debug("Valores: sem parâmetros");

        // Pesquisar todos os produtos
        List<ProdutoModel> listaDeProdutos = produtoRepository.findAll();

        // Converter a lista de ProdutoModel para ProdutoDto
        return listaDeProdutos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Throwable.class)
    public ProdutoDto update(Long id, ProdutoDto produtoDto) {
        log.info("ProdutoService::atualizar");
        log.debug("Valores: {} e {}", id, produtoDto);

        // Consultar o registro para verificar se o ID existe
        Optional<ProdutoModel> produtoEncontrado = produtoRepository.findById(id);
        if (produtoEncontrado.isPresent()) {
            ProdutoModel produtoModel = produtoEncontrado.get();
            // Atualizar os dados do modelo
            produtoModel.setDesProduto(produtoDto.getDesProduto());
            produtoModel.setQtdeProduto(produtoDto.getQtdeProduto());
            produtoModel.setValProduto(produtoDto.getValProduto());

            ProdutoModel produtoAtualizado = produtoRepository.save(produtoModel);
            return toDto(produtoAtualizado);
        }

        return null;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void delete(Long id) {
        log.info("ProdutoService::deletar");
        log.debug("Valores: {}", id);

        // Excluir o produto pelo ID
        produtoRepository.deleteById(id);
    }
}
