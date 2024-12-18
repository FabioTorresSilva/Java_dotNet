package upskill.projintspring.services.implementation;

import org.springframework.stereotype.Service;
import upskill.projintspring.dto.Produto;
import upskill.projintspring.services.ProdutoManagement;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoArrayImpl implements ProdutoManagement {

    private final List<Produto> produtos;

    public ProdutoArrayImpl(List<Produto> produtos) {
        this.produtos = new ArrayList<>();
        this.produtos.add(new Produto ("Arroz", 123,1));
    }

    @Override
    public Produto salvar(Produto produto) {
        this.produtos.add(produto);
        return produto;
    }

    @Override
    public Produto buscarPorId(Long id) {
        return produtos.stream()
                .filter(produto -> Long.valueOf(produto.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Produto removerProdutoId(Long id) {
        Produto produtoEncontrado = produtos.stream()
                .filter(produto -> Long.valueOf(produto.getId()).equals(id))
                .findFirst()
                .orElse(null);
        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
        }
        return produtoEncontrado;
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (Long.valueOf(p.getId()).equals(produto.getId())) {
                produtos.remove(p);
                produtos.add(produto);
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtos;
    }
}
