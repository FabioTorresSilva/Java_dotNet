package ContadoresDomesticos;

public class ElectSimples extends ContadoresElect {
    private static double potLimite = 6.9;
    private static double custoMenor = 0.13;
    private static double custoMaior = 0.16;

    public ElectSimples(String cliente, int consumo, double potencia) {
        super(cliente, consumo, potencia);
    }

    public String toString() {
        return String.format("%s Consumo: %d", super.toString(), super.getConsumo());
    }


    public static double getPotLimite() {
        return potLimite;
    }

    public static double getCustoMenor() {
        return custoMenor;
    }

    public static double getCustoMaior() {
        return custoMaior;
    }

    public static void setPotLimite(double potLimite) {
        ElectSimples.potLimite = potLimite;
    }
    public double calcularCusto() {
        return super.getPotencia() < potLimite ? (double)super.getConsumo() * getCustoMenor() : (double)super.getConsumo() * getCustoMaior();
    }

    public static void setCustoMenor(double custoMenor) {
        ElectSimples.custoMenor = custoMenor;
    }

    public static void setCustoMaior(double custoMaior) {
        ElectSimples.custoMaior = custoMaior;
    }
}

