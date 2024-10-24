using FleetManagement;

class Program
{
    static void Main()
    {
        FleetManager fleetManager = new FleetManager();

        Car car = new Car("Sedan", "Toyota", 2022, 4);
        Motorcycle motorcycle = new Motorcycle("Chopper", "Harley-Davidson", 2022, true);

        if (!fleetManager.AddVehicle(car))
        {
            Console.WriteLine($"Failed to add to fleet: {car}");
        }

        if (!fleetManager.AddVehicle(motorcycle))
        {
            Console.WriteLine($"Failed to add to fleet: {motorcycle}");
        }

        fleetManager.DisplayAllVehicles();

        fleetManager.GetNumberOfMotorcycles();

        fleetManager.GetVehicleModelAndMake("Sedan", "Toyota");

        Console.WriteLine(fleetManager.GetListSize());
    }
}