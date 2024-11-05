namespace FurnitureManagement {
    public class Leg : IDisplayable {
        public string Description { get; set; }

        public Leg(string name) {
            Description = name;
        }

        public void DisplayInfo() {
            Console.WriteLine($"\tLeg description: {Description}");
        }
    }
}
