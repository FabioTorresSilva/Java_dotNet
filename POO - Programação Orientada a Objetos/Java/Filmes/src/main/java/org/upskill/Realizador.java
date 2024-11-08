package org.upskill;

public class Realizador {
    private String nome;
    private String nacionalidade;
    private Data dataNascimento;
    private static final String NOME_OMISSAO = "SEM NOME";
    private static final String NACIONALIDADE_OMISSAO = "SEM NACIONALIDADE";

    public Realizador(String nome, String nacionalidade, Data dataNascimento) {
        setNome(nome);
        setNacionalidade(nacionalidade);
        setDataNascimento(new Data(dataNascimento));
    }

    public Realizador() {
        nome = NOME_OMISSAO;
        nacionalidade = NACIONALIDADE_OMISSAO;
        dataNascimento = new Data();
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Data getDataNascimento() {
        return new Data(dataNascimento);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento.setData(dataNascimento);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nNacionalidade: %s\nDataNascimento: %s", nome, nacionalidade, dataNascimento);
    }

}
