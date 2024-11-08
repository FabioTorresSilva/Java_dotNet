package pkg_Exc1;

public class ExcecaoVencimentoNegativo extends RuntimeException{
    public ExcecaoVencimentoNegativo() {
        super();
    }
    public ExcecaoVencimentoNegativo(String msg) {
        super(msg);
    }
}

