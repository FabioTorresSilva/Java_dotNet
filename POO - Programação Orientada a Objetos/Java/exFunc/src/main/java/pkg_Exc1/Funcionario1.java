package pkg_Exc1;


public class Funcionario1 {
    private String nome;
    private float vencimento;
    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final float VENC_POR_OMISSAO = 500;
    public Funcionario1() throws ExcecaoAlfabetoEspaco {
        setNome(NOME_POR_OMISSAO);
        setVencimento(VENC_POR_OMISSAO);
    }
    public Funcionario1(String nome, float vencimento) {
        setNome(nome);
        setVencimento(vencimento);
    }
    public String getNome() {
        return nome;
    }
    public float getVencimento() {
        return vencimento;
    }
    public void setNome(String nome) {
        char c;
        for(int i=0;i<nome.length();i++){
            c = nome.charAt(i);
            if (Character.isLetter(c)== false && Character.isSpaceChar(c)== false)
                throw new ExcecaoAlfabetoEspaco("O " + nome +" tem caracteres que não são letras");
        }
        this.nome = nome;
    }
    public void setVencimento(float vencimento) {
//        if(vencimento<0 )
//            throw new ExcecaoVencimentoNegativo("Vencimento negativo!");

        this.vencimento = vencimento;
    }


    public String toString() {
        return nome + " tem o vencimento de " + vencimento;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Funcionario1 obj = (Funcionario1) outroObjeto;
        return this.nome.equalsIgnoreCase(obj.nome) &&
                this.vencimento == obj.vencimento;
    }
}
