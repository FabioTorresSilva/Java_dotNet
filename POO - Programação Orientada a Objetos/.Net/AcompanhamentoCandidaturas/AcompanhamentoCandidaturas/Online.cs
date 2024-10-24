namespace Acompanhamentos
{
    class Online : Candidatura
    {
        public string Email { get; }
        public string Estado { get; set; }

        public Online(string Organizacao, string Posicao,
            int Referencia, string Descricao,
            DateTime DataCandidatura, string Email, string Estado)
            : base(Organizacao, Posicao, Referencia, Descricao, DataCandidatura)
        {
            this.Email = Email;
            this.Estado = Estado;
        }
    }
}