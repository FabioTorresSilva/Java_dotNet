namespace TaxiManagment
{
    internal abstract class Vehicle : IVehicle
    {

        public string VIN { get; private set; }

        public string PlateNumber { get; private set; }

        public string Manufacturer { get; private set; }

        public string Model { get; private set; }

        public string Color { get; private set; }

        public int Year { get; private set; }

        public bool IsRunning => engine.IsRunning;

        protected readonly Engine engine;

        protected Vehicle(string plateNumber, string manufacturer, string model, string color, int year, string vin, string engine_manufacturer, int horsePower, string fuelType, int cylinderCount, string serialNumber)
        {
            PlateNumber = plateNumber;
            Manufacturer = manufacturer;
            Model = model;
            Color = color;
            Year = year;
            VIN = vin;
            engine = new Engine(engine_manufacturer, horsePower, fuelType, cylinderCount, serialNumber);
        }

        public virtual void DisplayInfo()
        {
            Console.WriteLine("Vehicle info:");
            Console.WriteLine($"VIN: {VIN}");
            Console.WriteLine($"Plate number: {PlateNumber}");
            Console.WriteLine($"Manufacturer: {Manufacturer}");
            Console.WriteLine($"Model: {Model}");
            Console.WriteLine($"Color: {Color}");
            Console.WriteLine($"Year: {Year}");
            engine.DisplayInfo();
        }

        public abstract void Start();

        public abstract void Stop();

        public override bool Equals(object? obj)
        {
            return obj is Vehicle vehicle &&
                   VIN == vehicle.VIN;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(VIN);
        }
    }
}
