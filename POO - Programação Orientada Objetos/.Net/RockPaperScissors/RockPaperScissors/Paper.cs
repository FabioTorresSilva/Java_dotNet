public class Paper : GameElement
{
    public Paper(string player) : base("Paper", player)
    { }

    public override bool Defeat(GameElement anotherGameElement)
    {
        return (anotherGameElement is Rock || anotherGameElement is SpecialPaper);
    }

    public virtual void DisplayDescription()
    {
        Console.WriteLine($"PAPER");
    }

    public override string ToString()
    {
        return $"GRAPHIC ~PAPER~ {base.ToString}";
    }
}
