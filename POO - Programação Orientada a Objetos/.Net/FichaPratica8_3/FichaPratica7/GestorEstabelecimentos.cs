using ficha7.interfaces;

namespace FichaPratica7 {
    /// <summary>
    /// Classe não pedida no enunciado da ficha prática mas que serve de referência
    /// para a implementação de um gestor de estabelecimentos
    /// </summary>
    public class GestorEstabelecimentos {
        private readonly List<IEstabelecimento> estabelecimentos;

        public GestorEstabelecimentos() {
            estabelecimentos = new List<IEstabelecimento>();
        }

        public void AdicionarEstabelecimento(IEstabelecimento estabelecimento) {
            estabelecimentos.Add(estabelecimento);
        }

        public IEstabelecimento GetEstabelecimento(string nome) {
            foreach (IEstabelecimento estabelecimento in estabelecimentos) {
                if (estabelecimento.Nome.Equals(nome)) {
                    return estabelecimento;
                }
            }
            return null;
        }

        public List<IEstabelecimento> GetEstabelecimentosByType(Type tipo) {
            List<IEstabelecimento> estabelecimentosByType = [];
            foreach (IEstabelecimento estabelecimento in estabelecimentos) {
                if (tipo.IsInstanceOfType(estabelecimento)) {
                    estabelecimentosByType.Add(estabelecimento);
                }
            }
            return estabelecimentosByType;
        }

    }
}
