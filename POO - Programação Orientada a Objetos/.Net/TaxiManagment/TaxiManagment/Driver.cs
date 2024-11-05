namespace TaxiManagment {

    internal class Driver : Person {
        public string License { get; private set; }

        public Driver(string name, string license) : base(name) {
            License = license;
        }

        public override void DisplayInfo() {
            Console.WriteLine("Taxi driver info:");
            base.DisplayInfo();
            Console.WriteLine($"License: {License}");
        }

    }
}
