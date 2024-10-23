package Escolas;

public class MainEscolas {
    public static void main(String[] args) {

        Pessoa[] listaPessoas = new Pessoa[10];

        //(String nome, int numeroId, double vencimentoBase)
        listaPessoas[0] = new ProfAdjunto("Fabio",213);
        listaPessoas[1] = new ProfAssistente("Teófilo",123);
        listaPessoas[2] = new ProfCoordenador("António",1234);
        listaPessoas[3] = new AlunoBolseiro("Manel",213,213,213123);
        listaPessoas[4]= new Aluno("joao",213,123);

        for(int i = 0; i < listaPessoas.length; i++) {
            if(listaPessoas[i] instanceof Pagavel) {

            }
            double resultado = ((Pagavel) listaPessoas[i]).determinarCusto();
        }

    }
}