package org.upskill;

import java.util.Calendar;

public class Filme {
    public String titulo;
    public int anoRealizacao;
    public Realizador realizador;
    public Categoria categoria;


    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);

    public Filme(String titulo, int anoRealizacao, Realizador realizador, Categoria categoria) {
        if (anoRealizacao < 1850 || anoRealizacao > year)
            throw new AnoInvalidoException("Ano Realizacao Invalido");
        if (categoria == null) {
            throw new CategoriaInvalidaException("Categoria não pode ser nula.");
        }
        this.titulo = titulo;
        this.anoRealizacao = anoRealizacao;
        this.realizador = realizador;
        this.categoria = categoria;
    }

    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setAnoRealizacao(int anoRealizacao) {
        if (anoRealizacao < 1850 || anoRealizacao > year)
            throw new AnoInvalidoException("Ano Realizacao Invalido");
        this.anoRealizacao = anoRealizacao;
    }

    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new CategoriaInvalidaException("Categoria não pode ser nula.");
        }
        this.categoria = categoria;
    }

    public Realizador getRealizador() {
        return realizador;
    }

    public void setRealizador(Realizador realizador) {
        this.realizador = realizador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
