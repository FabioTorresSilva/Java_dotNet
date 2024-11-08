package org.upskill;

public class Realizador {
    public String nome;
    public String nacionalidade;
    public Data dataNascimento;

    public Realizador(String nome, String nacionalidade, Data dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = new Data() ;
    }

    public Realizador(Realizador outroRealizador) {
        this.nome = outroRealizador.nome;
        this.nacionalidade = outroRealizador.nacionalidade;
        this.dataNascimento = new Data(outroRealizador.dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
