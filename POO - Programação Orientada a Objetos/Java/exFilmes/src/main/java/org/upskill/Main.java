package org.upskill;

public class Main {
    public static void main(String[] args) {
        try {
            // Criação de realizadores
            Data dataNascimentoRealizador1 = new Data(1960, 5, 12);
            Realizador realizador1 = new Realizador("Steven Spielberg", "Americano", dataNascimentoRealizador1);

            Data dataNascimentoRealizador2 = new Data(1975, 3, 15);
            Realizador realizador2 = new Realizador("Quentin Tarantino", "Americano", dataNascimentoRealizador2);

            // criação de filmes válidos
            Filme filme1 = new Filme("Jurassic Park", 1993, realizador1, Categoria.ACAO);
            Filme filme2 = new Filme("Pulp Fiction", 1994, realizador2, Categoria.DRAMA);

            System.out.println("Filmes criados com sucesso:");
            System.out.println(filme1.getTitulo() + " - " + filme1.getAnoRealizacao() + " - " + filme1.getCategoria());
            System.out.println(filme2.getTitulo() + " - " + filme2.getAnoRealizacao() + " - " + filme2.getCategoria());

            //exceção de ano inválido
            try {
                Filme filmeAnoInvalido = new Filme("Um filme impossível", 1800, realizador1, Categoria.TERROR);
            } catch (AnoInvalidoException e) {
                System.out.println("Exceção de ano inválido capturada: " + e.getMessage());
            }

            // categoria inválida (categoria nula)
            try {
                Filme filmeCategoriaInvalida = new Filme("Um filme sem categoria", 2000, realizador1, null);
            } catch (CategoriaInvalidaException e) {
                System.out.println("Exceção de categoria inválida capturada: " + e.getMessage());
            }

            // lista de filmes com identificador inválido
            try {
                ListaFilmes listaInvalida = new ListaFilmes("123Lista");
            } catch (IdentificadorInvalidoException e) {
                System.out.println("Exceção de identificador inválido capturada: " + e.getMessage());
            }

            // lista de filmes válida
            ListaFilmes listaFilmes = new ListaFilmes("ListaAventura");
            listaFilmes.adicionarFilme(filme1);
            listaFilmes.adicionarFilme(filme2);

            System.out.println("Lista de filmes criada com sucesso: " + listaFilmes.getIdentificador());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
