namespace FleetManagement {
    class Car : Vehicle {
        public int NumberOfDoors { get; set; }

        public Car(string model, string manufacturer, int year, 
        int numberOfDoors)
            : base(model, manufacturer, year) {
            NumberOfDoors = numberOfDoors;
        }

        public override void Start() {
            Console.WriteLine("Car engine started.");
        }

        public override void Stop() {
            Console.WriteLine("Car engine stopped.");
        }

        public override void DisplayVehicleInfo() {
            base.DisplayVehicleInfo();
            Console.WriteLine($"Number of Doors: {NumberOfDoors}");
        }
    }
}
