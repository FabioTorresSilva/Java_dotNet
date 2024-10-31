namespace exMobiliario;
public class Program
{
    public static void Main()
    {

        var pernas = new List<Perna>
        {
            new Perna("Perna dianteira esquerda"),
            new Perna("Perna dianteira direita"),
            new Perna("Perna traseira esquerda"),
            new Perna("Perna traseira direita")
        };

        var cadeira = new Cadeira("Cadeira de Madeira", 100.00, pernas);

        var mesa = new Mesas("Mesa de Jantar", 500.00);

        mesa.AdicionarCadeira(cadeira);
        
        mesa.DisplayInfo();

        mesa.RemoverCadeira(cadeira);
        mesa.DisplayInfo();
    }
}