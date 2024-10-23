public abstract class Carro : Veiculo
{
    public int NumberOfDoors { get; set; } = 3;

    public Carro(string Model, string Manufacturer, int Year, int NumberOfDoors)
        : base(Model, Manufacturer, Year)
    {
        this.NumberOfDoors = NumberOfDoors;
    }

    public override string Stop()
    {
        return "Car stoped.";
    }
    public override string Start()
    {
        return "Car Started.";
    }

    public override string ToString()
    {
        return $"Car : {base.ToString()} with {NumberOfDoors}";
    }
}