package ContadoresDomesticos;

public abstract class Contador {
    private String cliente;
    private String id;
    private int consumo;

    private static final String CLIENTE_POR_OMISSAO = "sem cliente";
    //id por omissao n faz sentido pois ira ser criado por nos
    //private static final String ID_POR_OMISSAO = "sem id";
    private static final int CONSUMO_POR_OMISSAO = -1;

    public Contador(String cliente, String id, int consumo) {
        this.cliente = cliente;
        this.id = id;
        this.consumo = consumo;
    }

    public String getNome() {
        return cliente;
    }

    public String getId() {
        return id;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setNome(String cliente) {
        this.cliente = cliente;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return String.format("Contador %s do Dono %s com consumo %d", id, cliente, consumo);
    }

    public abstract double calcularCusto();
}

