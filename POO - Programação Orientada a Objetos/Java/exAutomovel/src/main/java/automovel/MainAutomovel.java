package automovel;

public class MainAutomovel {
    public static void main(String[] args) {

        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1200);
        System.out.printf("Matricula a1: %s\n", a1.getMatricula());
        System.out.printf("Total Automoveis: %s\n", Automovel.getTotalAutomoveis());

        Automovel a2 = new Automovel("22-22-BB", "Audi");
        System.out.printf("Automovel a2: %s\n", a2);
        a2.setCilindrada(1800);
        System.out.printf("Automovel a2: %s\n", a2);
        System.out.printf("Total Automoveis: %s\n", Automovel.getTotalAutomoveis());
        System.out.printf("Diferença Cilindrada %d\n", a1.calcularDiferencaCilindrada(a2));
        if (a1.isCilindradaMaior(a2)) {
            System.out.printf("Matricula maior cilindrada\n %s\n", a1.getMatricula());
        }else if(a2.isCilindradaMaior(a1)){
            System.out.printf("Matricula maior cilindrada\n %s\n", a2.getMatricula());
        }else {
            System.out.printf("Ambos tem igual cilindrada\n");
        }

        //    public boolean isCilindradaMaior(int cilindrada) {
        if(a2.isCilindradaMaior(2000)) {
            System.out.printf("Cilindrada automovel a1 é maior que 2000cc");
        }else{
            System.out.printf("Cilindrada automovel a1 é inferior a 2000cc");
        }
    }
}