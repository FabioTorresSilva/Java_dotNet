namespace TaxiManagment {
    internal abstract class Person : IDisplayable {

        public string Name { get; private set; }

        protected Person(string name) {
            Name = name;
        }

        public virtual void DisplayInfo() {
            Console.WriteLine($"Name: {Name}");
        }

    }
}
