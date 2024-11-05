using ficha7.interfaces;
using FichaPratica7;

SuperMercado superMercado = new SuperMercado("Supermercado", "Rua do Supermercado", 10, 5, 0.5f);
HiperMercado hiperMercado = new HiperMercado("Hipermercado", "Rua do Hipermercado", 20, 10, 0.5f, 5);
Cafe cafe = new Cafe("Cafe", "Rua do Cafe", 5, 5, 0.5f);

superMercado.RegistarVenda(new DateOnly(2021, 10, 10), 40);
superMercado.RegistarVenda(new DateOnly(2021, 10, 11), 20);
superMercado.RegistarVenda(new DateOnly(2021, 10, 12), 10);

Console.WriteLine(superMercado.RelatorioVendas(10));

foreach (double valor in superMercado.GetValorVendas()) {
    Console.WriteLine(valor);
}

GestorEstabelecimentos gestorEstabelecimentos = new GestorEstabelecimentos();
gestorEstabelecimentos.AdicionarEstabelecimento(superMercado);
gestorEstabelecimentos.AdicionarEstabelecimento(hiperMercado);
gestorEstabelecimentos.AdicionarEstabelecimento(cafe);

Console.WriteLine(cafe.GerarChave());

List<IEstabelecimento> supermercados = gestorEstabelecimentos.GetEstabelecimentosByType(typeof(SuperMercado));

foreach (IEstabelecimento estabelecimento in supermercados) {
    Console.WriteLine(estabelecimento.Nome);
}
