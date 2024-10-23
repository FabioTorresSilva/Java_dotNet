namespace FP02;

public class Triangle {
    public Point Point1 { get; set; }
    public Point Point2 { get; set; }
    public Point Point3 { get; set; }

    public Triangle(Point p1, Point p2, Point p3) {
        Point1 = p1;
        Point2 = p2;
        Point3 = p3;
    }

    public double CalculateArea() {
        double a = Point1.X * (Point2.Y - Point3.Y);
        double b = Point2.X * (Point3.Y - Point1.Y);
        double c = Point3.X * (Point1.Y - Point2.Y);
        return 0.5 * Math.Abs(a + b + c);
    }

    public double CalculatePerimeter() {
        double side1 = Math.Sqrt(Math.Pow(Point1.X - Point2.X, 2) + Math.Pow(Point1.Y - Point2.Y, 2));
        double side2 = Math.Sqrt(Math.Pow(Point2.X - Point3.X, 2) + Math.Pow(Point2.Y - Point3.Y, 2));
        double side3 = Math.Sqrt(Math.Pow(Point3.X - Point1.X, 2) + Math.Pow(Point3.Y - Point1.Y, 2));
        return side1 + side2 + side3;
    }
}