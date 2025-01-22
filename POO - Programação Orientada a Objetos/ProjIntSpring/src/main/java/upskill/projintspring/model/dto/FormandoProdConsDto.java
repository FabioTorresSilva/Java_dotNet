package upskill.projintspring.model.dto;

import java.util.Objects;

public class FormandoProdCons {
    private Long idProduto;
    private Long idFormando;

    public FormandoProdCons(Long idProduto, Long idFormando) {
        this.idProduto = idProduto;
        this.idFormando = idFormando;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdFormando() {
        return idFormando;
    }

    public void setIdFormando(Long idFormando) {
        this.idFormando = idFormando;
    }

    @Override
    public String toString() {
        return "FormandoProdCons{" +
                "idProduto=" + idProduto +
                ", idFormando=" + idFormando +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FormandoProdCons that = (FormandoProdCons) o;
        return Objects.equals(idProduto, that.idProduto) && Objects.equals(idFormando, that.idFormando);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idFormando);
    }
}
