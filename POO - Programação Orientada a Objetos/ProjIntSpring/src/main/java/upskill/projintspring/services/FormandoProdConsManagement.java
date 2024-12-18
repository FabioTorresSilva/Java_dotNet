package upskill.projintspring.services;

import upskill.projintspring.dto.Formando;
import upskill.projintspring.dto.FormandoProdCons;

import java.util.List;

public interface FormandoProdConsManagement {
    FormandoProdCons adicionarAssociacao(Long formandoId, Long produtoId);
    List<FormandoProdCons> buscarProdutosPorFormando(Long formandoId);
    Formando comprarProduto(Long formandoId, Long produtoId);
}
