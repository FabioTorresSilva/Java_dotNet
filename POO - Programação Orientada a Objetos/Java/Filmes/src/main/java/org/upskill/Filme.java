package org.upskill;

public class Filme {
    private String titulo;
    private int ano;
    private Realizador realizador;
    private Categoria categoria;
    private static final String TITULO_OMISSAO = "SEM_TITULO";
    private static final int ANO_OMISSAO = 1895;
    private static final Categoria CATEGORIA_OMISSAO = Categoria.DRAMA;

    public Filme(String titulo, int ano, Realizador realizador, Categoria categoria) {
        setTitulo(titulo);
        setAno(ano);
        setRealizador(realizador);
        setCategoria(categoria);
    }

    public Filme(String titulo, int ano, Realizador realizador, String categoria) {
        setTitulo(titulo);
        setAno(ano);
        setRealizador(realizador);
        setCategoria(categoria);;
    }

    public Filme() {
        titulo = TITULO_OMISSAO;
        ano = ANO_OMISSAO;
        realizador = new Realizador();
        categoria = CATEGORIA_OMISSAO;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public Realizador getRealizador() {
        return realizador;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        if (ano < 1850 || ano > Data.dataAtual().getAno()) {
            throw new AnoInvalidoException(String.format("ERRO: Este ano: %d é inválido.", ano));
        }
        this.ano = ano;
    }

    public void setRealizador(Realizador realizador) {
        this.realizador = realizador;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCategoria(String c) {
        boolean f = false;
        for (Categoria i : Categoria.values()) {
            if (i.nome.equalsIgnoreCase(c)) {
                categoria = i;
                f = true;
                break;
            }
        }
        if (!f) {
            throw new CategoriaInvalidaException(String.format("ERRO: Esta categoria: %s é inválida.", c));
        }
    }

    @Override
    public String toString() {
        return String.format("Titulo: %s\nAno: %s\nRealizador: %s\nCategoria: %s\n", titulo, ano, realizador, categoria);
    }
}
