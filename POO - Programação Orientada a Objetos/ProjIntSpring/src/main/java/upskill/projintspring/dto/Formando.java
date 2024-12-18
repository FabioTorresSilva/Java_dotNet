package upskill.projintspring.dto;

import java.util.Objects;

public class Formando {
    private String nome;
    private String email;
    private long id;
    private double saldo;
    private String nif;

    public Formando(String nome, String email, long id, double saldo, String nif) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.saldo = saldo;
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Formando formando = (Formando) o;
        return id == formando.id && Double.compare(saldo, formando.saldo) == 0 && Objects.equals(nome, formando.nome) && Objects.equals(email, formando.email) && Objects.equals(nif, formando.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, id, saldo, nif);
    }

    @Override
    public String toString() {
        return "Formando{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", saldo=" + saldo +
                ", nif='" + nif + '\'' +
                '}';
    }
}
