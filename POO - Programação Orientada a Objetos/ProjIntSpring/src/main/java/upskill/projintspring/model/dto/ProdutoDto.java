package upskill.projintspring.model.dto;

import java.util.Objects;

public class Produto {
    private String nome;
    private double preco;
    private long id;

    public Produto(String nome, double preco, long id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(preco, produto.preco) == 0 && id == produto.id && Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco, id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", id=" + id +
                '}';
    }
}
