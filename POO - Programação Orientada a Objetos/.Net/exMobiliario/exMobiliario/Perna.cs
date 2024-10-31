
namespace exMobiliario
{
    internal class Perna : IDisplayable
    {
        public string Descricao { get; set; }

        public Perna(string descricao)
        {
            Descricao = descricao;
        }
        public void DisplayInfo()
        {
            Console.WriteLine($"Perna - Descrição: {Descricao}");
        }
    }
}
