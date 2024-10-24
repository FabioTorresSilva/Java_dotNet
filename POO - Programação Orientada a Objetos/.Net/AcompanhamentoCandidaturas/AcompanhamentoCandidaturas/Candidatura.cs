
namespace Acompanhamentos
{
    abstract class Candidatura
    {
        public string Organizacao { get; }
        public string Posicao { get; }
        public int Referencia { get; }
        public string Descricao { get; set; }
        public DateTime DataCandidatura { get; }

        public Candidatura(string Organizacao, string Posicao, int Referencia, string Descricao, DateTime DataCandidatura)
        {
            this.Organizacao = Organizacao;
            this.Posicao = Posicao;
            this.Referencia = Referencia;
            this.Descricao = Descricao;
            this.DataCandidatura = DataCandidatura;
        }

        public override string ToString()
        {
            return $"Organização: {Organizacao}\n" +
                   $"Posição: {Posicao}\n" +
                   $"Referência: {Referencia}\n" +
                   $"Descrição: {Descricao}\n" +
                   $"Data de Candidatura: {DataCandidatura.ToString("dd/MM/yyyy")}";
        }


    }
}
