package UtenteGinasio;

public class UtenteGinasio {

    /**
     * O nome de identificação da Utente.
     */
    private String nome;

    /**
     * O genero do utente.
     */
    private String genero;

    /**
     * O idade do utente.
     */
    private int idade;

    /**
     * O altura do utente.
     */
    private double altura;

    /**
     * O peso do utente.
     */
    private double peso;

    /**
     * O nome de identificação da Utente por omissao.
     */
    private final static String NOME_POR_OMISSAO = "sem nome";

    /**
     * O genero do Utente por omissao.
     */
    private final static String GENERO_POR_OMISSAO = "sem genero";

    /**
     * A idade do Utente por omissao.
     */
    private static final int IDADE_POR_OMISSAO = 0;

    /**
     * O altura do utente por omissao.
     */
    private static final double ALTURA_POR_OMISSAO = 0;

    /**
     * O peso por omissao.
     */
    private static final double PESO_POR_OMISSAO = 0;

    /**
     * total utentes criados
     */
    private static int maxIMC = 25;
    private static int minIMC = 18;
    private static int totalUtentesCriados = 0;

    /**
     * Constrói uma instância de UtenteGinasio recebendo o nome, o genero, a idade, a alura e o peso.
     *
     * @param nome   o nome do utente.
     * @param genero a genero do utente
     * @param idade  a idade do utente.
     * @param altura aaltura do utente.
     * @param peso   o peso do utente.
     */
    public UtenteGinasio(String nome, String genero, int idade, double altura, double peso) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        totalUtentesCriados++;
    }

    public UtenteGinasio() {
        this.nome = NOME_POR_OMISSAO;
        this.genero = GENERO_POR_OMISSAO;
        this.idade = IDADE_POR_OMISSAO;
        this.altura = ALTURA_POR_OMISSAO;
        this.peso = PESO_POR_OMISSAO;
        totalUtentesCriados++;
    }

    public UtenteGinasio(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.genero = GENERO_POR_OMISSAO;
        this.altura = ALTURA_POR_OMISSAO;
        this.peso = PESO_POR_OMISSAO;
        totalUtentesCriados++;
    }

    /**
     * Devolve o nome do utente.
     *
     * @return nome do utente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o genero do utente.
     *
     * @return genero do utente.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Devolve a idade do utente.
     *
     * @return idade do utente.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Devolve o altura do utente.
     *
     * @return altura do utente.
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Devolve o peso do utente.
     *
     * @return peso do utente.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Modifica o nome do utente.
     *
     * @param nome o novo nome do utente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o genero do utente.
     *
     * @param genero o novo genero do utente.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Modifica a idade do utente.
     *
     * @param idade a nova idade do utente.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Modifica o altura do utente.
     *
     * @param altura a nova altura do utente.
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Modifica o peso do utente.
     *
     * @param peso o novo peso do utente.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Devolve a descricao textual do utente com nome, genero,idade,altura,peso
     *
     * @return dados do utente.
     */
    @Override
    public String toString() {
        return "UtenteGinasio{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    /**
     * Devolve o valor absoluto da diferença de idades de dois utentes.
     *
     * @return diferenca abs idades
     */
    public double diferencaIdades(UtenteGinasio OutroUtente) {
        return Math.abs(idade - OutroUtente.getIdade());
    }

    /**
     * Devolve o valor de imc do utente.
     *
     * @return valor imc Utente.
     */
    public double imcUtente() {
        return altura != 0 ? (peso / Math.pow(altura, 2)):0;
    }

    /**
     * Devolve o Indice relativo ao Imc do Utente (Obeso, Saudavel, Magro).
     *
     * @return Indice relativo ao Imc do Utente.
     */
    public String indiceObesidade() {
        return (imcUtente() < minIMC ? "Magro" : imcUtente() > maxIMC ? "Obeso" : "Saudável");
    }

    /**
     * Devolve o se utente e ou nao saudavel.
     *
     * @return utente e ou nao saudavel.
     */
    public String checksSaudavel() {
        return (indiceObesidade().equals("Saudável") ? "É saudável" : "não é saudável");
    }

    /**
     * Devolve o se utente e ou nao mais novo que outro
     *
     * @return utente e mais novo que outro.
     */
    public String isMaisNovo(UtenteGinasio OutroUtente) {
        return (idade < OutroUtente.getIdade()) ? "é mais novo" : (idade > OutroUtente.getIdade()) ? "é mais velho" : "possuem a mesma idade";
    }

    /**
     * Devolve o valor utentes totais.
     *
     * @return numero utentes.
     */
    public static int getTotalUtentesCriados() {
        return totalUtentesCriados;
    }
}

