package upskill.projintspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.projintspring.dto.Formando;
import upskill.projintspring.dto.FormandoProdCons;
import upskill.projintspring.services.FormandoProdConsManagement;
import upskill.projintspring.services.ProdutoManagement;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formando")

public class FormandoProdConsController {
    // FormandoProdCons adicionarAssociacao(Long formandoId, Long produtoId);
    //    List<FormandoProdCons> buscarProdutosPorFormando(Long formandoId);

    @Autowired
    private FormandoProdConsManagement produtos;

    //POST: /api/formando/{id}/compra/{id}
    @PostMapping("/{idform}/compra/{idprod}")
    public ResponseEntity<FormandoProdCons> associarProdutoFormando(@PathVariable("idform") Long formandoId, @PathVariable("idprod") Long produtoId)  {
        try {
            FormandoProdCons associacao = this.produtos.adicionarAssociacao(formandoId, produtoId);
            return new ResponseEntity<>(associacao, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FormandoProdCons>> getAllProdutosFormando(@PathVariable("id") Long id) {
        List<FormandoProdCons> todosProdutos = this.produtos.buscarProdutosPorFormando(id);
        if (todosProdutos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todosProdutos, HttpStatus.OK);
    }


}
