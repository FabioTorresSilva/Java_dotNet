package UtenteGinasio;

public class MainUtenteGinasio {
    public static void main(String[] args) {
        //ARRAY DO TIPO UTENTES GINASIO
        UtenteGinasio[] utentes = new UtenteGinasio[4];
        utentes[0] = new UtenteGinasio();
        utentes[1] = new UtenteGinasio("Fábio", 25);
        utentes[2] = new UtenteGinasio("manel", "Masculino", 22, 1.54, 75);
        utentes[3] = new UtenteGinasio("Miguel", "Masculino", 30, 1.94, 95);

        for(int i = 0 ; i < utentes.length; i++){
            System.out.printf("%S\n",utentes[i].toString());
        }

        for(int i = 0 ; i < utentes.length; i++){
            System.out.printf("%S %.2f %s \n",utentes[i].getNome(), utentes[i].imcUtente(), utentes[i].indiceObesidade());
        }

        for(int i = 0 ; i < utentes.length; i++){
            if(!(utentes[i].indiceObesidade().equals("Saudável"))){
                System.out.printf("%S\n", utentes[i].getNome());
            }
        }

        utentes[2].setPeso(70);
        utentes[3].setPeso(80);
        utentes[2].setAltura(1.80);
        utentes[3].setAltura(1.60);

        for(int i = 0 ; i < utentes.length; i++){
            System.out.printf("%S %.2f %s \n",utentes[i].getNome(), utentes[i].imcUtente(), utentes[i].indiceObesidade());
        }

        utentes[2].setIdade(utentes[3].getIdade());

        System.out.printf("%s", utentes[2].isMaisNovo(utentes[3]) );
    }
}