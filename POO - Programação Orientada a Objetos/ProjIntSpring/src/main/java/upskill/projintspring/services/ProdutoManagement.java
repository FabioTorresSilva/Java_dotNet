package upskill.projintspring.services;

import upskill.projintspring.dto.Produto;

import java.util.List;

public interface ProdutoManagement {
    public Produto salvar(Produto produto);
    public Produto buscarPorId(Long id);
    public Produto removerProdutoId(Long id);
    public Produto atualizarProduto(Produto produto);
    public List<Produto> listarProdutos();

}
