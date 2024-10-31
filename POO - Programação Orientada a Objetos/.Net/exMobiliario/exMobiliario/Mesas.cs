namespace exMobiliario
{
    internal class Mesas : Mobiliario
    {
        public List<Cadeira> Cadeiras { get; private set; }

        public Mesas(string nome, double preco) : base(nome, preco)
        {
        }
        public void AdicionarCadeira(Cadeira cadeira)
        {
            Cadeiras.Add(cadeira);
            preco += cadeira.preco;
        }

        public void RemoverCadeira(Cadeira cadeira)
        {
            if (Cadeiras.Remove(cadeira))
            {
                preco -= cadeira.preco;
            }
        }

        public override void DisplayInfo()
        {
            Console.WriteLine($"Mesa: {nome}, Preço: {preco:C}, Número de Cadeiras: {Cadeiras.Count}");
            foreach (var cadeira in Cadeiras)
            {
                cadeira.DisplayInfo();
            }
        }
    }
}
