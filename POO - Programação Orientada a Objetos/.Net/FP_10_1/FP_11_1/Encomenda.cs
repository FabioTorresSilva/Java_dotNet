namespace FP_11_1 {
    internal class Encomenda {

        public int Id { get; init; }
        public string? Descricao { get; set; }
        public Estado Estado { get; private set; }

        public Encomenda() {
            Estado = Estado.Pendete;
        }

        public void AlterarEstado(Estado novoEstado) {
            Estado = novoEstado;
        }

        public override string ToString() {
            return $"ID: {Id}, Des.: {Descricao}, Estado: {Estado}";
        }

    }
}
