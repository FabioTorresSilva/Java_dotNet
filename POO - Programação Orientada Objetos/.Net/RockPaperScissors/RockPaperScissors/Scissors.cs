
public class Scissors : GameElement
{
    public Scissors(string player) : base("Scissors", player)
    { }

    public override bool Defeat(GameElement anotherGameElement)
    {
        return anotherGameElement is Paper;
    }

    public virtual void DisplayDescription()
    {
        Console.WriteLine($"SCISSORS");
    }

    public override string ToString()
    {
        return $"GRAPHIC ~SCISSORS~ {base.ToString}";
    }
}
