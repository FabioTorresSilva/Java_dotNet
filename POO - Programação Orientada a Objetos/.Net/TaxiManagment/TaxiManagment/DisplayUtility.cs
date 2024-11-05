namespace TaxiManagment {
    internal static class DisplayUtility {

        private const string Header = "------------------------------";
        private const string Footer = "------------------------------";

        public static void DisplayWithHeaderAndFooter(IDisplayable displayable) {
            Console.WriteLine(Header);
            displayable.DisplayInfo();
            Console.WriteLine(Footer);
        }
    }
}
