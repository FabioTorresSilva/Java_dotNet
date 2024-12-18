package upskill.projintspring.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upskill.projintspring.dto.Formando;
import upskill.projintspring.dto.FormandoProdCons;
import upskill.projintspring.dto.Produto;
import upskill.projintspring.services.FormandoManagement;
import upskill.projintspring.services.FormandoProdConsManagement;
import upskill.projintspring.services.ProdutoManagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormandoProdImpl implements FormandoProdConsManagement {

    private final List<FormandoProdCons> prodsFormando;

    @Autowired
    private FormandoManagement formandoService;

    @Autowired
    private ProdutoManagement produtoService;

    public FormandoProdImpl() {
        this.prodsFormando = new ArrayList<>();
    }

    @Override
    public FormandoProdCons adicionarAssociacao(Long formandoId, Long produtoId) {
        boolean existe = this.prodsFormando.stream()
                .anyMatch(a -> a.getIdFormando().equals(formandoId) && a.getIdProduto().equals(produtoId));

        if (existe) {
            throw new IllegalStateException("O formando já adquiriu este produto.");
        }
        FormandoProdCons associacao = new FormandoProdCons(formandoId, produtoId);
        this.prodsFormando.add(associacao);
        return associacao;
    }

    @Override
    public List<FormandoProdCons> buscarProdutosPorFormando(Long formandoId) {
        return this.prodsFormando.stream()
                .filter(a -> a.getIdFormando().equals(formandoId))
                .collect(Collectors.toList());
    }

    @Override
    public Formando comprarProduto(Long formandoId, Long produtoId) {
        Formando formando = formandoService.buscarPorId(formandoId);
        Produto produto = produtoService.buscarPorId(produtoId);
        if (formando == null) {
            throw new IllegalArgumentException("Formando não encontrado.");
        }
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        double novoSaldo = formando.getSaldo() - (produto.getPreco());
        formando.setSaldo(novoSaldo);
        this.adicionarAssociacao(formandoId, produtoId);
        return formando;
    }
}
