
package upskill.geometria2D;


public class TesteFiguras {

    public static void main(String[] args) {
        
        System.out.println("\n### Figuras Construídas ###");
        
        Circulo c1 = new Circulo();
        System.out.println(c1.toString());

        Circulo c2 = new Circulo(7);
        System.out.println(c2);

        Retangulo r1 = new Retangulo();
        System.out.println(r1);

        Retangulo r2 = new Retangulo(5, 2);
        System.out.println(r2);  
        
        System.out.printf("%nRaio do 1º circulo é igual a %.2f", c1.getRaio());
        System.out.printf("%nComprimento do 2º retangulo é igual a %.2f", r2.getComprimento());
        
        c2.setRaio(10);
        r1.setComprimento(11);
        
        System.out.printf("%nÁrea do %s é igual a %.2f", c2,c2.area());
        System.out.printf("%nPerímetro do %s é igual a %.2f", c2,c2.perimetro());
        
        System.out.printf("%nÁrea do %s é igual a %.2f", r2,r2.area());
        System.out.printf("%nPerímetro do %s é igual a %.2f", r2,r2.perimetro());
        
    }
}
