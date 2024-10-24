namespace FleetManagement
{
    abstract class Vehicle
    {
        public string Model { get; set; }
        public string Manufacturer { get; set; }
        public int Year { get; set; }

        protected Vehicle(string model, string manufacturer, int year)
        {
            this.Model = model;
            this.Manufacturer = manufacturer;
            this.Year = year;
        }

        public abstract void Start();
        public abstract void Stop();

        public virtual void DisplayVehicleInfo()
        {
            Console.WriteLine($"Model: {Model}");
            Console.WriteLine($"Manufacturer: {Manufacturer}");
            Console.WriteLine($"Year: {Year}");
        }
    }
}
