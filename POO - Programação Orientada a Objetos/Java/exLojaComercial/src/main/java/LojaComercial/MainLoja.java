package LojaComercial;

public class MainLoja {
    public static void main(String[] args) {

        // public Loja(double numeroId, String descricao, int area, int receitas) {
        //        this.numeroId = numeroId;
        //        this.descricao = descricao;
        //        this.area = area;
        //        this.receitas = receitas;
        //        rendaFixa = RENDA_FIXA;
        //    }

        Loja loja1 = new Loja(444, "arroz", 20, 123);
        Loja loja2 = new Loja(555, "massa", 50, 1235);
        Loja loja3 = new Loja(666, "alimentares", 100, 1234);

        // public String classificacao(int area){
        //        return (area < pequena) ?  "Pequena" : (area> grande) ? "Grande" : "Média";
        //    }
        System.out.printf("Area Loja 1: %.2f\n", loja1.getArea());
        System.out.printf("Classificação Loja 1: %S\n", loja1.classificacao());
        System.out.printf("Area Loja 2: %.2f\n", loja2.getArea());
        System.out.printf("Classificação Loja 2: %S\n", loja2.classificacao());
        System.out.printf("Area Loja 3: %.2f\n", loja3.getArea());
        System.out.printf("Classificação Loja 3: %S\n", loja1.classificacao());

        // alterar valor area pequena
        Loja.setPequena(50);

        //d) Execute novamente o passo b) e verifique eventuais alterações no resultado.
        System.out.printf("Area Loja 1: %.2f\n", loja1.getArea());
        System.out.printf("Classificação Loja 1: %S\n", loja1.classificacao());
        System.out.printf("Area Loja 2: %.2f\n", loja2.getArea());
        System.out.printf("Classificação Loja 2: %S\n", loja2.classificacao());
        System.out.printf("Area Loja 3: %.2f\n", loja3.getArea());
        System.out.printf("Classificação Loja 3: %S\n", loja1.classificacao());


    }
}