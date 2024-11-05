namespace ficha7.interfaces;

/// <summary>
/// Interface que representa um estabelecimento
/// </summary>
public interface IEstabelecimento {
    string Nome { get; }

    string Localizacao { get; }

    int NumeroFuncionarios { get; set; }

    /// <summary>
    /// Regista as vendas de um estabelecimento
    /// </summary>
    /// <param name="valorVendas">Valor das vendas em euros</param>
    /// <param name="dataVenda">Data em que foi registo o total das vendas</param>
    /// <returns>True se o valor das vendas for adicionada, False se a Data já existir</returns>
    bool RegistarVenda(DateOnly dataVenda, double valorVendas);

    string RelatorioVendas(int mes);

    List<double> GetValorVendas();
}