namespace TaxiManagment {
    public interface IVehicle : IDisplayable, IOperatable {
        string Color { get; }
        string Manufacturer { get; }
        string Model { get; }
        string PlateNumber { get; }
        string VIN { get; }
        int Year { get; }

        bool Equals(object? obj);
        int GetHashCode();
    }
}