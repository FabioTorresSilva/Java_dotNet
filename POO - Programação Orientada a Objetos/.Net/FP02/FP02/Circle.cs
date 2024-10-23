namespace FP02;

public class Circle {
    public Point Center { get; set; }
    public double Radius { get; set; }

    public Circle(Point center, double radius) {
        Center = center;
        Radius = radius;
    }

    public double CalculateArea() {
        return Math.PI * Math.Pow(Radius, 2);
    }

    public double CalculatePerimeter() {
        return 2 * Math.PI * Radius;
    }
}