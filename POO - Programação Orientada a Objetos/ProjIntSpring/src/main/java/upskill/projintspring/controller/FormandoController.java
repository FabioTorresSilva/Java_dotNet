package upskill.projintspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.projintspring.dto.Formando;
import upskill.projintspring.services.FormandoManagement;
import upskill.projintspring.services.ProdutoManagement;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formandos")


public class FormandoController {

    @Autowired
    private FormandoManagement formandos;

    //    public Formando salvar(Formando formando);
    //    public Formando buscarPorId(Long id);
    //    public Formando removerFormando(Long id);
    //    public Formando atualizarFormando(Formando formando);
    //    public List<Formando> buscarTodosFormandos();

    @PostMapping("/salvarFormando")
    public ResponseEntity<Formando> salvarFormando(@RequestBody Formando formando) {
        if (formando == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (formando.getId() < 0 || formando.getNome() == null || formando.getEmail() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Formando formandoSalvo = this.formandos.salvar(formando);
        return new ResponseEntity<>(formandoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/showFormandoId/{id}")
    public ResponseEntity<Formando> showFormandoId(@PathVariable("id") Long id) {
        Formando formando = this.formandos.buscarPorId(id);
        if (formando == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(formando, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFormandoId/{id}")
    public ResponseEntity<String> removeFormandoId(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Formando formando = this.formandos.removerFormando(id);
        if (formando == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizarFormando")
    public ResponseEntity<Formando> atualizarFormando(@RequestBody Formando formando) {
        if (formando.getId() < 0 || formando.getNome() == null || formando.getEmail() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Formando formandoAtualizado = this.formandos.atualizarFormando(formando);
        if (formandoAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(formandoAtualizado, HttpStatus.OK);
    }

    @GetMapping("/buscarTodosFormandos")
    public ResponseEntity<List<Formando>> getAllFormandos() {
        List<Formando> todosFormandos = this.formandos.buscarTodosFormandos();
        if (todosFormandos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todosFormandos, HttpStatus.OK);
    }
}
