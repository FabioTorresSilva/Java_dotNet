namespace TaxiManagment {
    internal class Engine : IDisplayable, IOperatable {

        public bool IsRunning { get; private set; }

        public string Manufacturer { get; private set; }

        public int HorsePower { get; private set; }

        public string FuelType { get; set; }

        public int CylinderCount { get; set; }

        public string SerialNumber { get; set; }

        public Engine(string manufacturer, int horsePower, string fuelType, int cylinderCount, string serialNumber) {
            Manufacturer = manufacturer;
            HorsePower = horsePower;
            FuelType = fuelType;
            CylinderCount = cylinderCount;
            SerialNumber = serialNumber;
            IsRunning = false;
        }

        public void Start() {
            IsRunning = true;
        }

        public void Stop() {
            IsRunning = false;
        }

        public void DisplayInfo() {
            Console.WriteLine("Engine info:");
            Console.WriteLine($"Manufacturer: {Manufacturer}");
            Console.WriteLine($"Horse power: {HorsePower}");
            Console.WriteLine($"Fuel type: {FuelType}");
            Console.WriteLine($"Cylinder count: {CylinderCount}");
            Console.WriteLine($"Serial number: {SerialNumber}");
        }

    }
}
