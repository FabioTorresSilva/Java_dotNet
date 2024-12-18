package upskill.projintspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.projintspring.dto.Produto;
import upskill.projintspring.services.ProdutoManagement;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")

public class ProdutoController {

    // public Produto salvar(Produto produto);
    //    public Produto buscarPorId(Long id);
    //    public Produto removerProdutoId(Long id);
    //    public Produto atualizarProduto(Produto produto);
    //    public List<Produto> listarProdutos();

    @Autowired
    private ProdutoManagement produtos;

    @PostMapping("/salvarProduto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto){
        if(produto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(produto.getId() < 0 || produto.getNome() == null || produto.getPreco() < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Produto produtoSalvo = this.produtos.salvar(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/showProdutoId/{id}")
    public ResponseEntity<Produto> showProdutoId(@PathVariable("id") Long id){
        Produto produto = this.produtos.buscarPorId(id);
        if(produto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProdutoId/{id}")
    public ResponseEntity<String> removeProdutoId (@PathVariable("id") Long id){
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Produto produto = this.produtos.removerProdutoId(id);
            if (produto == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizarProduto")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto){
        if(produto.getId() < 0 || produto.getNome() == null || produto.getPreco() < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Produto produtoAtualizado = this.produtos.atualizarProduto(produto);
        if(produtoAtualizado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @GetMapping("/listarProdutos")
    public ResponseEntity <List<Produto>> getAllProducts(){
        List<Produto> produtos = this.produtos.listarProdutos();
        if(produtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}

