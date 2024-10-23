package ContadoresDomesticos;

public abstract class ContadoresElect extends Contador {
    private double potencia;
    private static int numContadoresElect = 0;
    private final static String prefixoElect = "ELECT-";

    public ContadoresElect(String cliente, int consumo, double potencia){
        super(cliente,prefixoElect + (numContadoresElect+1),consumo);
        this.potencia=potencia;
        numContadoresElect++;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String toString() {
        return String.format("%s Potência contradada: %.1f", super.toString(), this.getPotencia());
    }

    public abstract double calcularCusto();

    public static int getNumContadoresElect() {
        return numContadoresElect;
    }
}
