namespace exMobiliario
{
    internal abstract class Mobiliario : IDisplayable
    {
        public String nome { get; set; }
        public double preco { get; set; }

        public Mobiliario(string nome, double preco)
        {
            this.nome = nome;
            this.preco = preco;
        }

        public abstract void DisplayInfo();
    }
}
