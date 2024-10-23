package data;

public class MainData {
    public static void main(String[] args) {
        //a)
        Data data1 = new Data(2024, 10, 11);
        //b)
        System.out.printf("%s\n", data1);
        //c)
        Data data2 = new Data(1974, 4, 25);
        //d)
        System.out.printf("%s \n", data2.toAnoMesDiaString());
        //e)
        System.out.printf("Data1 mais recente que data2?\n");
        if (data1.isMaior(data2)) {
            System.out.printf("data1 é mais recente\n");
        } else {
            System.out.printf("data1 é mais antiga\n");
        }
        //f)
        System.out.printf("Diferença de dias data1 e data2: \n");
        System.out.printf("%d dias\n", data1.calcularDiferenca(data2));
        //g)
        System.out.printf("dias até natal:\n");
        System.out.printf("%d\n", data1.calcularDiferenca(2024,12,25));
        //h)

        //i)
        System.out.printf("1974 foi ano bissexto?\n");
        if(Data.isAnoBissexto(data2.getAno())){
            System.out.printf("Sim");
        }else{
            System.out.printf("Nao");
        }

    }
}