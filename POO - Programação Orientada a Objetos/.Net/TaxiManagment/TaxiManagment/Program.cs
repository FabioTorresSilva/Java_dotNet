using TaxiManagment;

internal class Program {
    private static void Main(string[] args) {

        Taxi myTaxi = new Taxi("11-11-DD", "Mercedes", "A-Class", "Yellow", 2023, "123456789", "Mercedes", 220, "Diesel", 8, "987654321", "001", "L001", 3);

        Passenger passenger1 = new Passenger("John", "vat1");
        Passenger passenger2 = new Passenger("Mary", "vat2");
        Passenger passenger3 = new Passenger("Peter", "vat3");
        Passenger passenger4 = new Passenger("Jane", "vat4");

        Driver driver1 = new Driver("John", "license1");
        Driver driver2 = new Driver("Mary", "license2");

        myTaxi.Start();
        Console.WriteLine(myTaxi.IsRunning);

        myTaxi.Driver = driver1;
        Console.WriteLine(myTaxi.Driver);

        myTaxi.Start();
        Console.WriteLine(myTaxi.IsRunning);

        myTaxi.Stop();

        myTaxi.Driver = driver2;
        Console.WriteLine(myTaxi.Driver);

        myTaxi.AddPassenger(passenger1);
        Console.WriteLine(myTaxi.NumberOfPassengers);

        myTaxi.AddPassenger(passenger2);
        Console.WriteLine(myTaxi.NumberOfPassengers);

        myTaxi.AddPassenger(passenger3);
        Console.WriteLine(myTaxi.NumberOfPassengers);

        myTaxi.AddPassenger(passenger4);
        Console.WriteLine(myTaxi.NumberOfPassengers);

        myTaxi.RemovePassenger(passenger1);
        Console.WriteLine(myTaxi.NumberOfPassengers);

        myTaxi.DisplayInfo();

    }
}