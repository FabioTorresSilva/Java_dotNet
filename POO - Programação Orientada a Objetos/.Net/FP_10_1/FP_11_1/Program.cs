namespace FP_11_1;
public static class Program {

    private static void exemplo_1() {
        Encomenda enc = new Encomenda { Id = 1, Descricao = "Pizza Marguerita" };
        Console.WriteLine(enc);

        enc.AlterarEstado(Estado.EmPreparacao);
        Console.WriteLine(enc);

        enc.AlterarEstado(Estado.Concluida);
        Console.WriteLine(enc);
    }

    private static void exemplo_2() {
        Produto produto1 = new Produto {
            Nome = "Smartphone",
            Preco = 799.99m,
            Categoria = Categoria.Eletronicos
        };

        Produto produto2 = new Produto {
            Nome = "Camiseta",
            Preco = 29.99m,
            Categoria = Categoria.Roupas
        };

        Produto produto3 = new Produto {
            Nome = "Maçã",
            Preco = 1.50m,
            Categoria = (Categoria)2
        };

        Console.WriteLine(produto1);
        Console.WriteLine(produto2);
        Console.WriteLine(produto3);

        Console.WriteLine((Categoria)produto1.ObterPrioridade());

        foreach (var name in Enum.GetValues(typeof(Categoria))) {
            Console.WriteLine($"{(int)name} {name}");
        }

    }

    private static void exemplo_3() {
        Servico servico1 = new Servico {
            Nome = "Atendimento ao Cliente",
            Avaliacao = NivelAvaliacao.Excelente
        };

        Servico servico2 = new Servico {
            Nome = "Limpeza",
            Avaliacao = NivelAvaliacao.Regular
        };

        Console.WriteLine($"{servico1.Nome}: {servico1.ObterDescricao()}");
        Console.WriteLine($"{servico2.Nome}: {servico2.ObterDescricao()}");

        NivelAvaliacao avaliacaoTeste = (NivelAvaliacao)4; // Valor que não está definido no enum

        bool isValido = Enum.IsDefined(typeof(NivelAvaliacao), avaliacaoTeste);
        Console.WriteLine($"A avaliação {avaliacaoTeste} é válida? {isValido}");
    }

    static void Main(string[] args) {
        exemplo_1();
        exemplo_2();
        exemplo_3();
    }
}