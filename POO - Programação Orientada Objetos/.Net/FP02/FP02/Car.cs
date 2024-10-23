namespace FP02
{
    internal class Car
    {
        private const int MonthsInYear = 12;

        public string Make { get; }
        public string Model { get; }
        public int Year { get; }

        private readonly double[] FuelConsumption;

        public Car(string make, string model, int year)
        {
            Make = make;
            Model = model;
            Year = year;
            FuelConsumption = new double[MonthsInYear];
            for (int i = 0; i < FuelConsumption.Length; i++)
            {
                FuelConsumption[i] = 0;
            }
        }

        public void AddFuelInput(double gallons, int month)
        {
            if (month > 0 && month <= MonthsInYear)
            {
                FuelConsumption[month - 1] += gallons;
            }
            else
            {
                Console.WriteLine("Invalid month. Month should be between 1 and 12.");
            }
        }

        public double[] CalculateMonthlyReports()
        {
            return FuelConsumption;
        }

        public double CalculateAverageConsumption()
        {
            double totalGallons = 0;
            foreach (double gallons in FuelConsumption)
            {
                totalGallons += gallons;
            }
            return totalGallons / MonthsInYear;
        }

        public void DisplayMonthlyReports()
        {
            double[] monthlyReports = CalculateMonthlyReports();
            double averageConsumption = CalculateAverageConsumption();

            Console.WriteLine($"Monthly Fuel Consumption Reports for {Year} {Make} {Model}:");
            for (int month = 0; month < monthlyReports.Length; month++)
            {
                Console.WriteLine($"Month {month + 1}: {monthlyReports[month]} gallons");
            }

            Console.WriteLine($"Average Fuel Consumption for the Year: {averageConsumption} gallons");
        }
    }
}
