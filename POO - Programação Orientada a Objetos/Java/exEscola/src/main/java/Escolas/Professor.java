package Escolas;

public abstract class Professor extends Pessoa implements Pagavel{

    private double vencimentoBase = 1500;

    public Professor() {
        super();
    }

   public Professor(String nome, int numeroId){
        super(nome,numeroId);
   }

    public double getVencimentoBase() {
        return vencimentoBase;
    }

    public void setVencimentoBase(double vencimentoBase) {
        this.vencimentoBase = vencimentoBase;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double calcularVencimento() {
        return this.vencimentoBase * getModificador();
    };

    public double determinarCusto() {
        return this.vencimentoBase * getModificador();
    }

    public abstract double getModificador();
}
