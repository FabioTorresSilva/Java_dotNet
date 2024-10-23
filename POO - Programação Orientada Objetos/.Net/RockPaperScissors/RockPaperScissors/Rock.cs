public class Rock : GameElement
{
    public Rock(string player) : base("Rock", player)
    { }

    public override bool Defeat(GameElement anotherGameElement)
    {
        return anotherGameElement is Scissors;

    }

    public virtual void DisplayDescription()
    {
        Console.WriteLine($"ROCK");
    }

    public override string ToString()
    {
        return $"GRAPHIC ~ROCK~ {base.ToString}";
    }
}
