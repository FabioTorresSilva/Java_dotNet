using FP01CSharp;

Data data1 = new Data(2024,10,15);

Console.WriteLine(data1);

Data data2 = new Data(1974, 04, 25);

Console.WriteLine(data2.ToAnoMesDiaString());

Console.WriteLine(data1.IsMaior(data2));

Console.WriteLine(data1.CalcularDiferenca(data2));

Console.WriteLine(data1.CalcularDiferenca(25, 12, 2024));

Console.WriteLine(data2.DeterminarDiaDaSemana());

Console.WriteLine(Data.IsAnoBissexto(1974));

Console.WriteLine(Data.IsAnoBissexto(data2.Ano));