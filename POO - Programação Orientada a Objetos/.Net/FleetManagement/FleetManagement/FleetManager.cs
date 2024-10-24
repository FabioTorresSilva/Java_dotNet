namespace FleetManagement
{
    class FleetManager
    {
        public readonly List<Vehicle> vehicles;

        public FleetManager()
        {
            vehicles = new List<Vehicle>();
        }

        public bool AddVehicle(Vehicle vehicle)
        {
            vehicles.Add(vehicle);
            return true;
        }

        public bool RemoveVehicle(Vehicle vehicle)
        {
            vehicles.Remove(vehicle);
            return true;
        }

        public void GetVehicleModelAndMake(string model, string make)
        {
            foreach (Vehicle vehicle in vehicles)
            {
                if (vehicle.Manufacturer == make && vehicle.Model == model)
                {
                    vehicle.DisplayVehicleInfo();
                }
            }
        }

        public int GetListSize()
        {
            return vehicles.Count();
        }

        public int GetNumberOfCars()
        {
            return vehicles.OfType<Car>().Count();
        }

        public void GetNumberOfMotorcycles()
        {
            Console.WriteLine(vehicles.OfType<Motorcycle>().Count());
        }

        public string DisplayAllVehiclesTypes()
        {
            foreach (Vehicle vehicle in vehicles)
            {
                return vehicle is Motorcycle ? "Motorcycle" : "Car";
            }
            return null;
        }

        public void DisplayAllVehiclesMoreThan10Years()
        {
            foreach (Vehicle vehicle in vehicles)
            {
                if (2024 - vehicle.Year > 10)
                {
                    Console.WriteLine(vehicle);
                }
            }
        }

        public void DisplayAllVehicles()
        {
            Console.WriteLine("------------------------------");
            foreach (var vehicle in vehicles)
            {
                vehicle.DisplayVehicleInfo();
            }
        }
    }
}
