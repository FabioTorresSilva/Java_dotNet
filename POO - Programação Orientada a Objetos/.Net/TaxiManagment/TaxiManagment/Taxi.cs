namespace TaxiManagment {
    internal class Taxi : Vehicle {

        public string TaxiNumber { get; private set; }

        public string TaxiLicense { get; private set; }

        private Driver? _driver;
        public Driver? Driver {
            get => _driver;
            set {
                if (value != null && !IsRunning) {
                    _driver = value;
                }
            }
            /**
            * public void SetDriver(Driver? driver) {
            * 
            *     if (driver != null && !IsRunning) {
            *         _driver = driver;
            *     }
            * }
            */
        }

        public override void Start() {
            if (Driver != null) {
                engine.Start();
            }
        }

        public override void Stop() {
            if (Driver != null) {
                engine.Stop();
            }
        }

        private readonly List<Passenger> Passengers;

        public int MaxPassengers { get; private set; }

        public int NumberOfPassengers {
            get {
                return Passengers.Count;
            }
        }

        public Taxi(string plateNumber, string manufacturer, string model, string color, int year, string registrationNumber, string engine_manufacturer, int horsePower, string fuelType, int cylinderCount, string serialNumber, string taxiNumber, string taxiLicense, int maxPassengers) : base(plateNumber, manufacturer, model, color, year, registrationNumber, engine_manufacturer, horsePower, fuelType, cylinderCount, serialNumber) {
            TaxiNumber = taxiNumber;
            TaxiLicense = taxiLicense;
            MaxPassengers = maxPassengers;
            Passengers = new List<Passenger>();
        }

        public void AddPassenger(Passenger passenger) {
            if (IsRunning == false && Passengers.IndexOf(passenger) == -1 &&
            Passengers.Count < MaxPassengers ) {
                Passengers.Add(passenger);
            }
        }

        public void RemovePassenger(Passenger passenger) {
            if (!IsRunning) {
                 Passengers.Remove(passenger);
            }
        }

        private void DisplayPassengers() {
            Console.WriteLine("Passengers:");
            foreach (Passenger passenger in Passengers) {
                DisplayUtility.DisplayWithHeaderAndFooter(passenger);
            }
        }

        private void DisplayDriver() {
            if (Driver != null) {
                DisplayUtility.DisplayWithHeaderAndFooter(Driver);
            }
        }

        public override void DisplayInfo() {
            Console.WriteLine("Taxi info:");
            base.DisplayInfo();
            Console.WriteLine($"Taxi number: {TaxiNumber}");
            Console.WriteLine($"Taxi license: {TaxiLicense}");
            Console.WriteLine($"Max passengers: {MaxPassengers}");
            Console.WriteLine($"Number of passengers: {NumberOfPassengers}");
            DisplayDriver();
            DisplayPassengers();
        }

    }

}
