namespace FurnitureManagement {
    public class Table : Furniture {

        public List<Chair> Chairs { get; set; }

        public Table(string name, decimal price) : base(name, price) {
            Chairs = new List<Chair>();
        }

        public void AddChair(Chair chair) {
            Chairs.Add(chair);
            Price += chair.Price;
        }

        public void RemoveChair(Chair chair) {
            Chairs.Remove(chair);
            Price -= chair.Price;
        }

        public override void DisplayInfo() {
            base.DisplayInfo();
            Console.WriteLine($"\tNumber of Chairs: {Chairs.Count}");
            foreach (Chair chair in Chairs) {
                chair.DisplayInfo();
            }
        }

    }
}
