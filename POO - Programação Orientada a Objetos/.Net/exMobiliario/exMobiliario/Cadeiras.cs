
namespace exMobiliario
{
    internal class Cadeira : Mobiliario
    {
        public List<Perna> Pernas { get; set; }

        public Cadeira(string nome, double preco, List<Perna> pernas) : base(nome, preco)
        {
            Pernas = pernas;
        }

        public override void DisplayInfo()
        {
            Console.WriteLine($"Cadeira - Nome: {nome}, Preço: {preco:C}, Número de Pernas: {Pernas.Count}");
            foreach (var perna in Pernas)
            {
                perna.DisplayInfo();
            }
        }
    }
}
