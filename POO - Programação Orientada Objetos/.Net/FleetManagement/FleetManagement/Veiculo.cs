
using Microsoft.VisualBasic;
using System.Xml.Schema;

public abstract class Veiculo
{

    public string Model { get; set; } = "";
    public int Year { get; set; } = -1;
    public string Manufacturer { get; set; } = "";

    protected Veiculo(string Model, string Manufacturer, int Year)
    {
        this.Model = Model;
        this.Year = Year;
        this.Manufacturer = Manufacturer;
    }

    public abstract String Start();
    public abstract String Stop();

    public virtual void DisplayVehicleInfo()
    {
        Console.WriteLine($"Model:{Model}");
        Console.WriteLine($"Manufacturer: {Manufacturer}");
        Console.WriteLine($"Year:{Year}");
    }

    public override string ToString()
    {
        return $"{Manufacturer} {Model} {Year}";
    }
}