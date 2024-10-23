namespace FP02;

public class Rectangle
{
    public Point TopLeft { get; set; }
    public double Width { get; set; }
    public double Height { get; set; }

    public Rectangle(Point topLeft, double width, double height)
    {
        TopLeft = topLeft;
        Width = width;
        Height = height;
    }

    public double CalculateArea()
    {
        return Width * Height;
    }

    public double CalculatePerimeter()
    {
        return 2 * (Width + Height);
    }

    public bool OverlapsWith(Rectangle otherRectangle)
    {
        // Check if this rectangle overlaps with the other rectangle
        return (TopLeft.X < otherRectangle.TopLeft.X + otherRectangle.Width) &&
               (TopLeft.X + Width > otherRectangle.TopLeft.X) &&
               (TopLeft.Y < otherRectangle.TopLeft.Y + otherRectangle.Height) &&
               (TopLeft.Y + Height > otherRectangle.TopLeft.Y);
    }
}