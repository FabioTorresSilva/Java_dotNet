namespace FP_11_1 {
    internal class Servico {
        public string? Nome { get; set; }
        public NivelAvaliacao Avaliacao { get; set; }

        public string ObterDescricao() {
            switch (Avaliacao) {
                case NivelAvaliacao.Excelente:
                    return "O serviço foi avaliado como excelente!";
                case NivelAvaliacao.Bom:
                    return "O serviço foi avaliado como bom.";
                case NivelAvaliacao.Regular:
                    return "O serviço foi avaliado como regular.";
                case NivelAvaliacao.Mau:
                    return "O serviço foi avaliado como ruim.";
                default:
                    return "Avaliação desconhecida.";
            }
        }
    }
}
