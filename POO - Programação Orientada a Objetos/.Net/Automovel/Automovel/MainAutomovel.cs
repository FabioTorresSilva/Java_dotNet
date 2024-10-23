using FP01CSharp;


Automovel a1 = new Automovel("11 - 11 - AA", "Toyota" , 1400);

Console.WriteLine(a1);

Console.WriteLine(a1.Matricula);

Console.WriteLine(Automovel.GetTotalAutomoveis());

Automovel a2 = new Automovel("22-22-BB", "Audi");

Console.WriteLine(a2);

a2.Cilindrada = 1800;

Console.WriteLine(a2);

Console.WriteLine(Automovel.GetTotalAutomoveis());

Console.WriteLine(Math.Abs(a1.CalcularDiferencaCilindrada(a2)));

if (a1.IsCilindradaMaior(a2))
{
    Console.WriteLine(a1.Matricula);
}
else
{
    Console.WriteLine(a2.Matricula);
}

Console.WriteLine(a1.IsCilindradaMaior(1200));
