public class SpecialPaper : GameElement
{
    public SpecialPaper(string player) : base("SpecialPaper", player)
    { }

    public override bool Defeat(GameElement anotherGameElement)
    {
        return (anotherGameElement is Scissors || anotherGameElement is Rock );
        
    }

    public virtual void DisplayDescription()
    {
        Console.WriteLine($"SPECIALPAPER");
    }

    public override string ToString()
    {
        return $"GRAPHIC ~SPECIALPAPER~ {base.ToString}";
    }
}
