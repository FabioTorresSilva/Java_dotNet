
package upskill.geometria2D;

public class Circulo {
    
    private double raio;
    private static final int RAIO_POR_OMISSAO = 0;

    public Circulo(double raio) {        
        this.raio = raio;
    }

    public Circulo() {
        raio = RAIO_POR_OMISSAO;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return String.format("círculo com raio = %.2f", raio);
    }
    
    public double area(){
        return Math.PI* Math.pow(raio, 2);
    }
    
    public double perimetro(){
        return 2*Math.PI*raio;
    }  
    
}
