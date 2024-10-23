package LojaComercial;

public class Loja {
    private double numeroId;
    private String descricao;
    private int area;
    private int receitas;

    private static int RENDA_FIXA = 400;

    private static int pequena = 20;
    private static int grande = 100;


    public Loja(double numeroId, String descricao, int area, int receitas) {
        this.numeroId = numeroId;
        this.descricao = descricao;
        this.area = area;
        this.receitas = receitas;
    }

    public double getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(double numeroId) {
        this.numeroId = numeroId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getReceitas() {
        return receitas;
    }

    public void setReceitas(int receitas) {
        this.receitas = receitas;
    }

    public static void setRendaFixa(int rendaFixa) {
        RENDA_FIXA = rendaFixa;
    }

    public double renda() {
        return RENDA_FIXA * (1 + (area / 100.0) + (receitas / 100.0));
    }

    public String classificacao() {
        return (area < pequena) ? "Pequena" : (area > grande) ? "Grande" : "Média";
    }

    public void setGrande(int grande) {
        Loja.grande = grande;
    }

    public static void setPequena(int pequena) {
        Loja.pequena = pequena;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "numeroId=" + numeroId +
                ", descricao='" + descricao + '\'' +
                ", area=" + area +
                ", receitas=" + receitas +
                '}';
    }
}


