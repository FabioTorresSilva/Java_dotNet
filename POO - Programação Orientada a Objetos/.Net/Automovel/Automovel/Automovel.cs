namespace FP01CSharp {
    internal class Automovel {
        private const string MatriculaPorOmissao = "sem matrícula";
        private const string MarcaPorOmissao = "sem marca";
        private const int CilindradaPorOmissao = 0;

        private static int _totalAutomoveis = 0;

        public Automovel(string matricula, string marca, int cilindrada) {
            this.Matricula = matricula;
            this.Marca = marca;
            this.Cilindrada = cilindrada;

            Automovel._totalAutomoveis++;
        }

        public Automovel(string matricula, string marca) : this(matricula, marca, CilindradaPorOmissao) {

        }

        public Automovel(string marca, int cilindrada) : this(MatriculaPorOmissao, marca, cilindrada) {

        }

        public Automovel() : this(MatriculaPorOmissao, MarcaPorOmissao, CilindradaPorOmissao) {

        }

        public string Matricula { get; set; }

        public string Marca { get; set; }

        public int Cilindrada { get; set; }

        public override string ToString() {
            return $"Automóvel com matrícula {Matricula} é um {Marca} e tem cilindrada de {Cilindrada} cc";
        }

        public int CalcularDiferencaCilindrada(Automovel outroAutomovel) {
            return Cilindrada - outroAutomovel.Cilindrada;
        }

        public bool IsCilindradaMaior(Automovel outroAutomovel) {
            return this.IsCilindradaMaior(outroAutomovel.Cilindrada);
        }

        public bool IsCilindradaMaior(int cilindrada) {
            return this.Cilindrada > cilindrada;
        }

        public static int GetTotalAutomoveis() {
            return _totalAutomoveis;
        }
    }
}
