using System.Reflection;
using System.Runtime.CompilerServices;

public abstract class GameElement
{
    public string Element { get; } = "";
    public string Player { get; } = "";


    protected GameElement(string Element, string Player)
    {
        this.Element = Element;
        this.Player = Player;
    }

    public Boolean Draw(GameElement anotherGameElement)
    {
        return anotherGameElement.Element == this.Element;
    }

    public override string ToString()
    {
        return $"{Element} {Player}";
    }

    public virtual void DisplayDescription()
    {
        Console.WriteLine($"Player:{Player}");
        Console.WriteLine($"Element: {Element}");
    }

    public abstract Boolean Defeat(GameElement anotherGameElement);

}