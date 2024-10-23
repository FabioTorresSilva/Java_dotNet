
package upskill.geometria2D;

public class Retangulo {
    
    private double comprimento;
    private double largura;

    private static final int COMPRIMENTO_POR_OMISSAO = 0;
    private static final int LARGURA_POR_OMISSAO = 0;

    public Retangulo(double comprimento, double largura) {       
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public Retangulo() {     
        comprimento = COMPRIMENTO_POR_OMISSAO;
        largura = LARGURA_POR_OMISSAO;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    @Override
    public String toString() {
        return String.format("retângulo com comprimento = %.2f e largura = %.2f",comprimento, largura);
    }
    
    public double area(){
        return comprimento*largura;
    }
    
    public double perimetro(){
        return 2*comprimento + 2* largura;
    }   
}
