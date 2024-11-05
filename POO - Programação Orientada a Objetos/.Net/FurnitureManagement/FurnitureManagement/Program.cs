using FurnitureManagement;

internal class Program {
    private static void Main(string[] args) {

        Chair chair0 = new Chair("Chair0", 100.00m);
        chair0.DisplayInfo();

        chair0.AddLeg("desc 1");

        chair0.DisplayInfo();

        Chair chair1 = new Chair("Chair1", 100.00m, ["Leg 1", "Leg 2", "Leg 3", "Leg 4"]);
        Chair chair2 = new Chair("Chair2", 100.00m, ["Leg 1", "Leg 2", "Leg 3"]);
        Chair chair3 = new Chair("Chair3", 100.00m, ["Leg 1", "Leg 2", "Leg 3", "Leg 4"]);
        Chair chair4 = new Chair("Chair4", 100.00m, ["Leg 1", "Leg 2", "Leg 3", "Leg 4"]);

        Table table1 = new Table("Table1", 200.00m);
        table1.AddChair(chair1);
        table1.AddChair(chair2);
        table1.AddChair(chair3);
        table1.AddChair(chair4);

        Console.WriteLine("--------------------------------------------------");

        table1.DisplayInfo();

        Console.WriteLine("--------------------------------------------------");
        table1.RemoveChair(chair4);
        table1.DisplayInfo();

        Console.WriteLine("--------------------------------------------------");
        Table table2 = new Table("Table2", 200.00m);
        table2.AddChair(chair4);
        table2.DisplayInfo();

    }
}