package ContadoresDomesticos;

public class ContadoresGas extends Contador {

    private static int contadorContadoresGas = 0;
    private static double custo = 0.8;
    private final static String prefixoGas = "GAS-";

    //public Contador(String cliente, int consumo) {
    public ContadoresGas(String cliente, int consumo) {
        super(cliente, prefixoGas + (contadorContadoresGas + 1), consumo);
        contadorContadoresGas++;
    }

    public static double getCustoUnitario() {
        return custo;
    }

    public static int getContadorContadoresGas() {
        return contadorContadoresGas;
    }

    public static void setCustoUnitario(double custo) {
        ContadoresGas.custo = custo;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double calcularCusto() {
        return custo * (double)super.getConsumo();
    }
}
