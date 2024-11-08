namespace FP_11_1 {
    internal class Produto {

        public string? Nome { get; set; }
        public decimal Preco { get; set; }
        public Categoria Categoria { get; set; }

        public int ObterPrioridade() {
            return (int)Categoria;
        }

        public override string ToString() {
            return $"Nome: {Nome}, Preço: {Preco}, Categoria: {Categoria}, Prioridade: {ObterPrioridade()}";
        }

    }
}
