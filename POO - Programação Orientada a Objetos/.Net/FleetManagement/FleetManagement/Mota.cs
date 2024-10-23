public abstract class Mota : Veiculo
{

    public Boolean HasSideCar { get; set; }

    public Mota(string Model, string Manufacturer, int Year, Boolean HasSideCar)
        : base(Model, Manufacturer, Year)
    {
        this.HasSideCar = HasSideCar;
    }

    public override string Stop()
    {
        return "Motorcycle stoped.";
    }
    public override string Start()
    {
        return "Motorcycle Started.";
    }


    public override string ToString()
    {
        return $"Motorcycle : {base.ToString()} with {(HasSideCar ? "Yes" : "No")}";
    }
}