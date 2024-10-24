namespace FleetManagement {
    class Motorcycle : Vehicle {
        public bool HasSideCar { get; set; }

        public Motorcycle(string model, string manufacturer, int year, bool hasSideCar)
            : base(model, manufacturer, year) {
            HasSideCar = hasSideCar;
        }

        public override void Start() {
            Console.WriteLine("Motorcycle engine started.");
        }

        public override void Stop() {
            Console.WriteLine("Motorcycle engine stopped.");
        }

        public override void DisplayVehicleInfo() {
            base.DisplayVehicleInfo();
            Console.WriteLine($"Has Side Car: {HasSideCar}");
        }
    }
}
