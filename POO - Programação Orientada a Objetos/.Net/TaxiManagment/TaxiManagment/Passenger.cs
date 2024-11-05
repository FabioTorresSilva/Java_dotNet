
namespace TaxiManagment {
    internal class Passenger : Person {

        public string VAT { get; private set; }

        public Passenger(string name, string vat) : base(name) {
            VAT = vat;
        }

        public override void DisplayInfo() {
            Console.WriteLine("Passenger info:");
            base.DisplayInfo();
            Console.WriteLine($"VAT: {VAT}");
        }

        public override bool Equals(object? obj) {
            return obj is Passenger passenger &&
                   VAT == passenger.VAT;
        }

        public override int GetHashCode() {
            return HashCode.Combine(VAT);
        }
    }
}
