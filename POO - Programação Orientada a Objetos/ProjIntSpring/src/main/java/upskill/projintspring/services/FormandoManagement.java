package upskill.projintspring.services;

import upskill.projintspring.dto.Formando;

import java.util.List;

public interface FormandoManagement {
    public Formando salvar(Formando formando);
    public Formando buscarPorId(Long id);
    public Formando removerFormando(Long id);
    public Formando atualizarFormando(Formando formando);
    public List<Formando> buscarTodosFormandos();
}
