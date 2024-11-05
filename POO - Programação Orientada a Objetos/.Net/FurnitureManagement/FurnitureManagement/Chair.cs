namespace FurnitureManagement {
    public class Chair : Furniture {
        public List<Leg> Legs { get; private set; }

        public Chair(string name, decimal price) : base(name, price) {
            Legs = new List<Leg>();
        }

        public Chair(string name, decimal price, string[] legs) : this(name, price) {
            foreach (string leg in legs) {
                AddLeg(leg);
            }
        }

        public void AddLeg(String desc) {
            Legs.Add(new Leg(desc));
        }

        public override void DisplayInfo() {
            base.DisplayInfo();
            Console.WriteLine($"\tNumber of Legs: {Legs.Count}");
            foreach (Leg leg in Legs) {
                leg.DisplayInfo();
            }
        }
    }
}
