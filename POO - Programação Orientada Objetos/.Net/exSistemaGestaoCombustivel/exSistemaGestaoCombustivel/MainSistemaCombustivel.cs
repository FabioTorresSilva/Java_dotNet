using FP02CSHARP;

Carro[] cars = new Carro[1];

for (int i = 0; i < 1; i++)
{
    Console.WriteLine($"Enter details for Car {i + 1}:");

    Console.Write("Enter Car Make:");
    string Make = Console.ReadLine();

    Console.Write("Car Model:");
    string Model = Console.ReadLine();

    Console.Write("Enter Car Year: ");
    int Year = int.Parse(Console.ReadLine());

    cars[i] = new Carro(Make, Model, Year);
    Console.WriteLine(cars[i]);


    double[] StoreConsumption = new double[12];

    for (int j = 0; j < StoreConsumption.Length; j++)
    {
        Console.Write($"Enter car Consumption Month{j + 1}");
        StoreConsumption[j] = double.Parse(Console.ReadLine());


        Console.WriteLine(StoreConsumption[j]);
    }
}

