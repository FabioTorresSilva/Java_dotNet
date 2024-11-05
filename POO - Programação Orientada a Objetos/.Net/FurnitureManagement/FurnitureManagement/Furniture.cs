namespace FurnitureManagement {
    public abstract class Furniture : IDisplayable {

        public string Name { get; protected set; }
        public decimal Price { get; protected set; }

        protected Furniture(string name, decimal price) {
            Name = name;
            Price = price;
        }

        public virtual void DisplayInfo() {
            Console.WriteLine($"Name: {Name}, Price: ${Price}");
        }
    }
}
