using System.Text;

namespace FP02CSHARP

{
    internal class Carro
    {
        string Make;
        string Model;
        int Year;
        double[] FuelConsumption = new double[12];

        public Carro(string Make, string Model, int Year)
        {
            this.Make = Make;
            this.Model = Model;
            this.Year = Year;
            this.FuelConsumption = FuelConsumption;
        }

        public string AddFuel(double gallons, int month)
        {
            FuelConsumption[month] = gallons;
            return $"Fuel added in {month + 1}";
        }


        public String CalculateMonthlyReports()
        {
            StringBuilder report = new StringBuilder();

            for (int i = 0; i < FuelConsumption.Length; i++)
            {
                report.AppendLine($"Consumo mês {i + 1}: {FuelConsumption[i]}");
            }

            return report.ToString();
        }

        public String CalculateAverageConsumption()
        {
            double sum = 0;
            for (int i = 0; i < FuelConsumption.Length; i++)
            {
                sum += FuelConsumption[i];
            }
            return $"Média Consumo anual: {sum / FuelConsumption.Length} e qweqwewqe {FuelConsumption.Length}";
        }

        public String DisplayMonthlyReports()
        {

            return $"Combustivel Consumido por cada mês \n {CalculateMonthlyReports} \n Média consumo anual {CalculateAverageConsumption}";
        }

        public override string ToString()
        {
            return $"Carro {Make} {Model} de {Year}";
        }

    }
}