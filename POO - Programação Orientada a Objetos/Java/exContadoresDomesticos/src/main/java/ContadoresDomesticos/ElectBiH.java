package ContadoresDomesticos;

public  class ElectBiH extends ContadoresElect {
    private int consumoForaVazio;
    private static double custoVazio = 0.066;
    private static double custoForaVazio = 0.14;

    public ElectBiH(String cliente, int consumoVazio, double potencia, int consumoForaVazio) {
        super(cliente, consumoVazio, potencia);
        this.consumoForaVazio = consumoForaVazio;
    }

    public int getConsumoForaVazio() {
        return this.consumoForaVazio;
    }

    public void setConsumoForaVazio(int consumoForaVazio) {
        this.consumoForaVazio = consumoForaVazio;
    }

    public String toString() {
        return String.format("%s Consumo Vazio: %d Consumo Fora do Vazio: %d", super.toString(), super.getConsumo(), consumoForaVazio);
    }

    public double calcularCusto() {
        return (double) super.getConsumo() * getCustoVazio() + (double) consumoForaVazio * getCustoForaVazio();
    }

    public static double getCustoVazio() {
        return custoVazio;
    }

    public static double getCustoForaVazio() {
        return custoForaVazio;
    }

    public static void setCustoVazio(double custoVazio) {
        ElectBiH.custoVazio = custoVazio;
    }

    public static void setCustoForaVazio(double custoForaVazio) {
        ElectBiH.custoForaVazio = custoForaVazio;
    }
}