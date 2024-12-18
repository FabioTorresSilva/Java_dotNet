package upskill.projintspring.services.implementation;

import org.springframework.stereotype.Service;
import upskill.projintspring.dto.Formando;
import upskill.projintspring.dto.Produto;
import upskill.projintspring.services.FormandoManagement;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormandoArrayImpl implements FormandoManagement {

    private final List<Formando> formandos;

    public FormandoArrayImpl(List<Formando> formandos) {
        this.formandos = new ArrayList<>();
        this.formandos.add(new Formando("Manel", "1",1, 123,"21qwe3"));
    }

    @Override
    public Formando salvar(Formando formando) {
        this.formandos.add(formando);
        return formando;
    }

    @Override
    public Formando buscarPorId(Long id) {
        return formandos.stream()
                .filter(produto -> Long.valueOf(produto.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Formando removerFormando(Long id) {
        Formando formandoEncontrado = formandos.stream()
                .filter(formando -> Long.valueOf(formando.getId()).equals(id))
                .findFirst()
                .orElse(null);
        if (formandoEncontrado != null) {
            formandos.remove(formandoEncontrado);
        }
        return formandoEncontrado;
    }


    @Override
    public Formando atualizarFormando(Formando formando) {
        for (Formando f : formandos) {
            if (Long.valueOf(f.getId()).equals(formando.getId())) {
                formandos.remove(f);
                formandos.add(formando);
                return formando;
            }
        }
        return null;
    }

    @Override
    public List<Formando> buscarTodosFormandos() {
        return formandos;
    }
}
